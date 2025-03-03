/*Emerald Tresch
 * CS320
 */
package ContactTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions; 
import org.junit.jupiter.api.Test;

import Contact.Contact;

class ContactTest {

	@Test
	void testContactNullArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
	}
		
	@Test
	void testContactAndGetters() {
		Contact contact = new Contact("654321", "Mona", "Hull", "4722741232", "427 2nd Rd.");
		assertTrue(contact.getFullName().equals("Mona Hull"));
		assertTrue(contact.getphoneNumber().equals("4722741232"));
		assertTrue(contact.getaddress().equals("427 2nd Rd."));
		assertTrue(contact.getcontactID().equals("654321"));
	}
		
	@Test
	void testSetFirstAndLastName() {
		Contact contact = new Contact("654321", "Mona", "Hull", "4722741232", "427 2nd Rd.");
		contact.setfirstName("Mona");
		contact.setlastName("Hull");
		assertTrue(contact.getFullName().equals("Mona Hull"));
	}
		
	@Test
	void testSetPhoneNumberAndAddress() {
		Contact contact = new Contact("654321", "Mona", "Hull", "4722741232", "427 2nd Rd.");
		contact.setphoneNumber("4722741232");
		contact.setaddress("427 2nd Rd.");
		assertTrue(contact.getphoneNumber().equals("4722741232"));
		assertTrue(contact.getaddress().equals("427 2nd Rd."));
	}
		
	@Test
	void testNullSetAttributes() {
		Contact contact = new Contact("654321", "Mona", "Hull", "4722741232", "427 2nd Rd.");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setfirstName(null);
			});
			Assertions.assertThrows(IllegalArgumentException.class, () ->{
				contact.setlastName(null);
			});
			Assertions.assertThrows(IllegalArgumentException.class, () ->{
				contact.setaddress(null);
			});
			Assertions.assertThrows(IllegalArgumentException.class, () ->{
				contact.setphoneNumber(null);
			});
		}
		
	@Test
	void testAllGetters() {
		Contact contact = new Contact("654321", "Mona", "Hull", "4722741232", "427 2nd Rd.");
		assertTrue(contact.getFullName().equals("Mona Hull"));
		assertTrue(contact.getcontactID().equals("654321"));
		assertTrue(contact.getphoneNumber().equals("4722741232"));
		assertTrue(contact.getaddress().equals("427 2nd Rd."));
	}
}
