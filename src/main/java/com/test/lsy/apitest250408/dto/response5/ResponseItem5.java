package com.test.lsy.apitest250408.dto.response5;

import lombok.Data;

import java.util.List;

@Data
public class ResponseItem5 {
	private List<String> capital;
	private String flag;
	private boolean independent;
	private boolean landlocked;
	private List<String> borders;
	private PostalCode postalCode;
	private Flags flags;
	private CapitalInfo capitalInfo;
	private String ccn3;
	private CoatOfArms coatOfArms;
	private Demonyms demonyms;
	private String fifa;
	private String cioc;
	private Car car;
	private Translations translations;
	private List<String> altSpellings;
	private Object area;
	private Languages languages;
	private Maps maps;
	private String subregion;
	private Idd idd;
	private List<String> tld;
	private boolean unMember;
	private Gini gini;
	private List<String> continents;
	private int population;
	private String startOfWeek;
	private List<String> timezones;
	private Name name;
	private String cca3;
	private String region;
	private List<Object> latlng;
	private String cca2;
	private String status;
	private Currencies currencies;
}