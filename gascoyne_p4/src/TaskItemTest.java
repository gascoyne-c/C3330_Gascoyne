import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
	@Test
	public void creatingTaskItemFailsWithInvalidDueDate() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "NOT VALID DUE DATE");
		assertEquals(list.tasks.size(), 0);
	}
	
	@Test
	public void creatingTaskItemFailsWithInvalidTitle() {
		TaskList list = new TaskList();
		list.createTask("", "description", "2020-11-14");
		assertEquals(list.tasks.size(), 0);
	}
	
	@Test
	public void creatingTaskItemSucceedsWithValidDueDate() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		assertEquals(list.tasks.get(0).dueDate, "2020-11-14");
	}
	
	@Test
	public void creatingTaskItemSucceedsWithValidTitle() {
		TaskList list = new TaskList();
		list.createTask("title test", "description", "2020-11-14");
		assertEquals(list.tasks.get(0).title, "title test");
	}
	
	@Test
	public void settingTaskItemDueDateFailsWithInvalidDate() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.updateTask("title", "description", "NOT VALID DUE DATE", 0);
		assertEquals(list.tasks.get(0).dueDate, "2020-11-14");
	}
	
	@Test
	public void settingTaskItemDueDateSucceedsWithValidDate() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.updateTask("title", "description", "2020-11-13", 0);
		assertEquals(list.tasks.get(0).dueDate, "2020-11-13");
	}
	
	@Test
	public void settingTaskItemTitleFailsWithInvalidTitle() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.updateTask("", "description", "2020-11-13", 0);
		assertEquals(list.tasks.get(0).title, "title");
	}
	
	@Test
	public void settingTaskItemTitleSucceedsWithValidTitle() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.updateTask("new title", "description", "2020-11-13", 0);
		assertEquals(list.tasks.get(0).title, "new title");
	}
}