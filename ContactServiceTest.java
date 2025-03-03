/*Emerald Tresch
 * CS320
 */

package ContactTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions; 
import org.junit.jupiter.api.Test;

import Contact.Contact;
import Contact.ContactService;

class ContactServiceTest {

	@Test
	void testAddContactMethod() {
		//create a contact
		ContactService contactService = new ContactService();
		String testID = contactService.generateUniqueId();
		Contact contact = new Contact(testID, "Ricky", "Simon", "9499713241", "1234 Banyonwood Road");
		
		//add contact to the list
		contactService.addContact(contact);
		
		//confirm contact is in the list, count is not zero
		assertTrue(!contactService.getContactList().isEmpty());
		assertTrue(contactService
				.getContactList()
				.elementAt(0)
				.getcontactID()
				.equals(testID));
		assertTrue(contactService.getNumContacts() > 0);
	}
	
	@Test
	void testRemoveContactMethod() {
		ContactService contactService = new ContactService();
		//create new contact
		Contact contact = new Contact("123456", "Ricky", "Simon", "9499713241", "1234 Banyonwood Road");
		
		//try to remove with null id
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("");
		});
		
		//try to remove with id that's too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("12345678901");
		});
		
		//try to remove from empty list
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("1234567890");
		});
		
		//add the contact
		contactService.addContact(contact);
		
		//remove a contact that isn't there
		contactService.removeContact("123457");
		
		//contact list is not empty, count is not zero
		//contact not removed because contact doesn't exist
		assertTrue(!contactService.getContactList().isEmpty());
		assertTrue(contactService.getNumContacts() != 0);
		
		//remove correct contact
		contactService.removeContact("123456");
		
		//list is empty, count is zero, contact successfully removed
		assertTrue(contactService.getNumContacts() == 0);
		assertTrue(contactService.getContactList().isEmpty());
		
	}
	
	@Test
	void testUpdateContactMethodErrors() {
		ContactService contactService = new ContactService();
		//contact list is empty
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456", "Richard", 1);
		});
		
		//create new contact, add to list
		Contact contact = new Contact("123456", "Ricky", "Simon", "9499713241", "1234 Banyonwood Road");
		contactService.addContact(contact);
		//check that contact was added
		assertTrue(!contactService.getContactList().isEmpty());
		
		//id is too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("12345678901", "Richard", 1);
		});
		//id is null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(null, "Richard", 1);
		});
		//update value is null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456", null, 1);
		});
		//selection value is less than zero
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456", "Richard", -1);
		});
		
		// print "contact not found" to console
		contactService.updateContact("123457", "Richard", 1);
		
		//print "contact not updated" to console
		contactService.updateContact("123456", "Richard", 5);
		
	}
	
	@Test
	void testUpdateContactMethod() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("123456", "Ricky", "Simon", "9499713241", "1234 Banyonwood Road");
		contactService.addContact(contact);
		assertTrue(!contactService.getContactList().isEmpty());
		//contact ID cannot be updated. 
		
		//update first name
		contactService.updateContact("123456", "Richard", 1);
		assertTrue(contactService
				.getContactList()
				.elementAt(0)
				.getFullName()
				.equals("Richard Simon"));
		//update last name
		contactService.updateContact("123456", "Smith", 2);
		assertTrue(contactService
				.getContactList()
				.elementAt(0)
				.getFullName()
				.equals("Richard Smith"));
		//update phone number
		contactService.updateContact("123456", "2029182132", 3);
		assertTrue(contactService
				.getContactList()
				.elementAt(0)
				.getphoneNumber()
				.equals("2029182132"));
		//update address
		contactService.updateContact("123456", "589 Honey Creek Ave", 4);
		assertTrue(contactService
				.getContactList()
				.elementAt(0)
				.getaddress()
				.equals("589 Honey Creek Ave"));
		
		//update first name too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456", "RichardSmith", 1);
		});
				
		//check that list has been updated
		//only one contact in list, check that it's updated by checking name
		assertTrue(contactService.getNumContacts() == 1);
		assertTrue(contactService.getContactList().elementAt(0)
				.getFullName().equals("Richard Smith"));
				
	}
}