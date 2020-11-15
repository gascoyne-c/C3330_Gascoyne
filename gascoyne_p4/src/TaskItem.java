public class TaskItem {
	String title;
	String description;
	String dueDate;
	boolean complete = false;

	public TaskItem(String title, String description, String dueDate) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
	}
	
	public void update(String title, String description, String dueDate) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
	}
	
	public void markAsComplete() {
		this.complete = true;
	}
	
	public void markAsUncomplete() {
		this.complete = false;
	}
	
	public void display(int index) {
		System.out.println(index + ") [" + this.dueDate + "] " + this.title + ": " + this.description);
	}
	
	public void displayWithStars(int index) {
		if (this.complete == true) {
			System.out.println(index + ") *** [" + this.dueDate + "] " + this.title + ": " + this.description);
		} else {
			System.out.println(index + ") [" + this.dueDate + "] " + this.title + ": " + this.description);
		}
	}
}