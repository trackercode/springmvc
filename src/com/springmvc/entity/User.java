package com.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * 此实体的定义应用了springmvc的注解，省去了传统的Hibernate跟数据库之间的映射配置文件
 * @author huoliming
 * 表名T_USER、实体类名User;以后的DAO具体SQL实现中，表名就用User代替了，还不是T_USER；
 */
@Entity  
@Table(name="T_USER")  
public class User {  

	//ID号自动生成，UUID：Universally Unique Identifier，是指在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的
	@Id  
	@GeneratedValue(generator="system-uuid")  
	@GenericGenerator(name = "system-uuid",strategy="uuid")  
	@Column(length=32)  
	private String id;  

	@Column(length=32)  
	private String userName;  

	@Column(length=32)  
	private String age; 
	
	@Column(length=32)
	private String Telephone;

	/***
	 * ID的属性
	 * @return
	 */
	public String getId() {  
		return id;  
	}  

	public void setId(String id) {  
		this.id = id;  
	}  

	/***
	 * UserName的属性；
	 * @return
	 */
	public String getUserName() {  
		return userName;  
	}  

	public void setUserName(String userName) {  
		this.userName = userName;  
	}  

	/**
	 * Age的属性；
	 * @return
	 */
	public String getAge() {  
		return age;  
	}  

	public void setAge(String age) {  
		this.age = age;  
	}
	
	/***
	 * Telephone属性
	 * @return
	 */
	public String getTelephone(){
		return Telephone;
	}
	public  void setTelephone(String phone){
		this.Telephone=phone;
	}
}