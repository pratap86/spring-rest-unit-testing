package com.pratap.unittesting.spike;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;

class HamcrestMatcherTest {
	
	private List<Integer> numbers;
	
	@BeforeEach
	public void setup() {
		numbers = Arrays.asList(12, 15, 45, 60);
	}

	@Test
	void testHamcrestAssertions() {
		assertThat(numbers, hasSize(4));
		assertThat(numbers, hasItems(45, 60));
		assertThat(numbers, everyItem(greaterThan(10)));
		assertThat(numbers, everyItem(lessThan(100)));
		
		assertThat("", emptyOrNullString());
		assertThat("ABCDE", containsString("BCD"));
		assertThat("ABCDE", startsWith("ABC"));
		assertThat("ABCDE", endsWith("CDE"));
	}

}
