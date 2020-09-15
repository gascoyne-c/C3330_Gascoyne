public class Decrypter {
	int[] decrypted_array = {0,0,0,0};
	String decrypted_string = "";

	public String decrypt(String original) { // Expecting 4 digit string.
		// add to array
		for (int i = 0; i < 4; i++){
			this.decrypted_array[i] = original.charAt(i) - 48;
		}

		// array manipulation
		mathPart();

		// swap first and third
		swapPart(0,2);

		// swap second and forth
		swapPart(1,3);

		// build string to return.
		buildSolutionString();

		return decrypted_string;
	}

	public void mathPart() {
		for (int i = 0; i < 4; i++){
			decrypted_array[i] = ( decrypted_array[i] + 3 ) % 10;
		}
	}

	public void swapPart(int swap1, int swap2) {
		int temp = this.decrypted_array[swap1];
		this.decrypted_array[swap1] = this.decrypted_array[swap2];
		this.decrypted_array[swap2] = temp;
	}

	public void buildSolutionString() {
		for (int i = 0; i < 4; i++){
			decrypted_string += this.decrypted_array[i];
		}
	}
}