package com.test.lsy.apitest250408.dto.response1;

import lombok.Data;

@Data
public class Location{
	private Street street;
	private String city;
	private String country;
	private int postcode;
	private Coordinates coordinates;
	private Timezone timezone;
	private String state;
}