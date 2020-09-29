import java.util.Scanner;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

		while (moreInput()) {
			double height = getUserHeight();
			double weight = getUserWeight();

			BodyMassIndex bmi = new BodyMassIndex(height, weight);
			bmiData.add(bmi);

			displayBmiInfo(bmi);
		}

		displayBmiStatistics(bmiData);
	}

	public static boolean moreInput() {
		System.out.println("Do you want to add more data (yes or no)?");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		if (input.contains("yes")) {
			input = "true";
		} else {
			input = "false";
		}
		boolean yes_or_no = Boolean.parseBoolean(input);
		
		if (yes_or_no) {
			return true;
		}
		return false;
	}

	public static double getUserHeight() {
		System.out.println("What is your height in inches?");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		double height = Double.parseDouble(input);
		if (height < 0) {
			System.out.println("Height cannot be negative, we are changing it to the positive version of the same number");
			height = height * -1;
		}
		return height;
	}

	public static double getUserWeight() {
		System.out.println("What is your weight in pounds?");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		double weight = Double.parseDouble(input);
		if (weight < 0) {
			System.out.println("Weight cannot be negative, we are changing it to the positive version of the same number");
			weight = weight * -1;
		}
		return weight;
	}

	public static void displayBmiInfo(BodyMassIndex bmi) {
		System.out.println("Here is your BMI Data:");
		System.out.println("Your BMI Score is " + bmi.score);
		System.out.println("Your BMI category is " + bmi.category);
	}

	public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
		System.out.println("Here are your BMI Statistics:");
		double total = 0;
		for (int i = 0; i < bmiData.size(); i++) {
			total += bmiData.get(i).score;
		}
		double average = total / bmiData.size();
		System.out.println("The average BMI of all users is " + average);
	}
}