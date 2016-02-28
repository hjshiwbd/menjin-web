package org.shinomin.menjin.user.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.commons.utils.CryptogramUtil;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.commons.web.util.PageUtil;
import org.shinomin.menjin.bean.MenuBean;
import org.shinomin.menjin.bean.UserBean;
import org.shinomin.menjin.constant.MenjinConstant;
import org.shinomin.menjin.exception.ValidationException;
import org.shinomin.menjin.menu.service.IMenuService;
import org.shinomin.menjin.spring.session.LoginSessionScope;
import org.shinomin.menjin.user.dao.IUserDAO;
import org.shinomin.menjin.user.service.IUserService;
import org.shinomin.menjin.xtkz.controller.EasyuiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-20 21:25:57
 * 
 */
@Service
public class UserServiceImpl implements IUserService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private final String TWO_PASS_NOT_EQUAL = "两个密码不相同";
	private final String OLD_PASS_INVALID = "老密码错误";

	@Autowired
	private IUserDAO userDAO;
	@Autowired
	private LoginSessionScope loginSessionScope;
	@Autowired
	private IMenuService menuService;

	@Override
	public UserBean selectOne(UserBean user) {
		return userDAO.selectOne(user);
	}

	@Override
	public List<UserBean> selectList(UserBean user) {
		return userDAO.selectList(user);
	}

	@Override
	public Pager<UserBean> selectPage(UserBean user, Pager<UserBean> pager) {
		return userDAO.selectPage(user, pager);
	}

	@Override
	public int insert(UserBean user) {
		return userDAO.insert(user);
	}

	@Override
	public int update(UserBean user) {
		return userDAO.update(user);
	}

	@Override
	public int delete(UserBean user) {
		return userDAO.delete(user);
	}

	@Override
	public String changeMima(String oldPassword, String newPassword, String newPassword2) {
		logger.info("oldPassword:{}, newPassword:{}, newPassword2:{}", oldPassword, newPassword, newPassword2);
		String errMsg = "";
		ExecuteResult er = new ExecuteResult("0", "");
		try {
			if (checkParam(oldPassword, newPassword, newPassword2)) {
				if (checkOldPass(oldPassword)) {
					UserBean updateuser = new UserBean();
					updateuser.setId(loginSessionScope.getLoginUser().getId());
					updateuser.setPassword(CryptogramUtil.encryptHexStr(newPassword));
					int n = update(updateuser);
					if (n == 1) {
						er.setResult("1");
						er.setMessage("修改成功");
						return JsonUtil.toJson(er);
					} else {
						logger.info("update user pass n:{}", n);
						errMsg = "修改密码出错";
					}
				} else {
					errMsg = OLD_PASS_INVALID;
				}
			}
		} catch (ValidationException e) {
			errMsg = e.getMessage();
		} catch (Exception e) {
			errMsg = "系统异常，请稍候再试";
		}
		er.setMessage(errMsg);
		return JsonUtil.toJson(er);
	}

	/**
	 * 检查老密码正确性
	 * 
	 * @param oldPassword
	 * @return
	 */
	private boolean checkOldPass(String oldPassword) {
		String reqpass = CryptogramUtil.encryptHexStr(oldPassword);
		String dbpass = loginSessionScope.getLoginUser().getPassword();
		return reqpass.equals(dbpass);
	}

	/**
	 * 检查入参正确性
	 * 
	 * @param oldPassword
	 * @param newPassword
	 * @param newPassword2
	 * @return
	 * @throws ValidationException
	 */
	private boolean checkParam(String oldPassword, String newPassword, String newPassword2) throws ValidationException {
		if (StringUtils.isBlank(oldPassword)) {
			logger.info("oldPassword is empty");
			throw new ValidationException(OLD_PASS_INVALID);
		}
		if (StringUtils.isBlank(newPassword)) {
			logger.info("newPassword is empty");
			throw new ValidationException(TWO_PASS_NOT_EQUAL);
		}
		if (StringUtils.isBlank(newPassword2)) {
			logger.info("newPassword2 is empty");
			throw new ValidationException(TWO_PASS_NOT_EQUAL);
		}
		if (!StringUtils.equals(newPassword, newPassword2)) {
			logger.info("newPassword != newPassword2");
			throw new ValidationException(TWO_PASS_NOT_EQUAL);
		}
		return true;
	}

	@Override
	public String queryListEu(Integer page, Integer rows, UserBean user) {
		Pager<UserBean> pager = new Pager<>();
		pager.setCurtPage(page);
		pager.setCountPerPage(rows);
		user.setSql("and username != 'admin'");
		selectPage(user, pager);
		return EasyuiUtil.parseDatagrid(pager);
	}

	@Override
	public String doAdd(UserBean user) {
		logger.info("user:{}", JsonUtil.toJson(user));
		ExecuteResult e = new ExecuteResult("0", "");
		try {
			checkParamAdd(user);
		} catch (Exception e1) {
			logger.info(e1.getMessage());
			e.setMessage(e1.getMessage());
			return JsonUtil.toJson(e);
		}

		user.setPassword(CryptogramUtil.encryptHexStr(MenjinConstant.DEFAULT_USER_PASSWORD));
		int n = insert(user);
		if (n > 0) {
			e.setResult("1");
			e.setMessage("添加成功,默认密码888888");
		} else {
			e.setMessage("添加失败，请稍候再试");
		}

		return JsonUtil.toJson(e);
	}

	private void checkParamAdd(UserBean user) throws Exception {
		if (StringUtils.isBlank(user.getUsername())) {
			throw new Exception("用户名不能为空");
		}
		int n = userDAO.selectCount("mjsq_user", "where username=?", user.getUsername());
		if (n > 0) {
			throw new Exception("用户名已被使用");
		}
	}

	@Override
	public String doResetPass(UserBean user) {
		logger.info("user:{}", JsonUtil.toJson(user));
		ExecuteResult e = new ExecuteResult("0", "");
		try {
			checkParamReset(user);
		} catch (Exception e1) {
			logger.info(e1.getMessage());
			e.setMessage(e1.getMessage());
			return JsonUtil.toJson(e);
		}
		UserBean old = new UserBean();
		old.setUsername(user.getUsername());
		old = selectOne(old);

		UserBean update = new UserBean();
		update.setId(old.getId());
		update.setUsername(user.getUsername());
		update.setPassword(CryptogramUtil.encryptHexStr(MenjinConstant.DEFAULT_USER_PASSWORD));
		int n = update(update);
		if (n > 0) {
			e.setResult("1");
			e.setMessage("重置成功,密码为888888");
		} else {
			e.setMessage("重置失败，请稍候再试");
		}

		return JsonUtil.toJson(e);
	}

	private void checkParamReset(UserBean user) throws Exception {
		if (StringUtils.isBlank(user.getUsername())) {
			throw new Exception("请求有误,请刷新后重试");
		}
	}

	@Override
	public String doDelete(UserBean user) {
		logger.info("user:{}", JsonUtil.toJson(user));
		ExecuteResult e = new ExecuteResult("0", "");
		if (StringUtils.isBlank(user.getUsername())) {
			e.setMessage("请求参数有误,请刷新后重试");
			return JsonUtil.toJson(e);
		}

		UserBean old = new UserBean();
		old.setUsername(user.getUsername());
		old = selectOne(old);

		int n = delete(old);
		if (n > 0) {
			e.setResult("1");
			e.setMessage("删除成功");
		} else {
			e.setMessage("重置失败，请稍候再试");
		}

		return JsonUtil.toJson(e);
	}

	@Override
	public ModelAndView showList() {
		ModelAndView model = new ModelAndView();

		MenuBean menu = new MenuBean();
		menu.setStatus("1");
		List<MenuBean> menuList = menuService.selectList(menu);
		model.addObject("menuList", menuList);
		model.addObject("json_script", PageUtil.create_SCRIPT_PARSE_JSON(model.getModelMap()));

		model.setViewName("user/user_list");
		return model;
	}
}
