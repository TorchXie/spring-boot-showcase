package com.torch.springboot.service;


import com.torch.springboot.pojo.SysUser;

import java.util.List;


public interface SysUserService {

	SysUser findByLoginName(String loginName);
	
	List<SysUser> findAll();
	
	SysUser saveUserAndReturn(SysUser sysUser);
	
	void deleteUserById(Long userId);

	SysUser updateUser(SysUser sysUser);
}
