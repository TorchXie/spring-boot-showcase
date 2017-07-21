package com.youmeek.springboot.dao;

import com.youmeek.springboot.SpringBootUnitTestJpaApplication;
import com.youmeek.springboot.pojo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootUnitTestJpaApplication.class)
@DataJpaTest
public class SysUserDaoTest {


	@Autowired
	SysUserDao sysUserDao;
	
	//============================================================================================================

	@Test
	public void getOneSysUser() throws Exception {
		SysUser sysUser = sysUserDao.findOne(1L);
		assertThat(sysUser, is(notNullValue()));
	}

	@Test
	public void getByPage() throws Exception {
		Page<SysUser> pageOne = sysUserDao.findAll(new PageRequest(1, 10));
		assertThat(pageOne.getTotalElements(), greaterThan(0L));
	}
	
	@Test
	public void updateSysUser() throws Exception {
		SysUser sysUser = sysUserDao.findOne(1L);
		assertThat(sysUser, is(notNullValue()));
		sysUser.setUserName(sysUser.getUserUuid() + "_updated");
		sysUserDao.save(sysUser);
		SysUser updated = sysUserDao.findOne(1L);
		assertEquals(sysUser.getUserName(), updated.getUserName());
	}

	@Test
	public void deleteSysUser() throws Exception {
		sysUserDao.delete(2L);
		assertThat(sysUserDao.findOne(2L), is(nullValue()));
	}


}