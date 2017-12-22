package com.torch.springboot.restcontroller;

import com.alibaba.fastjson.JSON;
import com.torch.springboot.SpringBootUnitTestJpaApplication;
import com.torch.springboot.dao.SysUserDao;
import com.torch.springboot.pojo.SysUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootUnitTestJpaApplication.class)
@WebAppConfiguration
public class SysUserRestControllerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Autowired
	SysUserDao sysUserDao;

	@Autowired
	WebApplicationContext webApplicationContext;


	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void postSysUserByForm() throws Exception {
		//form 表单提交
		RequestBuilder request = post("/api/users/")
				.param("userUuid", UUID.randomUUID().toString())
				.param("loginName", "GitNavi")
				.param("email", "gitnavi@qq.com")
				.param("password", "123456");

		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.loginName", is("GitNavi")))
				.andExpect(jsonPath("$.email", is("gitnavi@qq.com")));
	}

	@Test
	public void postSysUserByJson() throws Exception {

		// JSON 提交
		SysUser sysUser = new SysUser();
		sysUser.setUserUuid(UUID.randomUUID().toString());
		sysUser.setLoginName("GitNavi");
		sysUser.setEmail("gitnavi@qq.com");
		sysUser.setPassword("123456");

		RequestBuilder request = post("/api/users/json").contentType(contentType).content(JSON.toJSONString(sysUser));

		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.loginName", is("GitNavi")))
				.andExpect(jsonPath("$.email", is("gitnavi@qq.com")));

	}

	@Test
	public void getSysUserById() throws Exception {

		RequestBuilder request = get("/api/users/" + 1L).contentType(contentType);

		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.loginName", is("admin")))
				.andExpect(jsonPath("$.email", is("judas.n@qq.com")));
	}

	@Test
	public void getSysUserByLoginName() throws Exception {

		RequestBuilder request = get("/api/users")
				.param("loginName", "admin")
				.contentType(contentType);

		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.loginName", is("admin")))
				.andExpect(jsonPath("$.email", is("judas.n@qq.com")));
	}

	@Test
	public void updateSysUser() throws Exception {
		SysUser sysUser = sysUserDao.findOne(1L);
		SysUser newSysUser = new SysUser();

		BeanUtils.copyProperties(sysUser, newSysUser);

		newSysUser.setUserName(sysUser.getUserName() + "_update");
		newSysUser.setLoginName(sysUser.getLoginName() + "_update");

		RequestBuilder request = put("/api/users").contentType(contentType).content(JSON.toJSONString(newSysUser));

		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.userName", is(sysUser.getUserName() + "_update")))
				.andExpect(jsonPath("$.loginName", is(sysUser.getLoginName() + "_update")));
	}

	
	@Test
	public void deleteSysUser() throws Exception {
		RequestBuilder request = delete("/api/users/" + 2L).contentType(contentType);
		mockMvc.perform(request)
				.andExpect(status().isOk());
	}

}