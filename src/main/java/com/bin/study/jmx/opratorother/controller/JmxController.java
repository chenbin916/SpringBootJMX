package com.bin.study.jmx.opratorother.controller;

import java.util.List;
import java.util.Map;

import com.bin.study.jmx.opratorother.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@ManagedResource(objectName="chenbin.study.jmx:name=JmxController")//将控制器暴露为MBean
@RestController
@RequestMapping("/test")
public class JmxController {
	

	@Value("${spring.init.userName}")
	private  String userName;
	private User user;

	@ManagedAttribute//暴露成MBean的属性,这个还有问题，待解决。
	public void setUser(@ModelAttribute("user")  User user){
		this.user = user;
	}

	@ManagedAttribute//暴露成MBean的属性
	public User getUser(){
		return user;
	}

	@ManagedAttribute//暴露成MBean的属性  ，这个改变还有问题，暂时忽略。
	public void setUserName(String userName) {
		
		System.out.println("userName old value is :"+this.userName);
		this.userName = userName;
		System.out.println("userName have changed into :"+this.userName);
	}

	@ManagedAttribute//暴露成MBean的属性
	public String  getUserName(){
		return userName;
	}

	
	@RequestMapping(value="/demo",method=RequestMethod.GET)
	public String demo(String project){
		System.out.println("demo function invoke,userName  value is :"+userName);
		return "hello demo"+project;
	}

}
