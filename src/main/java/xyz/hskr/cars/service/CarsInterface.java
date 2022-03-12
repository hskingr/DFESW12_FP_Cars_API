package xyz.hskr.cars.service;

import java.util.List;

public interface CarsInterface<T> {
	
	T create(T myT);
	
	List<T> readAll();
	
	T readOne(Long id);
	
	T update(Long id, T y);
	
	boolean delete(Long id);
}
