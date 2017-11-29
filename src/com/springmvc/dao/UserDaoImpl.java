package com.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.springmvc.entity.User;

/***
 * UserDao接口类的实现 
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;  

	//SessionFactroy接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象。这里用到了工厂模式。
	public void setSessionFactory(SessionFactory sessionFactory) {  
		this.sessionFactory = sessionFactory;  
	}  

	/**
	 * 根据用户id查询用户
	 */
	public User getUser(String id) {  

		//创建一个只有一个查询条件（ID）的查询；
		String hql = "from User u where u.id=?";  
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
		query.setString(0, id);
		
		return (User)query.uniqueResult();  
	}  

	/**
	 * 查询所有用户
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {  

		String hql = "from User";  
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  

		return query.list();  
	}  

	/**
	 * 添加用户
	 */
	public void addUser(User user) {  
		sessionFactory.getCurrentSession().save(user);  
	}  

	/**
	 * 根据用户id删除用户
	 */
	public boolean delUser(String id) {  

		String hql = "delete User u where u.id = ?";  
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
		query.setString(0, id);  

		return (query.executeUpdate() > 0);  
	}  

	/**
	 * 编辑用户
	 */
	public boolean updateUser(User user) {  

		String hql = "update User u set u.userName = ?,u.age=?,u.Telephone=? where u.id = ?";  
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
		query.setString(0, user.getUserName());  
		query.setString(1, user.getAge());  
		query.setString(2, user.getTelephone());
		query.setString(3, user.getId()); 
		return (query.executeUpdate() > 0);  
	}  

}