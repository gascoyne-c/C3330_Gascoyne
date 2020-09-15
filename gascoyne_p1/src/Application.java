public class Application {
	public static void main(String[] args) {
		// Create class instances
		Encrypter myEncrypter = new Encrypter(); 
		Decrypter myDecrypter = new Decrypter();

		String encryptedValue = myEncrypter.encrypt("1234");
		System.out.println(encryptedValue);

		String decryptedValue = myDecrypter.decrypt(encryptedValue);
		System.out.println(decryptedValue);
	}
}