package xyz.hskr.cars.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import xyz.hskr.cars.domain.Car;
import xyz.hskr.cars.exception.BodyParamaterException;
import xyz.hskr.cars.exception.NoSuchElementFoundException;
import xyz.hskr.cars.repo.CarRepo;

@SpringBootTest
@ActiveProfiles("test")
public class CarServiceTest {

	@Autowired
	private CarService carServ;

	@MockBean
	private CarRepo testCarRepo;

	@Test
	void testCreate() throws Exception{
		// given
		Car myTestCar = new Car(1994, "testFord", "testSuperFast");
		Car myTestCarReturnedValue = new Car(1L, 1994, "testFord", "testSuperFast");
		// when
		Mockito.when(testCarRepo.save(myTestCar)).thenReturn(myTestCarReturnedValue);
		// then
		assertThat(carServ.create(myTestCar)).isEqualTo(myTestCarReturnedValue);
		// verify
		Mockito.verify(testCarRepo, Mockito.times(1)).save(myTestCar);
	}

	@Test
	void testCreateError() throws Exception{
		// given
		Car myTestCar = new Car();
		System.out.println(myTestCar.toString());
		// then
		try {
			carServ.create(myTestCar);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(BodyParamaterException.class);
		}
	}
	
	@Test
	void testCreateError2() throws Exception{
		// given
		Car myTestCar = new Car(0, "testFord", "testSuperFast");
	
		// then
		try {
			carServ.create(myTestCar);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(BodyParamaterException.class);
		}
	}
	
	@Test
	void testCreateError3() throws Exception{
		// given
		Car myTestCar = new Car(1994, "testFord", "testSuperFast");
		myTestCar.setModel(null);
		// then
		try {
			carServ.create(myTestCar);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(BodyParamaterException.class);
		}
	}
	

	@Test
	void testReadItem() throws Exception{
		// given
		Car myTestCarReturnedValue = new Car(10L, 1956, "Chevrolet", "Corvette");
		Long testId = 10L;
		// when
		Mockito.when(testCarRepo.findById(testId)).thenReturn(Optional.of(myTestCarReturnedValue));

		// then
		assertThat(carServ.readItem(testId)).isEqualTo(myTestCarReturnedValue);
		// verify
		Mockito.verify(testCarRepo, Mockito.times(1)).findById(testId);

	}

