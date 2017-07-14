package com.java.service.iservice;

import java.util.List;

public interface IBaseService<T, K> {

	String save(T t);

	String delete(T t);

	String update(T newT);

	List<T> findAll();

	T findById(K k);
}
