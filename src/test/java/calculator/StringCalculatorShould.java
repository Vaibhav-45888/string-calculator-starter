package calculator;

import static org.junit.Assert.assertThrows;

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
	
	@Test
	public final void whenNumberIsGreaterThanTwo() {
		assertThrows(RuntimeException.class, () -> {
			StringCalculator.add("1,2,3");
		});
	}
	@Test
	public final void whenNon_NumberIsUsed() {
		assertThrows(RuntimeException.class, () -> {
			StringCalculator.add("1,x");
		});
	}
}
