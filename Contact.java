/*Emerald Tresch
 * CS320
 */
package Contact;

public class Contact {
    private String contactID;  //Unique Contact ID, cannot be >10 char
    private String firstName;  //Full name of the contact, cannot be >10 char
    private String lastName;  //Email address of the contact, cannot be >10 char
    private String phoneNumber;  //Phone number of the contact, must be exactly 10 char
    private String address;  //Address of the contact, cannot be >30 char
    
    //constructors 
    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
    	
    	if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
    	
    	if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
    	
    	if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
    	
    	if (phoneNumber == null || phoneNumber.length() > 10 || phoneNumber.length() < 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
    	if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
    	
    	this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    //getters
    public String getcontactID() {
    	return this.contactID;
    }
    
    public String getFullName() {
    	return this.firstName + " " + lastName;
    }
    
    public String getphoneNumber() {
    	return this.phoneNumber;
    }
    
    public String getaddress() { 
    	return this.address;
    }
    
    //setters
    public void setcontactID(String newcontactID) {
    	if (newcontactID == null || newcontactID.length() > 10) {
    		throw new IllegalArgumentException("Invalid contact ID");
    	}
    	contactID = newcontactID;
    }
    
    public void setfirstName(String newfirstName) {
    	if (newfirstName == null || newfirstName.length() > 10) {
    		throw new IllegalArgumentException("Invalid first name");
    	}
    	firstName = newfirstName;
    }
    
    public void setlastName (String newlastName) {
    	if (newlastName == null || newlastName.length() > 10) {
    		throw new IllegalArgumentException("Invalid last name");
    	}
    	lastName = newlastName;
    }
    
    public void setphoneNumber (String newphoneNumber) {
    	if (newphoneNumber == null || newphoneNumber.length() > 10 || newphoneNumber.length() < 10) {
    		throw new IllegalArgumentException("Invalid phone number");
    	}
    	phoneNumber = newphoneNumber;
    }
    
    public void setaddress (String newaddress) {
    	if (newaddress == null || newaddress.length() > 30) {
    		throw new IllegalArgumentException("Invalid addess");
    	}
    	address = newaddress;
    } 	
}
