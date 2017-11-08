package com.jsy.cn.entity;

import java.math.BigDecimal;

public class SystemLog {
	
	private BigDecimal pkid;
	
	private String requestJson;
	
	private String responseJson;
	
	private String method;
	
	private Long status;
	
	private String desc;
	
	private Long type;

	public BigDecimal getPkid() {
		return pkid;
	}

	public void setPkid(BigDecimal pkid) {
		this.pkid = pkid;
	}

	public String getRequestJson() {
		return requestJson;
	}

	public void setRequestJson(String requestJson) {
		this.requestJson = requestJson;
	}

	public String getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(String responseJson) {
		this.responseJson = responseJson;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}
	
	

}
