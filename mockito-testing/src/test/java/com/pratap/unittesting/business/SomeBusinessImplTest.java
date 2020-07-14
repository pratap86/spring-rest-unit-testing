package com.pratap.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.pratap.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {1, 2, 3};
	}
}

class SomeDataServiceOneValueStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
	}
}

class SomeDataServiceEmptyValueStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}


class SomeBusinessImplTest {

	@Test
	void testCalculateSumBasic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {1, 2, 3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testCalculateSumEmptyValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testCalculateSumOneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {5});
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testCalculateSumUsingDataServiceBasic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testCalculateSumUsingDataServiceOneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(new SomeDataServiceOneValueStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testCalculateSumUsingDataServiceEmptyValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(new SomeDataServiceEmptyValueStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

}
