package com.unicom.manytoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/*
 * @author huzhen
 */
@Entity
@Table(name="t_address")
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public String name;
	public String destict;
	public People people;
	@Id
	@GeneratedValue(generator="indent")
	@GenericGenerator(name="indent",strategy="uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(length=32)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=32)
	public String getDestict() {
		return destict;
	}
	public void setDestict(String destict) {
		this.destict = destict;
	}
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public People getPeople() {
		return people;
	}
	public void setPeople(People people) {
		this.people = people;
	}
	
		
	}

