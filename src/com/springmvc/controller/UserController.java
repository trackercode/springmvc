package com.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.springmvc.entity.User;
import com.springmvc.service.UserManager;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*Spring 2.5 又为 Spring MVC 引入了注解驱动功能。现在你无须让 Controller 继承任何接口，
 * 无需在 XML 配置文件中定义请求和 Controller 的映射关系，仅仅使用注解就可以让一个 POJO 
 * 具有 Controller 的绝大部分功能。
 * 定义一个控制器userController,其主入口映射为/user;
*/
@Controller  
@RequestMapping("/user")  
public class UserController {  

	//指定数据对象
	@Resource(name="userManager")  
	private UserManager userManager;  

	//显示所有内容；
	@RequestMapping("/getAllUser")  
	public String getAllUser(HttpServletRequest request){  
		request.setAttribute("userList", userManager.getAllUser()); 
		System.out.println("显示全部记录");
		return "/Index";  
	}  

	//编辑用户
	@RequestMapping("/getUser")  
	public String getUser(String id,HttpServletRequest request){  
		request.setAttribute("user", userManager.getUser(id)); 
		System.out.println("此条记录已被编辑!");
		return "/editUser";  
	}  

	//显示添加界面；
	@RequestMapping("/toAddUser")  
	public String toAddUser(){  
		return "/addUser";  
	}  

	//执行添加用户时的方法； 
	@RequestMapping("/addUser")  
	public String addUser(User user,HttpServletRequest request){  
		System.out.println("用户名：======"+user.getUserName());  
		userManager.addUser(user);  
		return "redirect:/user/getAllUser";  
	}  

	//删除请求；以JSON的格式回传状态；
	@RequestMapping("/delUser")  
	public void delUser(String id,HttpServletResponse response){  
		String result = "{\"result\":\"error\"}";  
		//删除成功
		if(userManager.delUser(id)){  
			result = "{\"result\":\"success\"}";
			
		} 
		//直接回傳物件到 client 端
		response.setContentType("application/json");  
		try {  
			PrintWriter out = response.getWriter();  
			out.write(result);  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		
	}  

	//更新；
	@RequestMapping("/updateUser")  
	public String updateUser(User user,HttpServletRequest request){  
		if(userManager.updateUser(user)){  
			user = userManager.getUser(user.getId());  
			request.setAttribute("user", user);  
			return "redirect:/user/getAllUser";  
		}else{  
			return "/error";  
		}  
	}  
}
