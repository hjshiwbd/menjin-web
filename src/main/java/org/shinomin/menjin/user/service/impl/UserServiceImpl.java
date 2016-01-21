package org.shinomin.menjin.user.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.commons.utils.CryptogramUtil;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.menjin.bean.UserBean;
import org.shinomin.menjin.exception.ValidationException;
import org.shinomin.menjin.spring.session.LoginSessionScope;
import org.shinomin.menjin.user.dao.IUserDAO;
import org.shinomin.menjin.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
