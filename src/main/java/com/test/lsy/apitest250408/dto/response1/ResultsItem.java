package com.test.lsy.apitest250408.dto.response1;

import lombok.Data;

@Data
public class ResultsItem{
	private String gender;
	private Name name;
	private Location location;
	private String email;
	private Login login;
	private Dob dob;
	private Registered registered;
	private String phone;
	private String cell;
	private Id id;
	private Picture picture;
	private String nat;
}