package com.springmvc.service;

import java.util.List;
import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;

/***
 * 接口UserManager的实现；
 * @author huoliming
 *
 */
public class UserManagerImpl implements UserManager {

	private UserDao userDao;  

	//获得数据对象实例；
	public void setUserDao(UserDao userDao) {  
		this.userDao = userDao;  
	}  

	//通过ID号得到用户对象；
	public User getUser(String id) {  
		return userDao.getUser(id);  
	}  

	//得到所有数据并以链表形式返回；
	public List<User> getAllUser() {  
		return userDao.getAllUser();  
	}  

	//添加用户对象；
	public void addUser(User user) {  
		userDao.addUser(user);  
	}  

	//通过ID号删除对象；
	public boolean delUser(String id) {  

		return userDao.delUser(id);  
	}  

	//更新数据；
	public boolean updateUser(User user) {  
		return userDao.updateUser(user);  
	}  

}
