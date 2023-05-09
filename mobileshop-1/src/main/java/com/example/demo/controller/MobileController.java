
package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.mobilemodel;

import com.example.demo.service.mobileservice;


@RestController
@RequestMapping("/games")
public class Controller {

	
		@Autowired
		private mobileservice service;
		
		  @PostMapping("/login")
		  public String login(@RequestBody Map<String, String> loginData) {
		    String uname = loginData.get("uname");
		    String pwd = loginData.get("pwd");
		    String result = service.checkLogin(uname, pwd);
		    return result;
		  }
		  @PostMapping("/adduser")
		  	public ModelLogin AddUser(@RequestBody ModelLogin game) 
		  {
			  return service.addUser(game);
		  }
		  @GetMapping
		  public List<ModelLogin> listAll()
		  {
			  return service.getUser();
		  }
}

Services
package com.example.database.Services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.Info.ModelLogin;

import com.example.database.garage.Repository.RepoLogin;
