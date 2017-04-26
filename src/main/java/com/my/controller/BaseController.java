package com.my.controller;

import java.util.HashMap;
import java.util.Map;

import com.my.model.ECode;

public class BaseController {
	
	public Map<String,Object> EndSuccess(){
		return EndSuccess(null);
	}
	
	public Map<String,Object> EndSuccess(Object data)
	{
		return End(ECode.Success,"³É¹¦",data);
	}
	
	public Map<String,Object> EndError(){
		return EndError("´íÎó");
	}
	
	public Map<String,Object> EndError(String msg){
		return End(ECode.Error,msg,null);
	}
	
	public Map<String,Object> End(ECode code,String msg,Object data ){
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("code", code.ordinal());
		result.put("msg", msg);
		result.put("data", data);
		return result;
	}
}
