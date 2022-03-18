package xyz.hskr.cars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import xyz.hskr.cars.domain.Car;
import xyz.hskr.cars.exception.BodyParamaterException;
import xyz.hskr.cars.exception.NoSuchElementFoundException;
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
		if (myCar.getMake() == null || myCar.getModel() == null || (Integer) myCar.getYear() == 0 ) {
			throw new BodyParamaterException("Parameters: make: " + myCar.getMake() + ", model: " + myCar.getModel() + ", year: " + (Integer) myCar.getYear());
		}
		return myCarRepo.save(myCar);
	}

	@Override
	public Car readItem(Long id) {
		Optional<Car> optCar = Optional
				.ofNullable(myCarRepo
						.findById(id)
						.orElseThrow(() -> new NoSuchElementFoundException("item with id " + id + " Not Found")));
		return optCar.get();
	}

	@Override
	public Car update(Long id, Car myCar) {
		Optional<Car> optCar = Optional.ofNullable(myCarRepo.findById(id)
				.orElseThrow(() -> new NoSuchElementFoundException("item with id " + id + " Not Found")));
		if (myCar.getMake() == null || myCar.getModel() == null || (Integer) myCar.getYear() == 0 ) {
			throw new BodyParamaterException("Parameters: make: " + myCar.getMake() + ", model: " + myCar.getModel() + ", year: " + (Integer) myCar.getYear());	
		}
		myCar.setId(id);
		return myCarRepo.save(myCar);
	}

	@Override
	public boolean delete(Long id) {
		Optional<Car> optCar = Optional.ofNullable(myCarRepo.findById(id)
				.orElseThrow(() -> new NoSuchElementFoundException("item with id " + id + " Not Found")));
			myCarRepo.deleteById(id);
			return true;

	}
	
	//custom

	@Override
	public List<Car> findItemsByYear(int year) {
		Optional<List> optCar = Optional
				.ofNullable(myCarRepo
				.findCarByYear(year));
		return optCar.get();
	}

	@Override
	public List<Car> findItemsByModel(String model) {
		Optional<List> optCar = Optional.of((myCarRepo
				.findCarByModel(model)));
		return optCar.get();
	}

	@Override
	public List<Car> findItemsByMake(String make) {
		Optional<List> optCar = Optional
				.ofNullable(myCarRepo
						.findCarByMake(make));
		return optCar.get();
	}
	

}