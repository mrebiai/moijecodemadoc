package com.mrebiai.moijecodemadoc.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author mrebiai
 */
@XmlRootElement
public class MyDoc implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String result;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}