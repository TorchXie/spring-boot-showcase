package com.torch.springboot.dao;


import com.torch.springboot.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends JpaRepository<SysUser, Long> {
	SysUser findByLoginName(String loginName);
	SysUser findByEmail(String email);
}
