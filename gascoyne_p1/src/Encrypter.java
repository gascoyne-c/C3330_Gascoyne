public class Encrypter {
	int[] encrypted_array = {0,0,0,0};
	String encrypted_string = "";

	public String encrypt(String original) { // Expecting 4 digit string.
		// add to array
		for (int i = 0; i < 4; i++){
			this.encrypted_array[i] = original.charAt(i) - 48;
		}

		// array manipulation
		mathPart();

		// swap first and third
		swapPart(0,2);

		// swap second and forth
		swapPart(1,3);

		// build string to return.
		buildSolutionString();

		return encrypted_string;
	}

	public void mathPart() {
		for (int i = 0; i < 4; i++){
			this.encrypted_array[i] = ( this.encrypted_array[i] + 7 ) % 10;
		}
	}

	public void swapPart(int swap1, int swap2) {
		int temp = this.encrypted_array[swap1];
		this.encrypted_array[swap1] = this.encrypted_array[swap2];
		this.encrypted_array[swap2] = temp;
	}

	public void buildSolutionString() {
		for (int i = 0; i < 4; i++){
			encrypted_string += this.encrypted_array[i];
		}
	}
}