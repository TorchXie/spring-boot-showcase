package com.youmeek.springboot.dao;


import com.youmeek.springboot.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserDao extends JpaRepository<SysUser, Long> {
	SysUser findByLoginName(String loginName);

	@Query("SELECT a FROM SysUser a WHERE a.deleteEnum = ?1 AND a.availableEnum = ?2 ")
	List<SysUser> findAllByDeleteEnumAndAvailableEnum(String deleteEnum, String availableEnum);
	
}
