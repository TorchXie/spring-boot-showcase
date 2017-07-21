package com.youmeek.springboot.service.impl;


import com.youmeek.springboot.dao.SysUserDao;
import com.youmeek.springboot.pojo.SysUser;
import com.youmeek.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	//======================================================================业务处理 start============================================================================================

	@Override
	public SysUser findByLoginName(String loginName) {
		return sysUserDao.findByLoginName(loginName);
	}


	@Override
	public List<SysUser> findAll() {
		return sysUserDao.findAll();
	}


	@Override
	public SysUser saveUserAndReturn(SysUser sysUser) {
		SysUser saveResult = sysUserDao.save(sysUser);
		return saveResult;
	}

	@Override
	public void deleteUserById(Long userId) {
		sysUserDao.delete(userId);
	}

	@Override
	public SysUser updateUser(SysUser sysUser) {
		return sysUserDao.save(sysUser);
	}


	//======================================================================业务处理 end============================================================================================

	//======================================================================私有方法 end============================================================================================


	//======================================================================私有方法 end============================================================================================
}
