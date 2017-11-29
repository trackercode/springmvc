package com.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.mongodb.entity.Company;
import com.mongodb.dao.AbstractRepository;

@Service("companyService")
public class CompanyImpl implements ICompany {
   
	@Autowired
	private AbstractRepository dataManager;
    
    /***
     * 得到全部内容
     */
	@SuppressWarnings("unchecked")//该批注的作用是给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默
	@Override
	public List<Company> findCompanys() {
		return (List<Company>) dataManager.findAll(Company.class);
	}

	/***
	 * 通过ID得到对象
	 */
	@Override
	public Company findCompany(String id) {
		return dataManager.findOne(id,Company.class);
	}

	/***
	 * 更新实体对象
	 */
	@Override
	public void updateCompany(Company entity) {
		 dataManager.updateEntity(entity);
	}

	/***
	 * 增加对象
	 */
	@Override
	public void addCompany(Company entity) {
		dataManager.insert(entity);
	}

	/***
	 * 根据ID号删除一个对象
	 */
	@Override
	public void delCompany(String id) {
		dataManager.removeOne(id, Company.class);
	}
	
	/**
	 * 根据url判断该公司是否存在
	 */
	@Override
	public Company searchCompanyByUrl(String ip){
		Company company=dataManager.findEntityByCriteria(Criteria.where("ip").ne(ip), Company.class);
		return company;
	}
   
	

}
