import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
	@Test
	public void creationFailsWithAllBlankValues() {
		ContactList list = new ContactList();
		list.createContact("", "", "", "");
		assertEquals(list.contacts.size(), 0);
	}

	@Test
	public void creationSucceedsWithBlankEmail() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "");
		assertEquals(list.contacts.size(), 1);
	}

	@Test
	public void creationSucceedsWithBlankFirstName() {
		ContactList list = new ContactList();
		list.createContact("", "lName", "555-555-5555", "x@y.z");
		assertEquals(list.contacts.size(), 1);
	}

	@Test
	public void creationSucceedsWithBlankLastName() {
		ContactList list = new ContactList();
		list.createContact("fName", "", "555-555-5555", "x@y.z");
		assertEquals(list.contacts.size(), 1);
	}

	@Test
	public void creationSucceedsWithBlankPhone() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "", "x@y.z");
		assertEquals(list.contacts.size(), 1);
	}

	@Test
	public void creationSucceedsWithNonBlankValues() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		assertEquals(list.contacts.size(), 1);
	}

	@Test
	public void editingFailsWithAllBlankValues() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		boolean updated = list.updateContact("", "", "", "", 0);
		assertEquals(updated, false);
	}

	@Test
	public void editingSucceedsWithBlankEmail() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		list.updateContact("fName", "lName", "555-555-5555", "", 0);
		assertEquals(list.contacts.get(0).email, "");
	}

	@Test
	public void editingSucceedsWithBlankFirstName() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		list.updateContact("", "lName", "555-555-5555", "x@y.z", 0);
		assertEquals(list.contacts.get(0).fName, "");
	}

	@Test
	public void editingSucceedsWithBlankLastName() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		list.updateContact("fName", "", "555-555-5555", "x@y.z", 0);
		assertEquals(list.contacts.get(0).lName, "");
	}

	@Test
	public void editingSucceedsWithBlankPhone() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		list.updateContact("fName", "lName", "", "x@y.z", 0);
		assertEquals(list.contacts.get(0).phoneNumber, "");
	}

	@Test
	public void editingSucceedsWithNonBlankValues() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		list.updateContact("fName2", "lName2", "123-456-7890", "x@y.z2", 0);
		assertEquals(list.contacts.get(0).fName, "fName2");
	}

	@Test
	public void testToString() {
		ContactList list = new ContactList();
		list.createContact("fName", "lName", "555-555-5555", "x@y.z");
		assertEquals(list.contacts.get(0).fName, "fName");
	}
}