package com.axa.cfdi.beans;


public class Campo {
	
	private String key;
	private String value;
	
	public Campo() {
		super();
	}

	@Override
	public String toString() {
		return "Campo [key=" + key + ", value=" + value + "]";
	}

	public Campo(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
