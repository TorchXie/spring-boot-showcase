package com.youmeek.springboot.dao;


import com.youmeek.springboot.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends JpaRepository<SysUser, Long> {
	SysUser findByLoginName(String loginName);
}
