package com.tddkata.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testEmptyStringReturnZero() {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void testOneNumbr42erReturnSameNumber() {
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

	@Test
	public void testMultipleNumberReturnSum() {
		assertEquals(45, StringCalculator.add("1,2,3,4,5,6,7,8,9"));
	}

	@Test
	public void testAllowNewLineBetweenNumber() {
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}

	@Test
	public void testSemicolonDelimiterToSeparateNumbers() {
		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}

	@Test(expected = RuntimeException.class)
	public void testNegativeNumberInString() {
		StringCalculator.add("1,2,-3");
	}

	@Test
	public void testMultipleNegativeNumbers() {
		String msg = "";
		try {
			StringCalculator.add("1,2,3,-4,5,-6");
		} catch (RuntimeException e) {
			msg = e.getMessage();
		}
		assertEquals("Negatives not allowed: [-4, -6]", msg);
	}

	@Test
	public void testIgnoreNumbergreaterthanthousand() {
		assertEquals(1001, StringCalculator.add("1,1000,1001"));

	}
}
