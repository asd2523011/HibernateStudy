package com.unicom.test;
import java.util.HashSet;
import java.util.Set;

// ��׼ע��

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//���ӵ�ע��

import org.hibernate.annotations.GenericGenerator;

//��ǰ������һ���־û��࣬��Category����ࡣ��ӳ����һ����category������Ӧ�� ���ݿ���users
//��䣺@Table(name = "category", catalog = "users")  ����ʡ��
@Entity
@Table(name = "category", catalog = "users")

public class Category implements java.io.Serializable {

 private static final long serialVersionUID = 3240281547213597385L;
 private Integer id;
 private String name;
 private String description;
 private Set<Product> products = new HashSet<Product>(0);

 
 public Category() {
 }

 public Category(String name, String description, Set<Product> products) {
  this.name = name;
  this.description = description;
  this.products = products;
 }

 // ���� ��@Id    �������ɷ�ʽ��strategy = "increment"
 //ӳ�����id����ֶΣ�����Ϊ�գ�������Ψһ��
 @GenericGenerator(name = "generator", strategy = "assigned")
 @Id
 @GeneratedValue(generator = "generator")
 @Column(name = "id", unique = true, nullable = false)
 public Integer getId() {
  return this.id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 //ӳ�����name����ֶ� ��������500
 @Column(name = "name", length = 32)
 public String getName() {
  return this.name;
 }

 public void setName(String name) {
  this.name = name;
 }
 
 //ӳ�����description����ֶ� ��������500
 @Column(name = "description", length = 32)
 public String getDescription() {
  return this.description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 //����������cascade = CascadeType.ALL
 //�ӳټ��أ�fetch = FetchType.LAZY
 //ӳ�䣺mappedBy = "category"
 //һ�Զ෽ʽ
 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
 public Set<Product> getProducts() {
  return this.products;
 }

 public void setProducts(Set<Product> products) {
  this.products = products;
 }

}
