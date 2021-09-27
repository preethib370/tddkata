package com.tddkata.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testEmptyStringReturnZero() {
		assertEquals(0, StringCalculator.add(""));
	}

}
