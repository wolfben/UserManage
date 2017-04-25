package com.my.model;

public enum ECode {

	Error(0),
	Success(1);
	
	
	private int _value;
	private ECode(int value){
		this._value=value;
	}
}
