package com.pratap.unittesting.business;


import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;

class ListMockTest {

	@SuppressWarnings("unchecked")
	List<String> mockList= mock(List.class);
	
	@Test
	void testReturnWithGenericParameter() {
		
		when(mockList.get(anyInt())).thenReturn("test");
		assertEquals("test", mockList.get(0));
		assertEquals("test", mockList.get(1));
	
	}
	
	@SuppressWarnings("unused")
	@Test
	void testVerificationBasics() {
		
		String firstVal = mockList.get(0);
		String secondVal = mockList.get(1);
		
		verify(mockList).get(0);
		verify(mockList, times(2)).get(anyInt());
		verify(mockList, atLeast(1)).get(anyInt());
		verify(mockList, atLeastOnce()).get(anyInt());
		verify(mockList, atMost(2)).get(anyInt());
		verify(mockList, never()).get(2);
	}

}
