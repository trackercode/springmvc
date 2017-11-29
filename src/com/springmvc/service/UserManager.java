package com.springmvc.service;

import java.util.List;
import com.springmvc.entity.User;

/***
 * 定义用户管理接口；
 * @author huoliming
 * 
 */
public interface UserManager {  
	

	//通过指定ID号得到此用户信息；
	public User getUser(String id);  

	//得到所有用户信息以链表的形式返加；
	public List<User> getAllUser();  

	//添加一个对象；
	public void addUser(User user);  

	//删除一个对象；
	public boolean delUser(String id);  

	//更新数据；
	public boolean updateUser(User user);  
}
