package com.unicom.oneToonedouble;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*
 * @author huzhen
 */
@Entity
@Table(name = "t_wife")
public class Wife implements Serializable {
	public String id;
	public String name;
	public String distnes;
	public Husband husband;

	@Id
	@GeneratedValue(generator = "indent")
	@GenericGenerator(name = "indent", strategy = "uuid")
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

	@OneToOne(mappedBy = "wife")
	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}

}
