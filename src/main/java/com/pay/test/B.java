package com.pay.test;

import com.pay.annotation.xml.XmlAlias;
import com.pay.annotation.xml.XmlAttribute;
import com.pay.annotation.xml.XmlField;

@XmlAlias(name = "node")
public class B {

	@XmlAttribute(name = "id")
	private Long id;

	@XmlField(name = "age")
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public B() {
	};
}