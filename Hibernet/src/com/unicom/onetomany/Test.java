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
	 * �����Ÿ������ʱ��һ��Ҫ��ע���ϼ���cascade=CascadeType.ALL������ᱨ
	 * TransientObjectException�쳣������һ�Զ�ע�⣬hibernate������һ���м��
	 * ���ǿ�����@onetomany�����ע��@JoinColumn(name="people_id")�������ڵ�ַ
	 * ���ݿ������һ�������
	 */
	@org.junit.Test
	public void inserttest(){
		People ple=new People();
		ple.setAge(17);
		ple.setDes("hehehheheheh");
		Address add=new Address();
		add.setName("��˾");
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
