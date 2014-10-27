package com.unicom.oneToone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * @author huzhen
 */
public class Test {
	public void insert() {
		Configuration config = new AnnotationConfiguration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Husband hus = new Husband();
		hus.setName("huzhen");
		hus.setAge(25);
		Wife wf = new Wife();
		wf.setName("zhulinan");
		wf.setDistnes("very likily");
		hus.setWife(wf);
		session.save(hus);
		session.getTransaction().commit();

	}

	public void find() {
		Configuration config = new AnnotationConfiguration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// Criteria cri=session.createCriteria(Husband.class);
		//
		// List<Husband> list=cri.list();
		// for (Husband hus:list){
		// System.out.println(hus.getWife().getId());
		// }
		Husband hus = (Husband) session.get(Husband.class,
				"8ab8dab2493afcbb01493afcbc920001");
		System.out.println(hus.getWife().getId());
		session.getTransaction().commit();
	}

	public void delete() {
		Configuration config = new AnnotationConfiguration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Husband hus = (Husband) session.get(Husband.class,
				"8ab8dab2493afcbb01493afcbc920001");
		Wife wife = (Wife) session.get(Wife.class,
				"8ab8dab2493afcbb01493afcbc920001");
		// session.delete(wife); //ObjectDeletedException deleted object would
		// be re-saved by cascade
		session.delete(hus); // delete susscee
		session.getTransaction().commit();
	}

	public static void main(String[] args) {
		Test ts = new Test();
		ts.delete();
	}

}
