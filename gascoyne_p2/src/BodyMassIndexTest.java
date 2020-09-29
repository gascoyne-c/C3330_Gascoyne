import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BodyMassIndexTest {

	@Test
	void bmiCalculator() {
		BodyMassIndex bmi = new BodyMassIndex(10, 10);
		assertEquals(bmi.calculateBmiScore(10, 10), 70.3);
	}
	
	@Test
	void bmiCalculator2() {
		BodyMassIndex bmi = new BodyMassIndex(10, 10);
		assertEquals(bmi.calculateBmiScore(50, 100), 28.12);
	}
	
	@Test
	void underweightTest() {
		BodyMassIndex bmi = new BodyMassIndex(10, 2);
		assertEquals(bmi.category, "Underweight");
	}
	
	@Test
	void normalWeightTest() {
		BodyMassIndex bmi = new BodyMassIndex(10, 3);
		assertEquals(bmi.category, "Normal weight");
	}
	
	@Test
	void overweightTest() {
		BodyMassIndex bmi = new BodyMassIndex(10, 4);
		assertEquals(bmi.category, "Overweight");
	}
	
	@Test
	void obesityTest() {
		BodyMassIndex bmi = new BodyMassIndex(10, 10);
		assertEquals(bmi.category, "Obesity");
	}

}
