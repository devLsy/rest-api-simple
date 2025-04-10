package com.test.lsy.apitest250408.dto.response1;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "단일 사용자 정보")
public class ResultsItem{
	@Schema(description = "사용자 성별 (예: female)", example = "female")
	private String gender;
	@Schema(description = "사용자 이름 (예: John)", example = "John")
	private Name name;

	private Location location;
	@Schema(description = "사용자 이메일 (예: test@example.com)", example = "test@example.com")
	private String email;

	private Login login;
	private Dob dob;
	private Registered registered;

	@Schema(description = "사용자 연락처 (예: 0436-6331701)", example = "0436-6331701")
	private String phone;
	@Schema(description = "사용자 휴대전화 (예: 0177-5612497)", example = "0177-5612497")
	private String cell;
	private Id id;
	private Picture picture;

	private String nat;
}