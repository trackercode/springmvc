package com.mongodb.dao;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.entity.Company;


@Component("dataManager")
public class RepositoryImpl<T> implements AbstractRepository {
    @Autowired
	private MongoTemplate mongoTemplate;

    /***
     * 查找所有对象；
     */
	@Override
	public List<?> findAll(Class<?> entity) {
		return mongoTemplate.findAll(entity);

	}

	/**
	 * 
	 */
	public void findAndModify(String id) {
		//mongoTemplate.find(new Query(Criteria.where("id").is(id)), new Update().inc("age", 3));
	}

	@Override
	public List<Company> findByRegex(String regex) {
		 Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);   
	      Criteria criteria = new Criteria("name").regex(pattern.toString());   
	        return mongoTemplate.find(new Query(criteria), Company.class);   

	}

	/***
	 * 根据ID查找对象；
	 */
	@Override
	public Company findOne(String id,Class<?> entity) {
		 return (Company) mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), entity);   
	}

	/***
	 * 添加一个实体；
	 */
	@Override
	public void insert(Object entity) {
		mongoTemplate.insert(entity);   
	}


	/***
	 * 根据ID删除一个对象；
	 */
	@Override
	public void removeOne(String id,Class<?> entity) {
		Criteria criteria = Criteria.where("id").in(id);   
        if(criteria != null){   
             Query query = new Query(criteria);   
             if(query != null && mongoTemplate.findOne(query, entity) != null)   
                 mongoTemplate.remove(mongoTemplate.findOne(query, entity));   
        }   

	}

	/***
	 * 更新实体；
	 */
	@Override
	public void updateEntity(Object entity) {
		mongoTemplate.save(entity);
	}

	/***
	 * 根据Criteria查询一个实体；
	 */
	@SuppressWarnings("hiding")
	@Override
	public <T> T findEntityByCriteria(Criteria criteria, Class<T> entity) {
		Query query=new Query();
		query.addCriteria(criteria);
		return  mongoTemplate.findOne(query, entity);
	}
	


}
