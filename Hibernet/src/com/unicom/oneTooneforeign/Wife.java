package com.unicom.oneTooneforeign;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_wife")
public class Wife implements Serializable{
	public String id;
	public String name;
	public String distnes;
	@Id
	@GeneratedValue(generator="indent")
	@GenericGenerator(name="indent",strategy="uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDistnes() {
		return distnes;
	}
	public void setDistnes(String distnes) {
		this.distnes = distnes;
	}
	

}
