import java.util.Scanner;

// Programmer: Quinn Murphy
// Date: 10/20/22
// Assignment 1: PhoneBook
// Class: CS145
// References: StackOverflow, YouTube, 
			   // class discussion page
// Alright so this program is a bit weird.
// The "modify", "Delete Contact", and
// "Show contacts" work perfectly. The "add"
// feature will work as expected with one contact.
// But more then one will result in the names not
// being displayed or being able to type them.
// You CAN modify the contact by its phonenumber 
// to make it display a name (and that will work), 
// so it kind of works?

public class mainClass {
	 public static void main(String[] args) {
		 // we are gonna call a new phonebook, and add to it. 
	        PhoneBookManager phoneManager = new PhoneBookManager();
	        Scanner scan = new Scanner(System.in);
	        System.out.println("What would you like to do?");
			System.out.println("1. Add New Contact");
			System.out.println("2. Show Contacts");
			System.out.println("3. Modify Contact");
			System.out.println("4. Delete Contact (Using Phone Number)");
			System.out.println("5. Quit Program");
			
			boolean quit = true;
	       
			 int UserChoice = scan.nextInt();
		     scan.nextLine();
	        while (quit) {
	        	// simple while loop checking for user input, 
	        	// just like all our other programs.
	            switch (UserChoice) {
	            // used a switch case here, for fun.
	            case 1:
	            	// Ok so in theory this is simple enough.
	            	// We just set the scan.nextLine (user input)
	            	// to a string. Then after all the details,
	            	// we set a new phonebook equal to them, 
	            	// and then use our "add" method. 
	                System.out.println("Enter details. Name?");
	                String name1 = scan.nextLine();
	           
	                System.out.println("Address?");
	                String address = scan.nextLine();
	                System.out.println("City?");
	                String city = scan.nextLine();
	                System.out.println("Phone Number?");
	                String phonenumber = scan.nextLine();
	                // add new contact to phone book
	                PhoneBook pbook = new PhoneBook(name1, address, city, phonenumber);
	                phoneManager.add(pbook);
	                

	            case 2:
	            	// literally just calls a toString on all 
	            	// contacts.
	                phoneManager.viewContacts();
	            	break;
	            case 3: 
	            	// this works. You can enter a phoneNumber to 
	            	// edit a contact. Originally I wanted to use
	            	// the first name, but because of the glitches i 
	            	// just used the phonenumber itself.
	                System.out.println("enter number to edit");
	                phoneManager.viewContacts();
	                System.out.println("\n\n");
	                String phonenumber11 = scan.next();

	                phoneManager.modify(phonenumber11);
	                break;

	            case 4:
	            	// also works. Just enter a number to delete, 
	            	// and it will set the node to null.
	                System.out.println("Enter number to be deleted");
	                phoneManager.viewContacts();
	                System.out.println("\n\n");
	                String number = scan.next();
	                phoneManager.delete(number);
	                break;
	                
	            case 5: 
	            	System.out.println("Thanks for using the phone book!");
	            	System.exit(0);
	    			quit = false;
	    			break;
	            	

	            } 
	           //  just for infinite loop sake I added this just incase
	          //   we somehow leave the while loop.
	           
	            System.out.println("What would you like to do?");
				System.out.println("1. Add New Contact");
				System.out.println("2. Show Contacts");
				System.out.println("3. Modify Contact");
				System.out.println("4. Delete Contact (Using Phone Number)");
				System.out.println("5. Quit Program");
	            UserChoice = scan.nextInt();
	            
	            
	            

	        }
	    }
}
