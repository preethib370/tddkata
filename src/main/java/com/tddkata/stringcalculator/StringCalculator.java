package com.tddkata.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	String input = "1";

	public static int add(String input) {
		int result = 0;
		List<Integer> negativeNum = new ArrayList<Integer>();
		String temp = input;
		String delimiter = ",|\n";
		if (temp.startsWith("//")) {
			int index = temp.indexOf("//") + 2;
			delimiter = temp.substring(index, index + 1);
			input = temp.substring(temp.indexOf("\n") + 1);
		}
		String[] inputArray = input.split(delimiter);
		for (String i : inputArray) {
			if (!i.trim().isEmpty()) {
				int number = Integer.parseInt(i.trim());
				if (number < 0) {
					negativeNum.add(number);
				} else if (number <= 1000) {
					result += number;
				}
			}
		}
		if (negativeNum.size() != 0) {
			throw new RuntimeException("Negatives not allowed: " + negativeNum.toString());
		}
		System.out.println(result);
		return result;
	}
}
