package calculator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorShould {

	@Test
	public final void whenEmptyStringIsUsed() {
		Assertions.assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		Assertions.assertEquals(1, StringCalculator.add("1"));
	}

	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		Assertions.assertEquals(1 + 2, StringCalculator.add("1,2"));
	}
	
//	@Test
//	public final void whenNumberIsGreaterThanTwo() {
//		assertThrows(RuntimeException.class, () -> {
//			StringCalculator.add("1,2,3");
//		});
//	}
	
	@Test
	public final void whenNon_NumberIsUsed() {
		assertThrows(RuntimeException.class, () -> {
			StringCalculator.add("1,x");
		});
	}
	
	@Test
	public final void whenMultipleNumbersAreToBeAdded() {
		Assertions.assertEquals(1+2+3+4+5,StringCalculator.add("1,2,3,4,5"));	
	}
	
	@Test
	public final void whenNewLineIsPresentBetweenNumbers() {
		Assertions.assertEquals(1+2+3, StringCalculator.add("1\n2,3"));
	}
	
	
	@Test
	public final void whenThereAreDifferentDelimetersPresent() {
		Assertions.assertEquals(3, StringCalculator.add("//;\n1;2"));
	}
	
	
	@Test
	public final void whenThereIsOneNegativeNumber () {
		assertThrows(RuntimeException.class, () -> {
			StringCalculator.add("1,2,-3,4,5");
		});
	}
	
	//Assesment
@Test
	public final void alternate() {
		Assertions.assertEquals(4, StringCalculator.add("A,1,2,3,4"));
	}
	@Test
	public final void whenMultipleNegativeNumbersArePresent() {
		assertThrows(RuntimeException.class, () -> {
			StringCalculator.add("1,2,-3,4,-5,6");
		});
	}
	@Test
	public final void whenNumbersAreGreaterThanThousandItShouldBeIgnored() {
		Assertions.assertEquals(2+1000+400, StringCalculator.add("2,1000,400,1234"));
	}
	
	@Test
	public final void countAddMethod(){
		Assertions.assertEquals(StringCalculator.getCalledCount(), StringCalculator.count);
	}
	
	@Test
	public void whenDelimeterCanBeOfAnyLength() {
		Assertions.assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void whenMultipleDelimetersArePresent() {
		Assertions.assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
	}
	@Test
	public void mulCustomDelWithAnyLength() throws Exception {
		Assertions.assertEquals(6, StringCalculator.add("//[**][%%]\n1**2%%3"));
	}
}
