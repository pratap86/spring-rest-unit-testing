package com.pratap.unittesting.business;

import com.pratap.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	// dataService talking to database
	private SomeDataService dataService;

	public void setDataService(SomeDataService dataService) {
		this.dataService = dataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for(int value : data) {
			sum +=value;
		}
		
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = dataService.retrieveAllData();
		for(int value : data) {
			sum +=value;
		}
		
		return sum;
	}
}
