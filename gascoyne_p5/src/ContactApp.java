import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactApp {
	
	public void menu(Scanner scanner) {
		String input = "";
		int menuItemSelected;
		boolean goBackToMainMenu = false;
				
		while (goBackToMainMenu != true) {
			// Display menu
			displayContactAppMenu();
			
			// Get user input
			input = scanner.nextLine();
			try {
				menuItemSelected = Integer.parseInt(input);
			} catch (Exception e) {
				menuItemSelected = 0;
			}
			
			// Take action
			if (menuItemSelected == 1) { // create a new list
				ContactList list = new ContactList();
				list.menu(scanner);
			} else if (menuItemSelected == 2) { // load an existing list
				System.out.print("Enter the filename to load: ");
				loadListFromFile(scanner.nextLine(), scanner);
			} else if (menuItemSelected == 3) { // quit
				goBackToMainMenu = true;
			}
			
			System.out.println();
		}
	}
	
	public void displayContactAppMenu() {
		System.out.println("Main Menu");
		System.out.println("---------");
		System.out.println();
		System.out.println("1) create a new list");
		System.out.println("2) load an existing list");
		System.out.println("3) quit");
		System.out.print("> ");
	}
	
	public static void loadListFromFile(String fileToLoadListFrom, Scanner scanner) {
		try {
			ArrayList<String> fileData = new ArrayList<String>();
			String fName, lName, phoneNumber, email;
			File fileToReadFrom = new File(fileToLoadListFrom);
			Scanner fileScanner = new Scanner(fileToReadFrom);
			ContactList list = new ContactList();
			
			while (fileScanner.hasNextLine()) {
				fileData.add(fileScanner.nextLine());
			}
			
			for(int i = 0; i < fileData.size() - 1; i = i + 4) {
				fName = fileData.get(i);
				lName = fileData.get(i+1);
				phoneNumber = fileData.get(i+2);
				email = fileData.get(i+3);				
				ContactItem contact = new ContactItem(fName, lName, phoneNumber, email);
				list.contacts.add(contact);
			}
			list.menu(scanner);
			
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, the file was not found");
		}
	}
}