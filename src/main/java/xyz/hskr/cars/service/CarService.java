package xyz.hskr.cars.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import xyz.hskr.cars.domain.Car;
import xyz.hskr.cars.repo.CarRepo;
import xyz.hskr.exception.BodyParamaterException;
import xyz.hskr.exception.NoSuchElementFoundException;

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

}