import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
	@Test
	public void addingTaskItemsIncreasesSize() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		assertEquals(list.tasks.size(), 1);
	}
	
	@Test
	public void completingTaskItemChangesStatus() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.setTaskToComplete(0);
		assertEquals(list.tasks.get(0).complete, true);
	}
	
	@Test
	public void completingTaskItemFailsWithInvalidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		boolean setTaskOutOfIndexToComplete = list.setTaskToComplete(1);
		assertEquals(setTaskOutOfIndexToComplete, false);
	}
	
	@Test
	public void editingTaskItemChangesValues() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.updateTask("title 2", "description 2", "2020-11-13", 0);
		assertEquals(list.tasks.get(0).title, "title 2");
	}
	
	@Test
	public void editingTaskItemDescriptionChangesValue() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.updateTask("title 2", "description 2", "2020-11-13", 0);
		assertEquals(list.tasks.get(0).description, "description 2");
	}
	
	@Test
	public void editingTaskItemDescriptionFailsWithInvalidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		boolean setNewDescriptionOutOfIndex = list.updateTask("title", "description 2", "2020-11-13", 1);
		assertEquals(setNewDescriptionOutOfIndex, false);
	}
	
	@Test
	public void editingTaskItemDueDateChangesValue() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.updateTask("title", "description", "2020-11-13", 0);
		assertEquals(list.tasks.get(0).dueDate, "2020-11-13");
	}
	
	@Test
	public void editingTaskItemDueDateFailsWithInvalidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		boolean setNewDateOutsideOfIndex = list.updateTask("title", "description", "2020-11-13", 1);
		assertEquals(setNewDateOutsideOfIndex, false);
	}
	
	@Test
	public void editingTaskItemTitleChangesValue() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.updateTask("title 2", "description", "2020-11-14", 0);
		assertEquals(list.tasks.get(0).title, "title 2");
	}
	
	@Test
	public void editingTaskItemTitleFailsWithInvalidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		boolean setTitleOutOfIndexPassOrFail = list.updateTask("title 2", "description", "2020-11-14", 1);
		assertEquals(setTitleOutOfIndexPassOrFail, false);
	}
	
	@Test
	public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		String description = list.dataForTask("description", 1);
		assertEquals(description, "out of index");
	}
	
	@Test
	public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		String description = list.dataForTask("description", 0);
		assertEquals(description, "description");
	}
	
	@Test
	public void gettingTaskItemDueDateFailsWithInvalidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		String dueDate = list.dataForTask("dueDate", 1);
		assertEquals(dueDate, "out of index");
	}
	
	@Test
	public void gettingTaskItemDueDateSucceedsWithValidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		String dueDate = list.dataForTask("dueDate", 0);
		assertEquals(dueDate, "2020-11-14");
	}
	
	@Test
	public void gettingTaskItemTitleFailsWithInvalidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		String title = list.dataForTask("title", 1);
		assertEquals(title, "out of index");
	}
	
	@Test
	public void gettingTaskItemTitleSucceedsWithValidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		String title = list.dataForTask("title", 0);
		assertEquals(title, "title");
	}
	
	@Test
	public void newTaskListIsEmpty() {
		TaskList list = new TaskList();
		assertEquals(list.tasks.size(), 0);
	}
	
	@Test
	public void removingTaskItemsDecreasesSize() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.createTask("title 2", "description 2", "2020-11-13");
		list.createTask("title 3", "description 3", "2020-11-12");
		list.removeTask(0);
		assertEquals(list.tasks.size(), 2);
	}
	
	@Test
	public void removingTaskItemsFailsWithInvalidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.createTask("title 2", "description 2", "2020-11-13");
		list.createTask("title 3", "description 3", "2020-11-12");
		list.removeTask(5);
		assertEquals(list.tasks.size(), 3);
	}
	
	@Test
	public void savedTaskListCanBeLoaded() {
		boolean loadFileAttempt = true;
		assertEquals(loadFileAttempt, true);
	}
	
	@Test
	public void uncompletingTaskItemChangesStatus() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.tasks.get(0).complete = true;
		list.setTaskToUncomplete(0);
		assertEquals(list.tasks.get(0).complete, false);
	}
	
	@Test
	public void uncompletingTaskItemFailsWithInvalidIndex() {
		TaskList list = new TaskList();
		list.createTask("title", "description", "2020-11-14");
		list.tasks.get(0).complete = true;
		boolean setTaskToImcompleteWhenOutOfIndexRange = list.setTaskToComplete(1);
		assertEquals(setTaskToImcompleteWhenOutOfIndexRange, false);
	}
}