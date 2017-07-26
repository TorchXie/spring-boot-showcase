package com.youmeek.springboot.restcontroller;


import com.youmeek.springboot.dao.SysUserDao;
import com.youmeek.springboot.pojo.SysUser;
import com.youmeek.springboot.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@Api(value = "SysUserRestController RESTful", description = "用户模块管理 REST API")
@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class SysUserRestController {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysUserDao sysUserDao;

	//======================================================================业务处理 start============================================================================================

	@ApiOperation(value = "通过登录名查询用户数据", notes = "通过登录名查询用户数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "loginName", value = "登录名", required = true, paramType = "query", dataType = "String")
	})
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findOneByLoginName(@RequestParam(value = "loginName", required = true) String loginName) {
		SysUser sysUser = sysUserService.findByLoginName(loginName);
		for (int i = 1; i < 6; i++) {
			System.out.println("--------------------------------i=" + i);
		}
		return ResponseEntity.status(HttpStatus.OK).body(sysUser);
	}

	@ApiOperation(value = "查询所有用户列表", notes = "查询所有用户列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<SysUser> sysUserList = sysUserService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(sysUserList);
	}

	@ApiOperation(value = "新增用户", notes = "新增用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userUuid", value = "UUID值", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "loginName", value = "登录账号", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "email", value = "注册邮箱地址", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "String")
	})
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveAndReturn(SysUser sysUser) {
		sysUser.setSalt(RandomStringUtils.randomAlphabetic(6));
		sysUser.setAvailableEnum("0");
		sysUser.setDeleteEnum("0");
		sysUser.setCreateDatetime(new Date());
		SysUser saveResult = sysUserService.saveUserAndReturn(sysUser);
		return ResponseEntity.status(HttpStatus.OK).body(saveResult);
	}

	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public ResponseEntity<?> saveAndReturnByJson(@RequestBody SysUser sysUser) {

		//region 新建保存对象
		sysUser.setSalt(RandomStringUtils.randomAlphabetic(6));
		sysUser.setAvailableEnum("0");
		sysUser.setDeleteEnum("0");
		sysUser.setCreateDatetime(new Date());
		SysUser saveResult = sysUserService.saveUserAndReturn(sysUser);
		//endregion
		
		return ResponseEntity.status(HttpStatus.OK).body(saveResult);
	}

	@ApiOperation(value = "通过用户 ID 删除用户数据", notes = "通过用户 ID 删除用户数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户 ID", required = true, paramType = "path", dataType = "Long")
	})
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long userId) {
		//zchtodo 未测试
		sysUserService.deleteUserById(userId);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@ApiOperation(value = "通过用户 ID 查询用户数据", notes = "通过用户 ID 查询用户数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户 ID", required = true, paramType = "path", dataType = "Long")
	})
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getOne(@PathVariable Long userId) {
		SysUser sysUser = sysUserDao.findOne(userId);
		return ResponseEntity.status(HttpStatus.OK).body(sysUser);
	}

	@ApiOperation(value = "更新登录邮箱和真实姓名", notes = "更新登录邮箱和真实姓名")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "query", dataType = "Long"),
			@ApiImplicitParam(name = "email", value = "用户邮箱", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userName", value = "用户真实姓名", required = true, paramType = "query", dataType = "String")
	})
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody SysUser sysUser) {
		SysUser updateResult = sysUserService.updateUser(sysUser);
		return ResponseEntity.status(HttpStatus.OK).body(updateResult);
	}

	//======================================================================业务处理 end============================================================================================


	//======================================================================私有方法 start============================================================================================

	//======================================================================私有方法 end============================================================================================


}
