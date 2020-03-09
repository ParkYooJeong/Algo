package com.spring.biz.board;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


//VO(Value Object)
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductVO {
	@XmlAttribute
	private String p_id;
	private String p_name;
	private int p_price;

	public String getP_id() {
		return p_id;
	}


	public void setP_id(String p_id) {
		this.p_id = p_id;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public int getP_price() {
		return p_price;
	}


	public void setP_price(int p_price) {
		this.p_price = p_price;
	}




	@Override
	public String toString() {
		return null;
	}


	public void setString(String string) {
		// TODO Auto-generated method stub
		
	}
}