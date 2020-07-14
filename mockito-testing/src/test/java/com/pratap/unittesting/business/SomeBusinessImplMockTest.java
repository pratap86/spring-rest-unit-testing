package com.pratap.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pratap.unittesting.data.SomeDataService;

class SomeBusinessImplMockTest {
	
	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService someDataServiceMock = mock(SomeDataService.class);

	@BeforeEach
	public void before() {
		business.setDataService(someDataServiceMock);
	}
	
	@Test
	void testCalculateSumUsingDataServiceBasic() {
		
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testCalculateSumUsingDataServiceOneValue() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testCalculateSumUsingDataServiceEmptyValue() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

}
