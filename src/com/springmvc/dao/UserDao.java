package com.springmvc.dao;

import java.util.List;

import com.springmvc.entity.User;
/***
 * 定义UserDao类接口及其方法；
 * @author Administrator
 *
 */
public interface UserDao {

	//通过ID得到对象；
	public User getUser(String id);  

	//得到所有对象；
	public List<User> getAllUser();  

	//添加用户；
	public void addUser(User user);  

	//通过ID号删除对象；
	public boolean delUser(String id);  

	//更新对象数据；
	public boolean updateUser(User user);
}