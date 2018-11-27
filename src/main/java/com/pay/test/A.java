package com.pay.test;

import java.util.List;
import java.util.Map;

import com.pay.annotation.xml.XmlAlias;
import com.pay.annotation.xml.XmlAttribute;
import com.pay.annotation.xml.XmlField;
import com.pay.annotation.xml.XmlSet;

@XmlAlias(name = "root")
public class A {

	@XmlAttribute(name = "id")
	private Long id;

	@XmlField(name = "name")
	private String name;

	@XmlSet(name = "list")
	private List<B> roots;

	@XmlAlias(name = "node")
	private B b;

	@XmlSet(name = "bbs")
	private B[] bb;
	
	@XmlAlias(name="cc")
	private Map<String,String> map;
	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<B> getRoots() {
		return roots;
	}

	public void setRoots(List<B> roots) {
		this.roots = roots;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	public B[] getBb() {
		return bb;
	}

	public void setBb(B[] bb) {
		this.bb = bb;
	}
}
