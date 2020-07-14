package com.pratap.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pratap.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
	
	@InjectMocks
	SomeBusinessImpl business;
	
	@Mock
	SomeDataService someDataServiceMock;

	@Test
	void testCalculateSumUsingDataServiceBasic() {
		
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
		assertEquals(6, business.calculateSumUsingDataService());
	}
	
	@Test
	void testCalculateSumUsingDataServiceOneValue() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		assertEquals(5, business.calculateSumUsingDataService());
	}
	
	@Test
	void testCalculateSumUsingDataServiceEmptyValue() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}

}
