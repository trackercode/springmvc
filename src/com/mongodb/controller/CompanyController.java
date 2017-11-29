package com.mongodb.controller;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mongodb.entity.Company;
import com.mongodb.common.Util;
import com.mongodb.service.ICompany;


//控制器
@Controller
@RequestMapping("/company")
public class CompanyController  {
	private static Log log = LogFactory.getLog(CompanyController.class.getName());
	@Autowired
	private  ICompany companyService;
	public void insert(){
		//User p=new User("cuiran",27);
		//dataManager.insert(p);
		 log.debug("添加成功");
	}
	
		
	/**
	 *查询所有内容，以链表形式返回。
	 */
	@RequestMapping("/companys")  
	public ModelAndView  companys(){
		List<Company> list=companyService.findCompanys();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/companys");
		mav.addObject("users", list);
		return  mav;
	}
	
	/**
	 * 用户点击修改按钮后，根据ID号查找到此条记录的信息，添加到新视图中；
	 * @param id
	 * @return
	 */
	@RequestMapping("/toUpdateCompany")  
	public ModelAndView toUpdateCompany(@RequestParam("id") String id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/company_update");
		mav.addObject("company", companyService.findCompany(id));
		return  mav;
	}
	
	/***
	 * 用户修改后更新内容，同时修改当前时间信息；
	 * @param company
	 * @return
	 */
	@RequestMapping("/updateCompany")  
	public String  updateCompany(@ModelAttribute Company company){
		
		try{
			company.setUpdateTime(new Date());
			companyService.updateCompany(company);
		}catch(Exception e){
			log.error(e);
		}
		return companyList();
	}
	
	/**
	 * 用户点击完添加后，切换到添加界面；
	 * @return
	 */
	@RequestMapping("/toAddCompany")  
	public ModelAndView toAddCompany(){
		return  returnUrl("/company_add");
	}
	
	/***
	 * 根据URL切换用户界面；
	 * @param url
	 * @return
	 */
	public ModelAndView returnUrl(String url){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(url);
		return mav;
	}
	
	/***
	 * 用户点击添加界面中的保存按钮后，获取当前所添的信息，并更新创建时间；
	 * @param company
	 * @return
	 */
	@RequestMapping("/addCompany")  
	public String addCompany(@ModelAttribute Company company){
		company.setCreateTime(new Date());
		company.setUpdateTime(new Date());
		companyService.addCompany(company);
		return companyList();
	}
	
	/***
	 * 根据ID删除此条对象；
	 * @param id
	 * @return
	 */
	@RequestMapping("/delCompany") 
	public String delCompany(@RequestParam("id") String id){
		companyService.delCompany(id);
		return companyList();
	}
	
	/***
	 * 切换到companys界面；更新内容显示；
	 * @return
	 */
	public String companyList(){
		return "redirect:/company/companys";
	}
	
	
	@RequestMapping("/checkCompany") 
	public String checkCompany(HttpServletResponse response,HttpServletRequest request){
		try{
		    String ip=Util.getIpAddr(request);
		    Company company=companyService.searchCompanyByUrl(ip);
		    response.getWriter().print(company==null?"0":"1");
		}catch(Exception e){
			log.error(e);
		}
		return null;
	}

}
