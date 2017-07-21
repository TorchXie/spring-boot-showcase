package com.youmeek.springboot.service;


import com.youmeek.springboot.pojo.SysUser;

import java.util.List;


public interface SysUserService {

	SysUser findByLoginName(String loginName);
	
	List<SysUser> findAll();
	
	SysUser saveUserAndReturn(SysUser sysUser);
	
	void deleteUserById(Long userId);

	SysUser updateUser(SysUser sysUser);
}
