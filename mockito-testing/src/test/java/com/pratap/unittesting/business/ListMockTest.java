package com.pratap.unittesting.business;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

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
	
	@Test
	public void testArgumentCapturing() {
		
		mockList.add("test");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mockList).add(captor.capture());
		
		assertEquals("test", captor.getValue());
	}
	
	@Test
	public void testMultipleArgumentCapturing() {
		
		mockList.add("test1");
		mockList.add("test2");
		mockList.add("test3");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mockList, times(3)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		
		assertEquals("test1", allValues.get(0));
		assertEquals("test2", allValues.get(1));
		assertEquals("test3", allValues.get(2));
	}

}
