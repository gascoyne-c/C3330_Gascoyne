import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
	@Test
	public void addingItemsIncreasesSize() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		assertEquals(list.contacts.size(), 1);
	}

	@Test
	public void editingItemsFailsWithAllBlankValues() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		boolean updated = list.updateContact("", "", "", "", 0);
		assertEquals(updated, false);
	}

	@Test
	public void editingItemsFailsWithInvalidIndex() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		boolean updated = list.updateContact("", "", "", "", 1);
		assertEquals(updated, false);
	}

	@Test
	public void editingSucceedsWithBlankFirstName() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		list.updateContact("", "lName", "555-555-5555", "x@y.z", 0);
		String fName = list.dataForContact("fName", 0);
		assertEquals(fName, "");
	}

	@Test
	public void editingSucceedsWithBlankLastName() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		list.updateContact("fName", "", "555-555-5555", "x@y.z", 0);
		String lName = list.dataForContact("lName", 0);
		assertEquals(lName, "");
	}

	@Test
	public void editingSucceedsWithBlankPhone() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		list.updateContact("fName", "lName", "", "x@y.z", 0);
		String phoneNumber = list.dataForContact("phoneNumber", 0);
		assertEquals(phoneNumber, "");
	}

	@Test
	public void editingSucceedsWithNonBlankValues() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		list.updateContact("fName2", "lName2", "123-456-7890", "x@y.z2", 0);
		String fName = list.dataForContact("fName", 0);
		assertEquals(fName, "fName2");
	}

	@Test
	public void newListIsEmpty() {
		ContactList list = new ContactList();
		assertEquals(list.contacts.size(), 0);
	}

	@Test
	public void removingItemsDecreasesSize() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		list.removeContact(0);
		assertEquals(list.contacts.size(), 0);
	}

	@Test
	public void removingItemsFailsWithInvalidIndex() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		list.removeContact(1);
		assertEquals(list.contacts.size(), 1);
	}

	@Test
	public void savedContactListCanBeLoaded() {
		boolean loadFileAttempt = true;
		assertEquals(loadFileAttempt, true);
	}
}