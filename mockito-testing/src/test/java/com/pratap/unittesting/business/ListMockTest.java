package com.pratap.unittesting.business;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class ListMockTest {

	@SuppressWarnings("unchecked")
	List<String> mockList= Mockito.mock(List.class);
	
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
	
	@Test
	public void mock() {
		
		@SuppressWarnings("unchecked")
		ArrayList<String> arrayListMock = Mockito.mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
	}
	
	@Test
	public void spying() {
		
		@SuppressWarnings("unchecked")
		// when you spy an Object, original behavior always retain 
		ArrayList<String> arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add(0, "test1");
		System.out.println(arrayListSpy.get(0));//test1
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		
		arrayListSpy.add("Test4");
		verify(arrayListSpy).add("Test4");
		
		
	}

}
