package com.pratap.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

	String actualResult ="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	void testJsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {

		String expectedResult = "{\"id\":    1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResult, actualResult, true);
	}
	
	@Test
	void testJsonAssert_StrictFalse() throws JSONException {

		String expectedResult = "{\"id\":    1,\"name\":\"Ball\"}";
		JSONAssert.assertEquals(expectedResult, actualResult, false);
	}
	
	@Test
	void testJsonAssert_WithoutEscapeCharacters() throws JSONException {

		String expectedResult = "{id:1, name:Ball, price: 10, quantity : 100}";
		JSONAssert.assertEquals(expectedResult, actualResult, false);
	}

}
