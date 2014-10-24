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
	 * 测试前，感觉这样插入会不正确，后来测试一下竟然成功，感觉hibernate底层处理强大
	 */
	@org.junit.Test
	public void inserttest(){
		People ple=new People();
		ple.setAge(17);
		ple.setDes("hehehheheheh");
		Address add=new Address();
		add.setName("公司");
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
		//session.get(People.class, "8ab8dab2493fd57401493fd577100002"); //只是select people
	    Address add=(Address) session.get(Address.class, "8ab8dab2493fd57401493fd577100001"); //配置延迟加载后，只加载address，否则全部加载
	    System.out.println("<<<<<<<<<<<<<<<<<<<");
	    System.out.println(add.getPeople().getId());    //测试延迟加载确实有用
	}
	@org.junit.Test
	public void delete(){
//		Address add=(Address) session.get(Address.class, "8ab8dab2493fd57401493fd577100001"); //配置延迟加载后，只加载address，否则全部加载
//	    session.delete(add);   //两次查询，两次删除，（此方法失败，报错无法执行批量更新，caused by 外键关联）
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
