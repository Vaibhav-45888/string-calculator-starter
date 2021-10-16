package calculator;

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

}
