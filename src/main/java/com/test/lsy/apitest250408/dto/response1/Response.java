package com.test.lsy.apitest250408.dto.response1;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "외부 API 1의 루트 응답 객체. 사용자 정보 목록과 응답 메타데이터 포함")
public class Response{
	@Schema(description = "사용자 정보 리스트", requiredMode = Schema.RequiredMode.REQUIRED)
	private List<ResultsItem> results;
	@Schema(description = "응답 메타데이터 (요청 페이지 정보 등)", requiredMode = Schema.RequiredMode.REQUIRED)
	private Info info;
}