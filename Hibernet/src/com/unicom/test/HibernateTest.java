package com.unicom.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author huzhen
 *
 * @date 2011-7-20
 *
 */
public class HibernateTest {

 public static void main(String[] args) {
  HibernateTest test=new HibernateTest();
  test.add();
  test.find();
 // test.insert();
 }
 public void add(){
 Configuration config=new AnnotationConfiguration();
 config.configure();
 SessionFactory sessionFactory=config.buildSessionFactory();
 Session session=sessionFactory.getCurrentSession();
 session.beginTransaction();
 Category c=(Category)session.get(Category.class, 5);
 
 Product p=new Product();
 p.setId(89);
 p.setName("计算机科学与技术");
 p.setPrice("123");
 p.setDescripton("计算机科学与技术,好啊，真是红啊");
 
 p.setCategory(c);
 c.getProducts().add(p);
 
 session.save(p);
 session.getTransaction().commit();
 }
 
 
 public void find(){
  Configuration config=new AnnotationConfiguration();
  config.configure();
  SessionFactory sessionFactory=config.buildSessionFactory();
  Session session=sessionFactory.getCurrentSession();
  session.beginTransaction();
  Category c=(Category)session.get(Category.class, 5);
   System.out.println("id: "+c.getId()+"  name:"+c.getName());
   Set<Product> p=c.getProducts();
   for(Product product:p){
    System.out.println("id:"+product.getId()+"  name:"+product.getName()+"  description:"+product.getDescripton());
   }
   session.getTransaction().commit();
 }
public void insert(){
	Configuration config=new AnnotationConfiguration();
	  config.configure();
	  SessionFactory sessionFactory=config.buildSessionFactory();
	  Session session=sessionFactory.getCurrentSession();
	  session.beginTransaction();
	  Category c=new Category();
	  c.setId(5);
	  c.setName("huzhen");
	  c.setDescription("fuck");
	  session.save(c);
	  session.getTransaction().commit();
	  
}
}