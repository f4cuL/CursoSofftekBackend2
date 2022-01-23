package com.sofftekfrontend.app.service;

import java.util.List;

public interface ServiceInteface <T> {
	public List<T> findAll();
	
	public T findById(int id);

	public T save(T t);
	
	public void delete(int id);	
	
	public void update(T t, int id);
	
}
