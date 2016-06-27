package org.weaver.alr.front.common;

public enum Result {

	SUCCESS("0000", "Success"),
	NOT_FOUND("0001", "Not found"),
	UNKNOWN("9999", "Unknown");
	
	private String code;
	private String desc;

	private Result(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public String code() {
		return code;
	}
	public String desc() {
		return desc;
	}
	
	public static Result getResultByCode(String code) {
		for(Result r: Result.values()) {
			if(r.code.equals(code)) {
				return r;
			}
		}
		return null;
	}
}
