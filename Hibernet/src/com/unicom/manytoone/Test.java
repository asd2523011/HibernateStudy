package com.unicom.manytoone;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
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
	 * ����ǰ���о���������᲻��ȷ����������һ�¾�Ȼ�ɹ����о�hibernate�ײ㴦��ǿ��
	 */
	@org.junit.Test
	public void inserttest(){
		People ple=new People();
		ple.setAge(17);
		ple.setDes("hehehheheheh");
		Address add=new Address();
		add.setName("��˾");
		add.setDestict("dizhi");
		add.setPeople(ple);
		Address add1=new Address();
		add1.setName("hoime");
		add1.setDestict("dizhi");
		add1.setPeople(ple);
		Address add2=new Address();
		add2.setName("home");
		add2.setDestict("dizhi");
		add2.setPeople(ple);
		session.save(add);
		session.save(add1);
		session.save(add2);
		
	}
	@org.junit.Test
	public void select()
	{
		//session.get(People.class, "8ab8dab2493fd57401493fd577100002"); //ֻ��select people
	    Address add=(Address) session.get(Address.class, "8ab8dab2493fd57401493fd577100001"); //�����ӳټ��غ�ֻ����address������ȫ������
	    System.out.println("<<<<<<<<<<<<<<<<<<<");
	    System.out.println(add.getPeople().getId());    //�����ӳټ���ȷʵ����
	}
	@org.junit.Test
	public void delete(){
//		Address add=(Address) session.get(Address.class, "8ab8dab2493fd57401493fd577100001"); //�����ӳټ��غ�ֻ����address������ȫ������
//	    session.delete(add);   //���β�ѯ������ɾ�������˷���ʧ�ܣ������޷�ִ���������£�caused by ���������
        List<Address> query=new ArrayList<Address>();
		try {
			//query= session.createQuery("select u from Address u").list();
			query = session.createQuery("from "+Address.class.getName()).list();
			//query=session.createSQLQuery("select * from t_address").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Criteria crit=session.createCriteria(Address.class);
//		query=crit.list();
	    for(Address add:query){
	    	session.delete(add);
	    }
	}

}
