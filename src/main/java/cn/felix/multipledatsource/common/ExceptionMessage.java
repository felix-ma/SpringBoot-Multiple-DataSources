package cn.felix.multipledatsource.common;

import java.io.Serializable;

/**
 * 异常信息类
 * 
 * @version 0.1
 * @date 2010-6-24 上午09:43:57
 */
public class ExceptionMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code; // 编码

	private String message; // 信息
	
	public ExceptionMessage(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String toString() {
		return "code:" + code + " message:" + message;
	}

}
