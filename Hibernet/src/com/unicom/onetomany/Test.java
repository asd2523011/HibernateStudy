package com.unicom.onetomany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

public class Test {
	public static SessionFactory sessionFactory;
	public static Session session;
	@Before
	public void opensession(){
		Configuration config = new AnnotationConfiguration();
		config.configure();
		sessionFactory = config.buildSessionFactory();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}
	@After
	public void closesession() {

		session.getTransaction().commit();
		sessionFactory.close();
	}
	/*
	 * 进行着个插入的时候，一定要在注解上加上cascade=CascadeType.ALL，否则会报
	 * TransientObjectException异常。单向一对多注解，hibernate会冗余一个中间表，
	 * 我们可以在@onetomany处添加注解@JoinColumn(name="people_id")，将会在地址
	 * 数据库中添加一个外键列
	 */
	@org.junit.Test
	public void inserttest(){
		People ple=new People();
		ple.setAge(17);
		ple.setDes("hehehheheheh");
		Address add=new Address();
		add.setName("公司");
		add.setDestict("dizhi");
		Address add1=new Address();
		add1.setName("hoime");
		add1.setDestict("dizhi");
		Address add2=new Address();
		add2.setName("home");
		add2.setDestict("dizhi");
		Set<Address> set=new HashSet<Address>();
		set.add(add);
		set.add(add1);
		set.add(add2);
        ple.setAddress(set);
		try {
			session.save(ple);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@org.junit.Test
	public void select()
	{
		  

	}
	@org.junit.Test
	public void delete(){
       People ple=(People) session.get(People.class, "8ab8dab249407fa00149407fa1b70001");
	   session.delete(ple);
	}

}
