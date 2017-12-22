package com.torch.springboot.controller;


import com.torch.springboot.pojo.SysUser;
import com.torch.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class IndexController {

	@Autowired
	private SysUserService sysUserService;

	//======================================================================链接跳转 start============================================================================================


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("--------------------------------bug");
		System.out.println("--------------------------------bug");
		System.out.println("--------------------------------bug");
		System.out.println("--------------------------------bug");
		System.out.println("--------------------------------bug");
		System.out.println("--------------------------------bug");
		System.out.println("--------------------------------bug");
		System.out.println("--------------------------------bug新");
		System.out.println("--------------------------------bug新");
		System.out.println("--------------------------------bug新");
		System.out.println("--------------------------------bug新");
		System.out.println("--------------------------------bug新");
		System.out.println("--------------------------------bug新");
		System.out.println("--------------------------------bug新");
		return "redirect:/swagger-ui.html";
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page(Model model) {
		List<SysUser> sysUserList = sysUserService.findAll();
		model.addAttribute("sysUserList", sysUserList);
		return "index";
	}
	
	//======================================================================链接跳转 start============================================================================================
}
