import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class TaskList {
	ArrayList<TaskItem> tasks = new ArrayList<TaskItem>();
	
	public void menu(Scanner scanner) {
		//Scanner scanner = new Scanner(System.in);
		String input = "";
		int menuItemSelected;
		boolean goBackToMainMenu = false;
		
		String title, description, dueDate;
		int selectedTaskIndex;
				
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
				System.out.print("Task Title: ");
				title = scanner.nextLine();
				System.out.print("Task description: ");
				description = scanner.nextLine();
				System.out.print("Task due date (YYYY-MM-DD): ");
				dueDate = scanner.nextLine();
				
				createTask(title, description, dueDate);
			} else if (menuItemSelected == 3) { // edit an item
				viewTheList("current");
				System.out.print("Which task will you edit? ");
				selectedTaskIndex = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter a new title for task " + selectedTaskIndex + ": ");
				title = scanner.nextLine();
				System.out.print("Enter a new description for task " + selectedTaskIndex + ": ");
				description = scanner.nextLine();
				System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + selectedTaskIndex + ": ");
				dueDate = scanner.nextLine();
				
				updateTask(title, description, dueDate, selectedTaskIndex);
			} else if (menuItemSelected == 4) { // remove an item
				viewTheList("current");
				System.out.print("Which task will you remove? ");
				
				selectedTaskIndex = Integer.parseInt(scanner.nextLine());
				removeTask(selectedTaskIndex);
			} else if (menuItemSelected == 5) { // mark an item as completed
				viewTheList("uncompleted");
				System.out.print("Which task will you mark as completed? ");
				
				selectedTaskIndex = Integer.parseInt(scanner.nextLine());
				setTaskToComplete(selectedTaskIndex);
			} else if (menuItemSelected == 6) { // unmark an item as completed
				viewTheList("completed");
				System.out.print("Which task will you unmark as completed? ");
				
				selectedTaskIndex = Integer.parseInt(scanner.nextLine());
				setTaskToUncomplete(selectedTaskIndex);
			} else if (menuItemSelected == 7) { // save the current list
				System.out.print("Enter the filename to save as: ");
				saveListToFile(scanner.nextLine());
				System.out.println("task list has been saved");
			} else if (menuItemSelected == 8) { // quit to the main menu
				goBackToMainMenu = true;
			}
			
			System.out.println();
		}
		
		//scanner.close();
	}
	
	public void displayListOperationMenu() {
		System.out.println("List Operation Menu");
		System.out.println("---------");
		System.out.println();
		System.out.println("1) view the list");
		System.out.println("2) add an item");
		System.out.println("3) edit an item");
		System.out.println("4) remove an item");
		System.out.println("5) mark an item as completed");
		System.out.println("6) unmark an item as completed");
		System.out.println("7) save the current list");
		System.out.println("8) quit to the main menu");
		System.out.print("> ");
	}
	
	public void viewTheList(String type) {
		TaskItem task;

		String title = "Current Tasks";
		if (type == "completed") {
			title = "Completed Tasks";
		} else if (type == "uncompleted") {
			title = "Uncompleted Tasks";
		}

		System.out.println();
		System.out.println(title);
		System.out.println("-------------");
		for (int i = 0; i < tasks.size(); i++) {
			task = tasks.get(i);
			if (type == "completed" && task.complete == true) {
				task.display(i);
			} else if (type == "uncompleted" && task.complete == false) {
				task.display(i);
			} else if (type == "current") {
				task.displayWithStars(i);
			}
		}
	}
	
	public void createTask(String title, String description, String dueDate) {
		if (title.length() < 1) {
			System.out.println("WARNING: title must be at least 1 character long; task not created");
		} else if (isDateValid(dueDate) == false) {
			System.out.println("WARNING: invalid due date; task not created");
		} else { // Valid
			TaskItem task = new TaskItem(title, description, dueDate);
			tasks.add(task);
			System.out.println("new task list has been created");
		}
	}
	
	public boolean updateTask(String title, String description, String dueDate, int selectedTaskIndex) {
		if ( selectedTaskIndex < 0 || selectedTaskIndex >= tasks.size() ) {
			System.out.println("WARNING: task index is outside of range");
			return false;
		}
		
		TaskItem selectedTask = tasks.get(selectedTaskIndex);
		
		if (title.length() < 1) {
			System.out.println("WARNING: title must be at least 1 character long; task not created");
		} else if (isDateValid(dueDate) == false) {
			System.out.println("WARNING: invalid due date; task not created");
		} else { // Valid
			selectedTask.update(title, description, dueDate);
			return true;
		}

		return false;
	}
	
	public boolean removeTask(int selectedTaskIndex) {
		if ( selectedTaskIndex < 0 || selectedTaskIndex >= tasks.size() ) {
			System.out.println("WARNING: task index is outside of range");
			return false;
		}
		
		tasks.remove(selectedTaskIndex);
		return true;
	}
	
	public boolean setTaskToComplete(int selectedTaskIndex) {
		if ( selectedTaskIndex < 0 || selectedTaskIndex >= tasks.size() ) {
			System.out.println("WARNING: task index is outside of range");
			return false;
		}
		
		TaskItem selectedTask = tasks.get(selectedTaskIndex);
		selectedTask.markAsComplete();
		return true;
	}
	
	public boolean setTaskToUncomplete(int selectedTaskIndex) {
		if ( selectedTaskIndex < 0 || selectedTaskIndex >= tasks.size() ) {
			System.out.println("WARNING: task index is outside of range");
			return false;
		}
		
		TaskItem selectedTask = tasks.get(selectedTaskIndex);
		selectedTask.markAsUncomplete();
		return true;
	}
	
	public String dataForTask(String data, int selectedTaskIndex) {
		if ( selectedTaskIndex < 0 || selectedTaskIndex >= tasks.size() ) {
			System.out.println("WARNING: task index is outside of range");
			return "out of index";
		}
		
		TaskItem selectedTask = tasks.get(selectedTaskIndex);
		if (data == "title") {
			return selectedTask.title;
		} else if (data == "description") {
			return selectedTask.description;
		} else if (data == "dueDate") {
			return selectedTask.dueDate;
		}
		
		return "no data";
	}
	
	public boolean isDateValid(String date) {
		if (date.length() != 10) {
			return false;
		}

		String[] dateSplit = date.split("-");
		
		if (dateSplit.length != 3) {
			return false;
		}
		
		if (dateSplit[0].length() != 4 || dateSplit[1].length() != 2 || dateSplit[2].length() != 2 ) {
			return false;
		}
		
		try {
			int year = Integer.parseInt(dateSplit[0]);
			if (year < 0 && year > 9999) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		try {
			int month = Integer.parseInt(dateSplit[1]);
			if (month < 0 && month > 12) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		try {
			int day = Integer.parseInt(dateSplit[2]);
			if (day < 0 && day > 31) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		return true;
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
		TaskItem task;
		for (int i = 0; i < tasks.size(); i++) {
			task = tasks.get(i);
			try {
				output.write(task.title + "\n");
				output.write(task.description + "\n");
				output.write(task.dueDate + "\n");
				if (task.complete == true) {
					output.write("true\n");
				} else {
					output.write("false\n");
				}
			} catch (IOException e) {
				System.out.println("Sorry, there was an error writting to the file");
			}
		}
	}
}