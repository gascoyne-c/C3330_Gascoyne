import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
	ArrayList<ContactItem> contacts = new ArrayList<ContactItem>();
	
	public void menu(Scanner scanner) {
		String input = "";
		int menuItemSelected;
		boolean goBackToMainMenu = false;
		
		String fName, lName, phoneNumber, email;
		int selectedContactIndex;
						
		while (goBackToMainMenu != true) {
			// Display menu
			displayListOperationMenu();
			
			// Get user input
			input = scanner.nextLine();
			try {
				menuItemSelected = Integer.parseInt(input);
			} catch (Exception e) {
				menuItemSelected = 0;
			}
			
			// Take action
			if (menuItemSelected == 1) { // view the list
				viewTheList("current");
			} else if (menuItemSelected == 2) { // add an item
				System.out.print("First name: ");
				fName = scanner.nextLine();
				System.out.print("Last name: ");
				lName = scanner.nextLine();
				System.out.print("Phone number (xxx-xxx-xxxx): ");
				phoneNumber = scanner.nextLine();
				System.out.print("Email address (x@y.z): ");
				email = scanner.nextLine();
				
				createContact(fName, lName, phoneNumber, email);
			} else if (menuItemSelected == 3) { // edit an item
				viewTheList("current");
				System.out.println();
				System.out.print("Which contact will you edit? ");
				selectedContactIndex = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter a new first name for contact " + selectedContactIndex + ": ");
				fName = scanner.nextLine();
				System.out.print("Enter a new last name for contact " + selectedContactIndex + ": ");
				lName = scanner.nextLine();
				System.out.print("Enter a new phone number (xxx-xxx-xxxx) for the contact " + selectedContactIndex + ": ");
				phoneNumber = scanner.nextLine();
				System.out.print("Enter a new email address (x@y.z) for contact " + selectedContactIndex + ": ");
				email = scanner.nextLine();
				
				updateContact(fName, lName, phoneNumber, email, selectedContactIndex);
			} else if (menuItemSelected == 4) { // remove an item
				viewTheList("current");
				System.out.println();
				System.out.print("Which contact will you remove? ");
				
				selectedContactIndex = Integer.parseInt(scanner.nextLine());
				removeContact(selectedContactIndex);
			} else if (menuItemSelected == 5) { // save the current list
				System.out.print("Enter the filename to save as: ");
				saveListToFile(scanner.nextLine());
				System.out.println("contact list has been saved");
			} else if (menuItemSelected == 6) { // quit to the main menu
				goBackToMainMenu = true;
			}
			
			System.out.println();
		}
	}
	
	public void displayListOperationMenu() {
		System.out.println("List Operation Menu");
		System.out.println("---------");
		System.out.println();
		System.out.println("1) view the list");
		System.out.println("2) add an item");
		System.out.println("3) edit an item");
		System.out.println("4) remove an item");
		System.out.println("5) save the current list");
		System.out.println("6) quit to the main menu");
		System.out.print("> ");
	}
	
	public void viewTheList(String type) {
		ContactItem contact;

		System.out.println();
		System.out.println("Current Contacts");
		System.out.println("-------------");
		for (int i = 0; i < contacts.size(); i++) {
			contact = contacts.get(i);
			contact.display(i);
		}
	}
	
	public void createContact(String fName, String lName, String phoneNumber, String email) {
		if (fName.length() < 1 && lName.length() < 1 && phoneNumber.length() < 1 && email.length() < 1) {
			System.out.println("WARNING: all fields cannot be empty; contact not updated");
		} else { // Valid
			ContactItem contact = new ContactItem(fName, lName, phoneNumber, email);
			contacts.add(contact);
			System.out.println("new contact has been created");
		}
	}
	
	public boolean updateContact(String fName, String lName, String phoneNumber, String email, int selectedContactIndex) {
		if (selectedContactIndex < 0 || selectedContactIndex >= contacts.size()) {
			System.out.println("WARNING: contact index is outside of range");
			return false;
		}
		
		ContactItem selectedContact = contacts.get(selectedContactIndex);
		
		if (fName.length() < 1 && lName.length() < 1 && phoneNumber.length() < 1 && email.length() < 1) {
			System.out.println("WARNING: all fields cannot be empty; contact not updated");
		} else { // Valid
			selectedContact.update(fName, lName, phoneNumber, email);
			return true;
		}
		
		return false;
	}
	
	public boolean removeContact(int selectedContactIndex) {
		if (selectedContactIndex < 0 || selectedContactIndex >= contacts.size()) {
			System.out.println("WARNING: contact index is outside of range");
			return false;
		}
		
		contacts.remove(selectedContactIndex);
		return true;
	}
	
	public String dataForContact(String data, int selectedContactIndex) {
		if (selectedContactIndex < 0 || selectedContactIndex >= contacts.size()) {
			System.out.println("WARNING: contact index is outside of range");
			return "out of index";
		}
		
		ContactItem selectedContact = contacts.get(selectedContactIndex);
		if (data == "fName") {
			return selectedContact.fName;
		} else if (data == "lName") {
			return selectedContact.lName;
		} else if (data == "phoneNumber") {
			return selectedContact.phoneNumber;
		} else if (data == "email") {
			return selectedContact.email;
		}
		
		return "no data";
	}
	
	public void saveListToFile(String outputFileName) {
		try {
			File outputFile = new File(outputFileName);
			if (outputFile.createNewFile()) {
				FileWriter outputWritter = new FileWriter(outputFileName);
				//outputWritter.write("OUTPUT GOES HERE");
				writeListDataToFile(outputWritter);
				outputWritter.close();
			} else {
				System.out.println("Sorry, the file already exists");
			}
		} catch (IOException e) {
			System.out.println("Not able to save to file");
		}
	}
	
	public void writeListDataToFile(FileWriter output) {
		ContactItem contact;
		for (int i = 0; i < contacts.size(); i++) {
			contact = contacts.get(i);
			try {
				output.write(contact.fName + "\n");
				output.write(contact.lName + "\n");
				output.write(contact.phoneNumber + "\n");
				output.write(contact.email + "\n");
			} catch (IOException e) {
				System.out.println("Sorry, there was an error writting to the file");
			}
		}
	}
}