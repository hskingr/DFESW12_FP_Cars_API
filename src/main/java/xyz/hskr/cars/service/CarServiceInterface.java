package xyz.hskr.cars.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import xyz.hskr.cars.domain.Car;

public interface CarServiceInterface<T> {
	
	T create(T myT);
	
	T readItem(Long id);
	
	T update(Long id, T y);
	
	boolean delete(Long id);
	
	//custom
	
	List<T> findItemsByYear(int year);
	
	List<T> findItemsByModel(String model);
	
	List<T> findItemsByMake(String make);

}
