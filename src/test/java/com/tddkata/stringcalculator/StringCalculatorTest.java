package com.tddkata.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testEmptyStringReturnZero() {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void testOneNumberReturnSameNumber() {
		assertEquals(1, StringCalculator.add("1"));
	}

	@Test
	public void testTwoNumberReturnSum() {
		assertEquals(3, StringCalculator.add("1,2"));
	}

	@Test(expected = RuntimeException.class)
	public void testNotANumberThrowsException() {
		StringCalculator.add("A,B");
	}

}
