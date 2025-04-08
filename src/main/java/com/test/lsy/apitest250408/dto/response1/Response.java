package com.test.lsy.apitest250408.dto.response1;

import lombok.Data;

import java.util.List;

@Data
public class Response{
	private List<ResultsItem> results;
	private Info info;
}