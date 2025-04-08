package com.test.lsy.apitest250408.dto.response1;

import lombok.Data;

@Data
public class Login{
	private String uuid;
	private String username;
	private String password;
	private String salt;
	private String md5;
	private String sha1;
	private String sha256;
}