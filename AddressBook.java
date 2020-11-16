import java.io.*;
import java.util.Scanner;

    class Contact {

    private String firstname; 
    private String lastname; 
    private String address;  
    private String city; 
    private String state; 
    private long phonenumber; 
    private long zip;  

    
    public Contact(String firstname, String lastname, String address, String city, String state, long phonenumber, long zip) {
		this.firstname=firstname;
        this.lastname=lastname;
        this.address=address;
        this.city=city;
        this.state=state;
        this.phonenumber=phonenumber;
        this.zip=zip;
    }

    
    public String getfirstName() {
		return firstname;
    }

     
    public String getlastName() {
        return lastname;
    }

     
    public String getAddress() {
        return address;
    }

     
    public String getCity() {
        return city;
    }

    
    public String getState() {
        return state;
    }

    
    public long getNumber() {
		return phonenumber;
    }

    
    public long zip() {
        return zip;
    }

    
    public void printcontact() {
		System.out.println("Name: " +firstname+" "+lastname);
		System.out.println("Phone: " +phonenumber);
		System.out.println("Address: "+address);
		System.out.println("City: "+city);
		System.out.println("State: "+state);
		System.out.println("Pin code: "+zip);
		System.out.println("  ");
		
    }

}
public class AddressBook {

    private Contact[] persons; // An array of Contacts - each stores info for one friend
    private int num_of_persons; // Number of persons currently in AddressBook

    // Create an empty AddressBook
    public AddressBook() {
		persons = new Contact[50];
		num_of_persons = 0;
    }

    // Add a contact that's passed in as a parameter.
    public void addcontact(Contact c) {
		persons[num_of_persons] = c;
		num_of_persons++;
		System.out.println("    ");
		System.out.println("New contact is successfully added.");
    }

    // Print out info on all contacts using method Contact class.
    public void printcontacts() {
		for (int i=0;i<num_of_persons;i++)
	    	persons[i].printcontact();
		    System.out.println("    ");
		    System.out.println("    ");
    }

    // Returns the number of persons currently in AddressBook
    public int numcontacts() {
		return num_of_persons;
    }

    // Returns index where contact is present otherwise Returns -1
    private int havecontact(String fn, String ln) {

		for (int i=0;i<num_of_persons;i++)
	    	if (persons[i].getfirstName().equals(fn) && persons[i].getlastName().equals(ln))
				return i;
		return -1;
    }

    // Deletes a contact with name s, if one is in the AddressBook.
    public void deletecontact(String fn, String ln) {

		int place = havecontact(fn,ln);
		if (place >= 0) {
	    	persons[place] = persons[num_of_persons-1];
	    	num_of_persons--;
	    	System.out.println("Contact succesfully deleted.");
		}
		else
			System.out.println("Contact Not Present.");
    }

    public static void main(String[] args) throws IOException {

    	System.out.println("    ");
    	System.out.println("Welcome to the AddressBook program");
    	Scanner stdin = new Scanner(System.in);

		// Instantiate AddressBook object
		AddressBook cont = new AddressBook();

 		// Menu driven loop.
		menu();
		int choice = stdin.nextInt();


		while (choice!=5) {

	    	// Only adds contact if there is room in AddressBook cont.
	    	if (choice == 1) {

				if (cont.numcontacts() < 10) {

		    		//Reads in all appropriate information.");
		    		System.out.print("Enter First name: ");
		    		String firstname = stdin.next();
		    		System.out.print("Enter Last name: ");
		    		String lastname = stdin.next();
		    		stdin.nextLine();
		    		System.out.print("Enter Address: ");
		    		String address = stdin.nextLine();
		    		System.out.print("Enter City name: ");
		    		String city = stdin.next();
		    		System.out.print("Enter State name: ");
		    		String state = stdin.next();
		    		System.out.print("Enter Phone number: ");
		    		long phonenumber = stdin.nextLong();
		    		System.out.print("Enter Zip Code: ");
		    		long zip = stdin.nextLong();

		    		// Uses information to create Contact object, which is
		    		// a parameter to the addContact method.
		    		cont.addcontact(new Contact(firstname,lastname,address,city,state,phonenumber,zip));
				}
				else
		    		System.out.println("Sorry, can not add anyone, your AddressBook is full.");
	    	}

	    	// Implements rest of the choices by calling appropriate AddressBook methods on cont.
	    	else if (choice == 2) {
				System.out.println("What is the first name of the contact you want to delete?");
				String fname = stdin.next();
				System.out.println("What is the last name of the contact you want to delete?");
				String lname = stdin.next();
				cont.deletecontact(fname, lname);
				System.out.println("  ");
				System.out.println("Contact is successfully deleted");
	    	}
	    	else if (choice == 3) {
				System.out.println("You have " + cont.numcontacts() + " contacts in your AddressBook.");
	    	}
	    	else if (choice == 4) {
				cont.printcontacts();
	    	}
	    	else if (choice !=5) {
				System.out.println("Sorry, that was an invalid menu choice, try again.");
	    	}

	    	menu();
	    	choice = stdin.nextInt();
		}
		stdin.close();
    }

    public static void menu() {
    	System.out.println("    ");
    	System.out.println("Select one option from below=");
    	System.out.println("    ");
    	System.out.println("1.Add a new contact to your address book.");
		System.out.println("2.Delete a contact from your address book.");
		System.out.println("3.Print out the number of contacts you have.");
		System.out.println("4.Print out information of all of your contacts.");
		System.out.println("5.Quit.");
		System.out.println("    ");
		System.out.println("Enter your menu choice: ");
    }
}
