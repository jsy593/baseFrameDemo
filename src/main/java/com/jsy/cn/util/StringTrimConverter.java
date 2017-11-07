package com.jsy.cn.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class StringTrimConverter implements Converter<String, String> {
	
	public String convert(String source) {
		return StringUtils.trimAllWhitespace(source);
	}
}