public class BodyMassIndex {
	double score = 0;
	String category = "";

	public BodyMassIndex(double inches, double pounds) {
		this.score = calculateBmiScore(inches, pounds);

		this.category = getBmiCategory(inches, pounds);
	}

	public double calculateBmiScore(double inches, double pounds) {
		return 703 * pounds / Math.pow(inches, 2);
	}

	public String getBmiCategory(double inches, double pounds) {
		double score = calculateBmiScore(inches, pounds);
		if (score <= 18.5) {
			return "Underweight";
		} else if (score <= 24.9) {
			return "Normal weight";
		} else if (score <= 29.9) {
			return "Overweight";
		}
		return "Obesity";
	}
}