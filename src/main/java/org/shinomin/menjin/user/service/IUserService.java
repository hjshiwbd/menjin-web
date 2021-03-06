package org.shinomin.menjin.user.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.UserBean;
import org.shinomin.menjin.bean.UserresourceBean;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-20 21:25:57
 * 
 */
public interface IUserService
{
	/**
	 * simple
	 * 
	 * @param user
	 * @return
	 */
	public UserBean selectOne(UserBean user);

	/**
	 * simple
	 * 
	 * @param user
	 * @return
	 */
	public List<UserBean> selectList(UserBean user);

	/**
	 * simple
	 * 
	 * @param user
	 * @param pager
	 * @return
	 */
	public Pager<UserBean> selectPage(UserBean user, Pager<UserBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(UserBean user);

	/**
	 * simple
	 * 
	 * @param user
	 * @return
	 */
	public int update(UserBean user);

	/**
	 * simple
	 * 
	 * @param user
	 * @return
	 */
	public int delete(UserBean user);

	/**
	 * 改密码
	 * 
	 * @param oldPassword
	 * @param newPassword
	 * @param newPassword2
	 * @return
	 */
	public String changeMima(String oldPassword, String newPassword, String newPassword2);

	public String queryListEu(Integer page, Integer rows, UserBean user);

	public String doAdd(UserBean user);

	public String doResetPass(UserBean user);

	public String doDelete(UserBean user);

	public ModelAndView showList();

	public String saveQx(String json);

	public String queryUserQx(UserresourceBean ur);

}
