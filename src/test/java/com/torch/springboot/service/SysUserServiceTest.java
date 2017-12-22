package com.torch.springboot.service;

import com.alibaba.fastjson.JSON;
import com.torch.springboot.SpringBootUnitTestJpaApplication;
import com.torch.springboot.pojo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootUnitTestJpaApplication.class)
public class SysUserServiceTest {

	@Autowired
	private SysUserService sysUserService;


	@Test
	public void findByLoginName() throws Exception {
		SysUser sysUser = sysUserService.findByLoginName("admin");
		assertThat(sysUser.getLoginName()).isEqualTo("admin");
	}

	@Test
	public void findAll() throws Exception {
		List<SysUser> sysUserList = sysUserService.findAll();
		assertThat(sysUserList.size()).isGreaterThan(0);

	}

	@Test
	public void saveUserAndReturn() throws Exception {
		String jsonString = "{\"availableEnum\":\"0\",\"createDatetime\":1466394593000,\"deleteEnum\":\"0\",\"email\":\"torch@qq.com\",\"lockVersion\":3,\"loginName\":\"torch\",\"password\":\"353c87e543a41339aaaa705bc1228d0e\",\"salt\":\"T6X2ea\",\"sexEnum\":\"0\",\"userName\":\"torch\",\"userUuid\":\"a3006a52f2064ce8bdf62dc3a1a1ce72\"}";
		SysUser sysUser = JSON.parseObject(jsonString, SysUser.class);
		SysUser saveResult = sysUserService.saveUserAndReturn(sysUser);
		assertThat(saveResult.getId()).isNotNull();
		assertThat(saveResult.getLoginName()).isEqualTo("torch");
	}

	@Test
	public void deleteUserById() throws Exception {
		sysUserService.deleteUserById(1L);
		SysUser sysUser = sysUserService.findByLoginName("admin");
		assertThat(sysUser).isNull();
	}

	@Test
	public void updateUser() throws Exception {

		SysUser sysUser = sysUserService.findByLoginName("admin");
		SysUser newSysUser = new SysUser();

		BeanUtils.copyProperties(sysUser, newSysUser);

		newSysUser.setUserName(sysUser.getUserName() + "_update");

		SysUser updateResult = sysUserService.updateUser(newSysUser);
		assertThat(updateResult.getUserName()).isEqualTo(sysUser.getUserName() + "_update");
	}

}