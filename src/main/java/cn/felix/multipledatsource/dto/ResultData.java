/*
 * Copyright 2018 
 * All Right Reserved
 * Author：potter
 * Create Date：2018年1月15日
 */
package cn.felix.multipledatsource.dto;



import cn.felix.multipledatsource.common.ExceptionMessage;

import java.io.Serializable;

public class ResultData<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	
	private String message;
	
	private T data;
	
	private ExceptionMessage exceptionMessage;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
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

	public ExceptionMessage getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(ExceptionMessage exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public ResultData() {
		super();
	}
	

	public ResultData(String code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ResultData(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	

	public ResultData(String code, ExceptionMessage exceptionMessage) {
		super();
		this.code = code;
		this.exceptionMessage = exceptionMessage;
	}

	public static <U> ResultData<U> success(String code, U data) {
		return new ResultData<U>(code, "success", data);
	}

	public static <U> ResultData<U> success(String code) {
		return new ResultData<U>(code, "success");
	}
	
	public static <U> ResultData<U> failed(String code, String message) {
		return new ResultData<U>(code, message, null);
	}
	public static <U> ResultData<U> failed(String code, ExceptionMessage exceptionMessage) {
		return new ResultData<U>(code, exceptionMessage);
	}

}
