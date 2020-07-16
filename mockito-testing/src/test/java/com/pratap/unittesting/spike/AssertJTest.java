package com.pratap.unittesting.spike;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

class AssertJTest {

	@Test
	void testAssertJAssertions() {
		
		List<Integer> numbers = Arrays.asList(12,15,45);
		
		assertThat(numbers).hasSize(3)
								.contains(15, 45)
								.allMatch(x -> x < 46)
								.allMatch(x -> x > 10)
								.noneMatch(x -> x < 0);
		assertThat("").isEmpty();
		
		assertThat("ABCD")
						.contains("BCD")
						.doesNotStartWith("XYZ")
						.startsWith("AB")
						.endsWith("CD");
					
		
	}

}
