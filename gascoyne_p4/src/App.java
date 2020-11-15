import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

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
				System.out.println("new task list has been created");
				TaskList list = new TaskList();
				list.menu(scanner);
			} else if (menuItemSelected == 2) { // load an existing list
				System.out.print("Enter the filename to load: ");
				loadListFromFile(scanner.nextLine(), scanner);
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
		System.out.println("Main Menu");
		System.out.println("---------");
		System.out.println();
		System.out.println("1) create a new list");
		System.out.println("2) load an existing list");
		System.out.println("3) quit");
		System.out.println();
		System.out.print("> ");
	}
	
	public static void loadListFromFile(String fileToLoadListFrom, Scanner scanner) {
		try {
			ArrayList<String> fileData = new ArrayList<String>();
			String title, description, dueDate, complete;
			File fileToReadFrom = new File(fileToLoadListFrom);
			Scanner fileScanner = new Scanner(fileToReadFrom);
			TaskList list = new TaskList();
			
			while (fileScanner.hasNextLine()) {
				fileData.add(fileScanner.nextLine());
			}
			
			int count = 0;
			for(int i = 0; i < fileData.size() - 1; i = i + 4) {
				title = fileData.get(i);
				description = fileData.get(i+1);
				dueDate = fileData.get(i+2);
				complete = fileData.get(i+3);				
				TaskItem task = new TaskItem(title, description, dueDate);
				list.tasks.add(task);
				if (complete.contains("true")) {
					list.tasks.get(count).markAsComplete();
				} else {
					list.tasks.get(count).markAsUncomplete();
				}
				count++;
			}
			list.menu(scanner);
			
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, the file was not found");
		}
	}
}