	@Test
	void testReadItemError() throws Exception{
		// given
		Long testId = 10L;
		// when
		try {
			Mockito.when(testCarRepo.findById(testId).orElseThrow(() -> new NoSuchElementFoundException("")))
					.thenThrow(NoSuchElementFoundException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(NoSuchElementFoundException.class);
			// verify
			Mockito.verify(testCarRepo, Mockito.times(1)).findById(testId);
		}

	}

	
	@Test
	void testUpdate() throws Exception {
		// given
		Car myTestCar = new Car(1994, "CheeseCar", "EdamCheese");
		Car tempCar = new Car(3L, 1948, "Citroën", "2CV");
		Long testId = 3L;
		Car myTestCarReturnedValue = new Car(3L, 1994, "CheeseCar", "EdamCheese");
		// when
		Mockito.when(testCarRepo.findById(testId)).thenReturn(Optional.of(tempCar));
		Mockito.when(testCarRepo.save(myTestCar)).thenReturn(myTestCarReturnedValue);
		// then
		assertThat(carServ.update(testId, myTestCar)).isEqualTo(myTestCarReturnedValue);
		// verify
		Mockito.verify(testCarRepo, Mockito.times(1)).save(myTestCar);

	}
	
	@Test
	void testUpdateError() throws Exception{
		// given
		Car myTestCar = new Car(1994, "CheeseCar", "EdamCheese");
		Long testId = 3L;
		Car tempCar = new Car(3L, 1948, "Citroën", "2CV");
		///when
		Mockito.when(testCarRepo.findById(testId)).thenReturn(Optional.of(tempCar));
		// then
		try {
			carServ.update(testId, myTestCar);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(BodyParamaterException.class);
		}
	}
	
	@Test
	void testUpdateError2() throws Exception{
		// given
		Car myTestCar = new Car(0, "testFord", "testSuperFast");
		Long testId = 3L;
		Car tempCar = new Car(3L, 1948, "Citroën", "2CV");
		///when
		Mockito.when(testCarRepo.findById(testId)).thenReturn(Optional.of(tempCar));
		// then
		try {
			carServ.update(testId, myTestCar);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(BodyParamaterException.class);
		}
	}
	
	
	@Test
	void testUpdateError3() throws Exception{
		// given
		Car myTestCar = new Car(1994, "testFord", "testSuperFast");
		myTestCar.setModel(null);
		Long testId = 3L;
		Car tempCar = new Car(3L, 1948, "Citroën", "2CV");
		///when
		Mockito.when(testCarRepo.findById(testId)).thenReturn(Optional.of(tempCar));
		// then
		try {
			carServ.update(testId, myTestCar);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(BodyParamaterException.class);
		}
	}
	
	@Test
	void testUpdateError4() throws Exception{
		// given
		Car myTestCar = new Car(1994, "testFord", "testSuperFast");
		myTestCar.setMake(null);
		Long testId = 3L;
		Car tempCar = new Car(3L, 1948, "Citroën", "2CV");
		///when
		Mockito.when(testCarRepo.findById(testId)).thenReturn(Optional.of(tempCar));
		// then
		try {
			carServ.update(testId, myTestCar);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(BodyParamaterException.class);
		}
	}


	@Test
	void testDelete() throws Exception{
		// given
		Long testId = 10L;
		Car myTestCarReturnedValue = new Car(10L, 1956, "Chevrolet", "Corvette");
		Boolean expectedReturnValue = true;
		// when
		Mockito.when(testCarRepo.findById(testId)).thenReturn(Optional.of(myTestCarReturnedValue));
		// then
		assertThat(carServ.delete(testId)).isEqualTo(expectedReturnValue);
		// verify
		Mockito.verify(testCarRepo, Mockito.times(1)).findById(testId);
		Mockito.verify(testCarRepo, Mockito.times(1)).deleteById(testId);

	}
	

	
	@Test
	void testFindItemsByYear() throws Exception{
		// given
		Car myTestCarReturnedValue = new Car(4L, 1950, "Hillman", "Minx Magnificent");
		List<Car> myTestResturnedList = new ArrayList<>();
		myTestResturnedList.add(myTestCarReturnedValue);
		int year = 1950;
		// when
		Mockito.when(testCarRepo.findCarByYear(year)).thenReturn((myTestResturnedList));

		// then
		assertThat(carServ.findItemsByYear(year)).isEqualTo(myTestResturnedList);
		// verify
		Mockito.verify(testCarRepo, Mockito.times(1)).findCarByYear(year);

	}
	
	@Test
	void testFindItemsByModel() throws Exception{
		// given
		Car myTestCarReturnedValue = new Car(4L, 1950, "Hillman", "Minx Magnificent");
		List<Car> myTestResturnedList = new ArrayList<>();
		myTestResturnedList.add(myTestCarReturnedValue);
		String model = "Minx Magnificent";
		// when
		Mockito.when(testCarRepo.findCarByModel(model)).thenReturn((myTestResturnedList));

		// then
		assertThat(carServ.findItemsByModel(model)).isEqualTo(myTestResturnedList);
		// verify
		Mockito.verify(testCarRepo, Mockito.times(1)).findCarByModel(model);

	}
	
	@Test
	void testFindItemsByMake() throws Exception{
		// given
		Car myTestCarReturnedValue = new Car(4L, 1950, "Hillman", "Minx Magnificent");
		List<Car> myTestResturnedList = new ArrayList<>();
		myTestResturnedList.add(myTestCarReturnedValue);
		String make = "Hillman";
		// when
		Mockito.when(testCarRepo.findCarByMake(make)).thenReturn((myTestResturnedList));

		// then
		assertThat(carServ.findItemsByMake(make)).isEqualTo(myTestResturnedList);
		// verify
		Mockito.verify(testCarRepo, Mockito.times(1)).findCarByMake(make);

	}
}
