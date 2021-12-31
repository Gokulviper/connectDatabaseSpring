package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.DAO.UserDAO;
import com.example.demo.model.User;

@Controller
public class IndexController {
	
	@Autowired
	UserDAO userdao; //avoiding tight coupling 
	//Dependency injction concept 
	
	@RequestMapping("adduser")
	public String add(User user) {
		//inserting data into the database
		userdao.save(user);
		return "index.jsp";
	}
	@RequestMapping("getuser")
	public ModelAndView get(@RequestParam int id) {
		
		ModelAndView mav=new ModelAndView("showUser.jsp");
	User user=	userdao.findById(id).orElse(new User());
	mav.addObject(user);
	
		return mav;
	}
	@RequestMapping("deleteuser")
	public ModelAndView delete(@RequestParam int id) {
		//inserting data into the database
		ModelAndView mav=new ModelAndView("deleteUser.jsp");
	User user=	userdao.findById(id).orElse(new User());
	userdao.deleteById(id);
	mav.addObject(user);
		return mav;
	}
	@RequestMapping("updateuser")
	public ModelAndView update(User user) {
		//inserting data into the database
		ModelAndView mav=new ModelAndView("updateUser.jsp");
 user=	userdao.findById(user.getId()).orElse(new User());
	userdao.deleteById(user.getId());
	mav.addObject(user);
		return mav;
	}
}
