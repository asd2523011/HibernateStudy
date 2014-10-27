package com.unicom.oneTooneforeign;

import java.beans.ConstructorProperties;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
/*
 * @author huzhen
 */
@Entity
@Table(name="t_husband")
public class Husband implements Serializable{
	public String id;
	public String name;
	public int age;
	public Wife wife;
	@Id
	@GeneratedValue(generator="indent")
	@GenericGenerator(name="indent",strategy="uuid")
	@Column(length=32)
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="wife_idss")
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	
	

}
