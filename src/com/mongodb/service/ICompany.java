/**
 * AbstractRepository.java
 * 版权所有(C) 2012 
 * 创建:cuiran 2012-12-12 11:40:40
 */
package com.mongodb.service;

import java.util.List;

import com.mongodb.entity.Company;

/**
 * TODO
 * @author xie
 * @version TODO
 */
public interface ICompany {
	
	/**
	 * 获取所有公司列表
	 * @return
	 */
	public List<Company> findCompanys();
	
	/**
	 * 获取公司详情
	 * @param id
	 * @return
	 */
	public Company findCompany(String id);
	
	/**
	 * 更新公司详情
	 * @param entity
	 */
	public void updateCompany(Company entity);
	
	/**
	 * 添加公司信息
	 * @param entity
	 */
	public void addCompany(Company entity);
	
	/**
	 * 删除公司根据id
	 * @param id
	 */
	public void delCompany(String id);
	
	/**
	 * 根据url判断该公司是否存在
	 * @param url
	 * @return
	 */
	public Company searchCompanyByUrl(String ip);
}
