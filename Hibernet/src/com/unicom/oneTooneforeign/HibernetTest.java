package com.unicom.oneTooneforeign;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernetTest {
	public static SessionFactory sessionFactory;
	public static Session session;

	@Before
	public void opensession() {
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

	@Test
	public void testinsert() {

		Husband hus = new Husband();
		hus.setName("huzhen");
		hus.setAge(25);
		Wife wf = new Wife();
		wf.setName("zhulinan");
		wf.setDistnes("very likily");
		hus.setWife(wf);
		session.save(hus);

	}
	
	@Test
	public void delete()
	{
		Husband hus=(Husband) session.get(Husband.class, "8ab8dab2493c783501493c78366b0001");
	    Wife wife=(Wife) session.get(Wife.class,"8ab8dab2493c6feb01493c6fef210002");
		//session.delete(wife); //因为被动关联，删除失败
	    session.delete(hus);    //
	}

}
