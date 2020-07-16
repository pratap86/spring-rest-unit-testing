package com.pratap.unittesting.business;

import java.util.Arrays;

import com.pratap.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	// dataService talking to database
	private SomeDataService dataService;

	public void setDataService(SomeDataService dataService) {
		this.dataService = dataService;
	}

	public int calculateSum(int[] data) {
		
		return Arrays.stream(data).reduce(Integer :: sum).orElse(0);
	}
	
	public int calculateSumUsingDataService() {
		
		return Arrays.stream(dataService.retrieveAllData()).reduce(Integer :: sum).orElse(0);
	}
}
