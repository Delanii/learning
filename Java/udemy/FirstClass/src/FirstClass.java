public class FirstClass {
	public static void main(String[] args) {
		System.out.println("Hello Me");

		boolean isAlien = false;

		if (isAlien == false) {
			System.out.println("You are not an alien!");
			System.out.println("And that's a good thing!");
		}

		int topScore = 80;
		if (topScore <= 100) {
			System.out.println("You got the top score.");
		}

		int secondTopScore = 60;
		if ((topScore > secondTopScore) && (topScore < 100)) {
			System.out.println("Greater than the top score and less than 100.");
		}

		if ((topScore > 90) || (secondTopScore <= 90)) {
			System.out.println("One or both conditions ar true.");
		}

		boolean isCar = false;
		if (isCar) {
			System.out.println("This is not supposed to happen.");
		}

		String makeOfCar = "Volkswagen";
		boolean isDomestic = makeOfCar == "Volkswagen" ? true : false;

		if (isDomestic) {
			System.out.println("This car is domestic.");
		}

		// Challenge
		double first = 20.00;
		double second = 80.00;
		double addedVar = (first + second) * 100;
		int remainder = (int)(addedVar % 40);
		boolean test = ( remainder == 0 ) ? true : false;
		System.out.println(test);

		if (!test) {
			System.out.println("Not true.");
		}
	}
}
