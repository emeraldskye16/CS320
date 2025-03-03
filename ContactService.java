/*Emerald Tresch
 * CS320
 */
package Contact;

import java.util.Vector;
import java.util.Random;

public class ContactService {
	//Create a vector to store contacts.
	private Vector<Contact> contactList = new Vector<Contact>();
	
	//Create an int counter to store the number of contacts.
	private int numContacts = 0;
	
	//Getter for numContacts
	public int getNumContacts() {
		return numContacts;
	}
		
	//Getter for the list of contacts.
	public Vector<Contact> getContactList(){
		return contactList;
	}

	//Function to add a contact to the list.
	public void addContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		//Create a new contact
		Contact newContact = new Contact(
				contactID, 
				firstName, 
				lastName, 
				phoneNumber, 
				address);
		
		//Add the contact to the list of contacts.
		contactList.add(newContact);
		
		//Increment the number of contacts.
		numContacts++;
	}
	
	public void addContact(Contact contact) {
		//Add the contact to the list of contacts.
		contactList.add(contact);
		
		//Increment the number of contacts.
		numContacts++;
	}
	
	//Function to add a contact to the list.
	public void removeContact(String contactID) {
			
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
			
		if (contactList.isEmpty()) {
			throw new IllegalArgumentException("There are no contacts saved.");
		}
			
		int index = -1;
		for (Contact c : contactList) {
			if (c.getcontactID() == contactID) {
				index = contactList.indexOf(c);
			}
		}
			
		if (index == -1) {
			System.out.println("Not found.");
			return;
		}
			
		else {
			contactList.remove(index);
			numContacts--;
			System.out.println("Removed.");
		}
	}
		
	public void removeContact(Contact contact) {
		contactList.remove(contact);
		numContacts --;
	}
	
	//Update contact
	public void updateContact(String contactID, String update, int selection) {
		if (contactID == null || contactID.length() > 10 || update == null || selection < 0) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		
		if (contactList.isEmpty()) {
			throw new IllegalArgumentException("There are no contacts to update.");
		}
		
		int index = -1;
		
		for (Contact c : contactList) {
			if (c.getcontactID() == contactID) {
				index = contactList.indexOf(c);
			}
		}
		
		if (index == -1) {
			System.out.println("Not found");
			return;
		}
		
		Contact updatedContact = contactList.get(index);
		
		switch(selection) {
			case 1:{
				updatedContact.setfirstName(update);
				break;
			}
			
			case 2:{
				updatedContact.setlastName(update);
				break;
			}
			
			case 3:{
				updatedContact.setphoneNumber(update);
				break;
			}
			
			case 4:{
				updatedContact.setaddress(update);
				break;
			}
			
			default:{
				removeContact(contactList.elementAt(index));
				addContact(updatedContact);
			}
		}
		
	}
	public void updatedContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID.");
		}
		
		if (contactList.isEmpty()) {
			throw new IllegalArgumentException("There are no contacts.");
		}
		
		int index = -1;
		
		for (Contact c: contactList) {
			if (c.getcontactID() == contactID) {
				index = contactList.indexOf(c);
			}
		}
		
		if (index == -1) {
			System.out.println("Not found");
			return;
		}
		
		Contact tempContact = contactList.get(index);
		
		tempContact.setfirstName(firstName);
		tempContact.setlastName(lastName);
		tempContact.setphoneNumber(phoneNumber);
		tempContact.setaddress(address);
		
		contactList.remove(index);
		contactList.add(tempContact);
	}
	
	public String generateUniqueId() {
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String uniqueID = Integer.toString(newID);
		
		for (Contact c: contactList) {
			while(c.getcontactID() == uniqueID) {
				newID = rand.nextInt(1000000000);
				uniqueID = Integer.toString(newID);
			}
		}
		
		System.out.println("New Contact ID created: " + uniqueID);
		return uniqueID;
	}
}
