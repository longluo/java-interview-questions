package com.longluo.java.interview.generics;

import java.util.Set;

/**
 * DAO：Data Access Object(数据访问对象) 数据访问：CRUD，即增删改查
 * 
 * @author 孤傲苍狼 此类是用来演示如何定义泛型类 此泛型类中的<E>中的E代表实际操作的类型
 *         指明了操作类型E之后，GenericDAO类中定义的CRUD方法就都是针对于指定的类型
 */
public class GenericDAO<E> {
	private E field1; // 定义泛型类型的成员变量

	public <E> void add(E x) {
	}

	public <E> E findById(int id) {
		return null;
	}

	public void delete(E obj) {
	}

	public void delete(int id) {
	}

	public void update(E obj) {
	}

	// public static void update(E obj){}这样定义会报错，静态方法不允许使用泛型参数
	public static <E> void update2(E obj) {
	}// 这样定义就可以，此时的这个静态方法所针对的类型和GenericDAO<E>中指定的类型是两个不同的类型

	public Set<E> findByConditions(String where) {
		return null;
	}

	public static void main(String[] args) {
//		GenericDAO<ReflectField> dao = new GenericDAO<ReflectField>();// 这里指定泛型类的操作类型是ReflectField
//		dao.add(new ReflectField(1, 3));
//		ReflectField rf = dao.findById(1);
		GenericDAO<String> dao1 = null;
		new GenericDAO<String>();
	}
}
