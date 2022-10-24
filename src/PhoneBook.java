import java.util.*;

//Programmer: Quinn Murphy
//Date: 10/20/22
//Assignment 1: PhoneBook
//Class: CS145
//References: StackOverflow, YouTube, 
 // class discussion page
// Here is the phonebook class. It is 
// seperate from PhoneBookManager,
// but includes the first initialization
// of the phonebook object, and the toString.


// Phone book start here
public class PhoneBook {
    String name;
    String address;
    String city;
    String PhoneNumber;
    PhoneBook next; // we are gonna use this to 
    				// intitialize a next node.
    
    // a few different ways we can initialize the 
    // phone book, this is one.
    void add(PhoneBook pb) {

    }
    
    
    // simple toString method. Prints contact info.
    public String toString() {
        return "PhoneBook [name=" + name + ", address=" + address + ", city=" +
            city + ", PhoneNumber=" + PhoneNumber + "]";
    }
    
    
    // initialize phone book for entry mode
    public PhoneBook(String name, String address, String city,
        String phoneNumber) {
      
        this.name = name;
        this.address = address;
        this.city = city;
        PhoneNumber = phoneNumber; // we will use PhoneNumber as
        						   // a object to essentially 
        						   // use a temp.equals(PhoneNumber)
        						   // so the user will be able to input a number
        						   // for the phonebook to find. 
        this.next = null;   
    }

}

//Programmer: Quinn Murphy
//Date: 10/20/22
//Assignment 1: PhoneBook
//Class: CS145
//References: StackOverflow, YouTube, 
			   // class discussion page
// the PhoneBookManager class. Has the viewcontacts, 
// add, modify, and delete functions. 


 class PhoneBookManager {
    PhoneBook start;
    void viewContacts() {
    	// simple kind of toString method.
    	// we use system.out.format to get out 
    	// name address city and number to display in a nice manner.
        PhoneBook temp = start;
        boolean isEmpty = true;
        if (temp != null)
        	// since we set temp to start, we are head of list...
        	// so while temp has strings, print them.
            System.out.format("%-10s%-10s%-10s%-10s\n", "Name", "Address", "City", "Number");
        while (temp != null) {
            System.out.format("%-10s%-10s%-10s%-10s\n", temp.name, temp.address, temp.city, temp.PhoneNumber);
            temp = temp.next;
            isEmpty = false;
        }
        if (isEmpty)
            System.out.println("Phonebook is empty");

    }
    // adds the node, keeps track of different
    // numbers
    // found this on stackOverflow forum that was posted
    // to the discussion form.
   public void add(PhoneBook pb) {
        PhoneBook current;
       
      // if head node, set to start
        if (start == null || start.name.compareTo(pb.name) >= 0) {
          
            pb.next = start;
            start = pb;
        } else {

         // set node to start
            current = start;

            while (current.next != null && current.next.name.compareTo(pb.name) < 0)

                current = current.next;

            pb.next = current.next;
            current.next = pb;
        }
    }
   public void modify(String PhoneNumber) {
        PhoneBook temp = start;
        boolean found = false;
        while (temp != null) {
            if (temp.PhoneNumber.equals(PhoneNumber)) {
                found = true;
                break;

            }
            temp = temp.next;
        }
        if (found) {
        	// again, gives user options to modify.
        	// sets them equal to strings, and puts
        	// strings into node by setting the 
        	// temp to our new strings. It works!
            Scanner scan = new Scanner(System.in);
            System.out.println(temp.toString());
            System.out.println("enter new Details");
            System.out.println("New Name?");
            String name = scan.next();
            System.out.println("New address?");
            String address = scan.next();
            System.out.println("New City?");
            String city = scan.next();
            System.out.println("New Phone Number? ");
            String phonenumber = scan.next();
            
            // set contact to our new info
            temp.name = name;
            temp.address = address;
            temp.city = city;
            temp.PhoneNumber = phonenumber;
            System.out.println("Successfully updated contact!");
        } else {
            System.out.println("Number not found.");
        }

    }
  
   public void delete(String PhoneNumber) {
        //if the contact is starting node.
        if (start.PhoneNumber.equals(PhoneNumber)) {
            start = start.next;
            return;
        }
        PhoneBook temp = start;
        PhoneBook prev = null;
        boolean found = false;
        while (temp != null) {
        	// if the user input phonenumber equals a 
        	// phonenumber, break. if not, continue
        	// with temp.next to keep while looping
        	// through the node. 
            if (temp.PhoneNumber.equals(PhoneNumber)) {
                found = true;
                break;

            }
            prev = temp;
            temp = temp.next;
        }
        if (found) {
            if (start.next != null)
                prev.next = temp.next;
            else
                start = null; // set to null to delete a PhoneBook node.
            System.out.println("Contact Deleted");
        } else {
            System.out.println("Number not found.");
        }

    }

}

	
	
	
	
	
	


