package com.test.lsy.apitest250408.dto.response4;

import lombok.Data;

@Data
public class Address{
	private String zipcode;
	private Geo geo;
	private String suite;
	private String city;
	private String street;
}