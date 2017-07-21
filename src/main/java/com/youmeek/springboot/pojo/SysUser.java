package com.youmeek.springboot.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SysUser implements Serializable {

	private static final long serialVersionUID = 8514016091254814311L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String userUuid;

	@Column(nullable = false)
	private String loginName;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = true)
	private String userName;

	@Column(nullable = false)
	private String salt;

	@Column(nullable = false)
	private String availableEnum;

	@Column(nullable = false)
	private String deleteEnum;

	@Column(nullable = true)
	private String requestIp;

	@Column(nullable = true)
	private String requestMac;

	@Column(nullable = true)
	private String requestUserAgent;

	@Column(nullable = true)
	private String avatarImagePath;

	@Column(nullable = true)
	private String selfIntroduction;

	@Column(nullable = true)
	private String sexEnum;

	@Column(nullable = true)
	private Date userBirthday;

	@Column(nullable = false)
	private Date createDatetime;

	@Column(nullable = true)
	private Long lockVersion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getAvailableEnum() {
		return availableEnum;
	}

	public void setAvailableEnum(String availableEnum) {
		this.availableEnum = availableEnum;
	}

	public String getDeleteEnum() {
		return deleteEnum;
	}

	public void setDeleteEnum(String deleteEnum) {
		this.deleteEnum = deleteEnum;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getRequestMac() {
		return requestMac;
	}

	public void setRequestMac(String requestMac) {
		this.requestMac = requestMac;
	}

	public String getRequestUserAgent() {
		return requestUserAgent;
	}

	public void setRequestUserAgent(String requestUserAgent) {
		this.requestUserAgent = requestUserAgent;
	}

	public String getAvatarImagePath() {
		return avatarImagePath;
	}

	public void setAvatarImagePath(String avatarImagePath) {
		this.avatarImagePath = avatarImagePath;
	}

	public String getSelfIntroduction() {
		return selfIntroduction;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	public String getSexEnum() {
		return sexEnum;
	}

	public void setSexEnum(String sexEnum) {
		this.sexEnum = sexEnum;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Long getLockVersion() {
		return lockVersion;
	}

	public void setLockVersion(Long lockVersion) {
		this.lockVersion = lockVersion;
	}

	@Override
	public String toString() {
		return "SysUser{" +
				"id=" + id +
				", userUuid='" + userUuid + '\'' +
				", loginName='" + loginName + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", userName='" + userName + '\'' +
				", salt='" + salt + '\'' +
				", availableEnum='" + availableEnum + '\'' +
				", deleteEnum='" + deleteEnum + '\'' +
				", requestIp='" + requestIp + '\'' +
				", requestMac='" + requestMac + '\'' +
				", requestUserAgent='" + requestUserAgent + '\'' +
				", avatarImagePath='" + avatarImagePath + '\'' +
				", selfIntroduction='" + selfIntroduction + '\'' +
				", sexEnum='" + sexEnum + '\'' +
				", userBirthday=" + userBirthday +
				", createDatetime=" + createDatetime +
				", lockVersion=" + lockVersion +
				'}';
	}
}