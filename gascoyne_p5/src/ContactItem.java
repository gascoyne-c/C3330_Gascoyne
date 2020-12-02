public class ContactItem {
	String fName;
	String lName;
	String phoneNumber;
	String email;
	boolean complete = false;

	public ContactItem(String fName, String lName, String phoneNumber, String email) {
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void update(String fName, String lName, String phoneNumber, String email) {
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void display(int index) {
		System.out.println(index + ") Name: " + this.fName + " " + this.lName);
		System.out.println("Phone: " + this.phoneNumber);
		System.out.println("Email: " + this.email);
	}
}