import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		int menuItemSelected;
		boolean quitProgram = false;
		
		while (quitProgram != true) {
			// Information for user.
			displayMenu();
			
			// Get user input
			input = scanner.nextLine();
			try {
				menuItemSelected = Integer.parseInt(input);
			} catch (Exception e) {
				menuItemSelected = 0;
			}
			
			// Take action
			if (menuItemSelected == 1) { // create new list
				TaskApp app = new TaskApp();
				app.menu(scanner);
			} else if (menuItemSelected == 2) { // contact list
				ContactApp app = new ContactApp();
				app.menu(scanner);
			} else if (menuItemSelected == 3) { // quit
				quitProgram = true;
			}
			
			// Extra return for spacing between actions
			System.out.println();
		}
		
		scanner.close();
		System.out.println("The End");
	}
	
	public static void displayMenu() {
		System.out.println("Select Your Application");
		System.out.println("---------");
		System.out.println();
		System.out.println("1) task list");
		System.out.println("2) contact list");
		System.out.println("3) quit");
		System.out.println();
		System.out.print("> ");
	}
}