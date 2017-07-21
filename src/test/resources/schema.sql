DROP TABLE IF EXISTS sys_user;

CREATE TABLE sys_user (
	id BIGINT NOT NULL,
	user_uuid varchar(36) NOT NULL,
	login_name varchar(32) NOT NULL,
	email varchar(50) NOT NULL,
	password varchar(32) NOT NULL,
	user_name varchar(32) DEFAULT NULL,
	salt varchar(20) NOT NULL,
	available_enum char(1) NOT NULL DEFAULT '0',
	delete_enum char(1) NOT NULL DEFAULT '0',
	request_ip varchar(40) DEFAULT NULL,
	request_mac varchar(30) DEFAULT NULL,
	request_user_agent varchar(200) DEFAULT NULL,
	avatar_image_path varchar(100) DEFAULT NULL,
	self_introduction varchar(200) DEFAULT NULL,
	sex_enum char(1) DEFAULT '0',
	user_birthday datetime DEFAULT NULL,
	create_datetime datetime NOT NULL,
	lock_version bigint(20) DEFAULT '0',
	PRIMARY KEY (id)
);