package calculator;

class StringCalculator {

	public static int add(String numbers) {
		int sum = 0;
		String[] arr = numbers.split(",");
		if (arr.length > 2) {
			throw new RuntimeException("Only Two Numbers are allowed.");
		} else {
			for (String number : arr) {
				if (!number.trim().isEmpty()) {
					sum = sum + Integer.parseInt(number);
				}
			}
		}
		return sum;
	}
}
