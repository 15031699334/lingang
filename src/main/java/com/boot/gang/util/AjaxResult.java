package com.boot.gang.util;
import java.io.Serializable;

/**
 * Created by zhumaer on 17/5/24.
 */
public class AjaxResult implements Serializable {

	private static final long serialVersionUID = -3948389268046368059L;

	private Integer code;

	private String msg;

	private Object data;

	public AjaxResult() {}

	public AjaxResult(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static AjaxResult success() {
		AjaxResult AjaxResult = new AjaxResult();
		AjaxResult.setResultCode(ResultCodeEnum.SUCCESS);
		return AjaxResult;
	}

	public static AjaxResult success(Object data) {
		AjaxResult AjaxResult = new AjaxResult();
		AjaxResult.setResultCode(ResultCodeEnum.SUCCESS);
		AjaxResult.setData(data);
		return AjaxResult;
	}

	public static AjaxResult failure(ResultCodeEnum resultCode) {
		AjaxResult AjaxResult = new AjaxResult();
		AjaxResult.setResultCode(resultCode);
		return AjaxResult;
	}

	public static AjaxResult failure(ResultCodeEnum resultCode, Object data) {
		AjaxResult AjaxResult = new AjaxResult();
		AjaxResult.setResultCode(resultCode);
		AjaxResult.setData(data);
		return AjaxResult;
	}

	public void setResultCode(ResultCodeEnum code) {
		this.code = code.code();
		this.msg = code.message();
	}


	
	
	//getter setter
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}

