package calculator;

import java.util.ArrayList;
import java.util.List;

class StringCalculator {
	static int count = 0;

	public static int add(String numbers,String delimeter) {
		int sum = 0;
		String[] arr = numbers.split(delimeter);	
//		int negativeNumber=0;
		List<Integer> negativeNumbers = new ArrayList<>();
		
//		if (arr.length > 2) {
//			throw new RuntimeException("Only Two Numbers are allowed.");
//		} else {
		
			for (String number : arr) {
				if (!number.trim().isEmpty()) {
					int numberInt =  Integer.parseInt(number.trim());		// If it is not a number,parseInt() will throw an exception.
					if(numberInt<0) {
						negativeNumbers.add(numberInt);
					}else if(numberInt<=1000) {
						sum = sum + numberInt;
					}
				}
			}
//	}
		if(negativeNumbers.size()>0) {
			throw new RuntimeException("Negatives not allowed : "+negativeNumbers.toString());
		}
		return sum;
	}
	
	public static int add(String numbers) {
		String delimeter = ",|\n";
		String numbersWithoutDelimeters = numbers;
		if(numbers.startsWith("//")) {
			int delimeterIndex = numbers.indexOf("//")+2;
			delimeter = numbers.substring(delimeterIndex, delimeterIndex+1);
			numbersWithoutDelimeters = numbers.substring(numbers.indexOf("\n")+1);
		}
		count++;
		return add(numbersWithoutDelimeters,delimeter);	
	}
	
	
	public static int getCalledCount() {
		return count;		
	}
	
}
