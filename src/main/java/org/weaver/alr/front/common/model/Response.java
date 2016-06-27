package org.weaver.alr.front.common.model;

import org.weaver.alr.front.common.Result;

public class Response {
	private String code;
	private String message;

	public Response() {
		this.code = Result.SUCCESS.code();
		this.message = Result.SUCCESS.desc();
	}

	public void fail(Result result) {
		setCode(result.code());
		setMessage(result.desc());
	}
	public void fail(Result result, String message) {
		setCode(result.code());
		setMessage(message);
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
