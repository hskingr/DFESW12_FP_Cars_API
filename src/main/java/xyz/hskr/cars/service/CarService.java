package xyz.hskr.cars.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import xyz.hskr.cars.domain.Car;
import xyz.hskr.cars.repo.CarRepo;

@Service
public class CarService implements CarServiceInterface<Car> {
	

	

	private CarRepo myCarRepo;

	public CarService(CarRepo carRepo) {
		super();
		myCarRepo = carRepo;
	}

	
	@Override
	public Car create(Car myCar) {
		System.out.println(myCar.toString());
		return myCarRepo.save(myCar);
	}

	@Override
	public Car readItem(Long id) {
		Optional<Car> optCar = myCarRepo.findById(id);
		if (optCar.isPresent()) {
			return optCar.get();
		} else {
//			return false
		}
		return optCar.get();
	}

	@Override
	public Car update(Long id, Car myCar) {
		Optional<Car> optCar = myCarRepo.findById(id);
		if (optCar.isPresent()) {
			myCar.setId(id);
			return myCarRepo.save(myCar);
		} else {
			return myCar;
		}
	}

	@Override
	public boolean delete(Long id) {
		if (myCarRepo.findById(id).isPresent()) {
			myCarRepo.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

}