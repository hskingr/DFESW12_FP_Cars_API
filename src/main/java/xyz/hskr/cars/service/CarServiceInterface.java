package xyz.hskr.cars.service;

import java.util.List;

public interface CarServiceInterface<T> {
	
	T create(T myT);
	
	T readItem(Long id);
	
	T update(Long id, T y);
	
	boolean delete(Long id);
}
