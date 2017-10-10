
/**
 * @author Nicholas Senador

 * 
 * Assignment #3
 * 
 * PURPOSE OF THIS PROGRAM
 * The purpose of this program is to create a temporary bank record created by user input. The bank record will be
 * composed of a LinkedList using the java library to store Customer objects using Customer class. The program needs
 * to be able add records, show records, deposit money, withdraw money, change first name, last name, phone number, 
 * and delete records. Assumptions made are that no customer has the same first and last name and that balance can 
 * never be less than 0.
 * 
 * SOLUTION FOR PROGRAM
 * The bank record needs to be stored in a LinkedList from the java library. The type of objects in the LinkedList
 * will be Customer objects.
 * For user input on what to do, a menu needs to be made and the customer will input the menu command number. Each 
 * command will have it's own method or methods.
 * 0. first we need to print the menu, this will be it's own method since we need to call this many times to get back to it.
 * 		switch statement to decide what to do with user input
 * 1. Show all records - go through LinkedList of customers one by one and printing first name, last name, phone number, and balance for each Customer object.
 * 						This will also prompt user to enter a number to select a customer. 0 for no selection.
 * 2. Delete selected record - Remove select - 1 from LinkedList. If select = 0, does not remove anything.
 * 3. Change first name - match first and last name of customer with user input, if not matched, retry
 * 4. Change last name - match first and last name of customer with user input, if not matched, retry
 * 5. add a new record - user input for each value, set values with customer setters, add customer to LinkedList
 * 6. Change phone number - match first and last name of customer with user input, if not matched, retry
 * 7. Withdraw an amount - match first and last name of customer with user input, if not matched, retry
 * 						   subtract user input withdraw(first character $) from that customer's current balance
 * 8. add deposit - match first and last name of customer with user input, if not matched, retry
 * 					add user input(first character $) deposit to that customer's current balance
 * 9. quit - call method that terminates program
 * 
 * DATA STRUCTURES
 * LinkedList to store all of the customer objects
 * int for the value of the selected record 
 * 
 * HOW TO USE
 * Running the program,will display a menu and asks for input
 * Type the number of the command only
 * The user will want to use command 5 start creating input into record
 * First names, last names, and phone numbers can not have spaces
 * To delete a record, list all records, and then input the number of the customer the user wants to select. Then use the delete command.
 * Can not withdraw more than what the customer currently has
 * Any time the user is typing in a balance, withdraw, or deposit for a customer include a floating $
 */
import java.util.*;

public class bankrecord {

	private static LinkedList<Customer> list = new LinkedList();
	private static int select = 0;
	/**
	 * This is the main method or the main program for the assignment. Calls
	 * displayMenu to start record.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("A Program for a Bank:");
		displayMenu();
	}

	/**
	 * This method displays the menu and waits for user input (1-9). Each
	 * command has a different method in the switch statement.
	 */
	public static void displayMenu() {
		Scanner input = new Scanner(System.in);
		int command;
		System.out.println();
		System.out.println("	1. Show all records");
		System.out.println("	2. Delete a selected record");
		System.out.println("	3. Change the first name of a selcted record");
		System.out.println("	4. Change the last name of a selected record");
		System.out.println("	5. Add a new record");
		System.out.println("	6. Change the phone number of a selected record");
		System.out.println("	7. Withdraw an amount requested by the record");
		System.out.println("	8. Add a deposit for a selected record");
		System.out.println("	9. Quit");
		System.out.println("Enter a command from the list above (9 to quit):");
		command = input.nextInt();
		switch (command) {
		case 1:
			showRecords();
			break;
		case 2:
			delete();
			break;
		case 3:
			changeFname();
			break;
		case 4:
			changeLname();
			break;
		case 5:
			addRecord();
			break;
		case 6:
			changePhone();
			break;
		case 7:
			withdraw();
			break;
		case 8:
			deposit();
			break;
		case 9:
			quit();
			break;
		}
	}

	/**
	 * This method terminates the program.
	 */
	public static void quit() {
		System.exit(0);
	}

	/**
	 * This method adds a new customer to the LinkedList by prompting user for
	 * first name, last name, phone number, and balance. First name, last name,
	 * and phone number must not have spaces. Balance must have floating $. It
	 * also assumes that no customer has the same first and last name
	 * combination. Recalls displayMenu.
	 */
	public static void addRecord() {
		Scanner input = new Scanner(System.in);
		String x;
		Customer cust = new Customer();
		System.out.println("Enter first name:");
		x = input.next();
		cust.setFname(x);
		System.out.println("Enter last name:");
		x = input.next();
		cust.setLname(x);
		System.out.println("Enter phone number:");
		x = input.next();
		cust.setNumber(x);
		System.out.println("Enter balance:(with $ sign)");
		x = input.next();
		// substring gets rid of the dollar sign and parses it to Double object
		cust.setBal(Double.parseDouble(x.substring(1, x.length())));
		list.add(cust);
		displayMenu();
	}

	/**
	 * This method calls the method to display all records. Then prompts for
	 * user to select a customer, 0 if a selection is not desired. Then recalls
	 * displayMenu. User input should not be < 0.
	 */
	public static void showRecords() {
		Scanner input = new Scanner(System.in);
		int x;
		printRecords();
		System.out.println("Enter a number to select customer (0 if no selection) :");
		x = input.nextInt();
		select = x;
		displayMenu();
	}

	/**
	 * This method goes through the LinkedList of Customer objects. Each
	 * customer object's first name, last name, phone number, and balance is
	 * printed.
	 */
	public static void printRecords() {
		System.out.println("	First Name           Last Name           Phone Number           Balance");
		System.out.println("	----------           ---------           ------------           -------");
		for (int i = 0; i < list.size(); i++) {

			System.out.println(i + 1 + "	" + list.get(i).getFname() + "                " + list.get(i).getLname()
					+ "           " + list.get(i).getNumber() + "             $" + list.get(i).getBal());
		}

		System.out.println();
	}

	/**
	 * This method asks user for first name and last name and matches it with a
	 * Customer in linked list. If not matched, retry. It then takes user input
	 * deposit with leading $ sign and adds it to that customers current
	 * balance. Then recalls displayMenu.
	 */
	public static void deposit() {
		Scanner input = new Scanner(System.in);
		String x;
		String name;
		printRecords();
		System.out.println("Enter the First name of the record you want to add a deposit:");
		x = input.next();
		name = x;
		System.out.println("Now enter the last name:");
		x = input.next();
		name += " " + x;
		for (int i = 0; i < list.size(); i++) {
			// substring from beginning of name to space, representing first name
			if (list.get(i).getFname().equals(name.substring(0, name.indexOf(" ")))) {
				// substring form space to end of name, representing last name
				if (list.get(i).getLname().equals(name.substring(name.indexOf(" ") + 1, name.length()))) {
					System.out.println("The record is: " + name + " who currently has $" + list.get(i).getBal());
					System.out.println("Enter deposit amount:(with $ sign)");
					x = input.next();
					// add user input minus the dollar sign to customer's
					// current balance
					list.get(i).setBal(list.get(i).getBal() + Double.parseDouble(x.substring(1, x.length())));
					System.out.println("The record now has $" + list.get(i).getBal());
					break;

				} else if (i == list.size() - 1){
					System.out.println("Customer not found.\n");
					deposit();
				}

			} else if (i == list.size() - 1){
				System.out.println("Customer not found.\n");
				deposit();
			}
		}
		displayMenu();

	}

	/**
	 * This method prompts for user input first and last name and matches to one
	 * in LinkedList. If not matched, retry. Then sets that customer's last name
	 * to the user input. (no spaces for last name). Recalls menu.
	 */
	public static void changeLname() {
		Scanner input = new Scanner(System.in);
		String x;
		String name;
		printRecords();
		System.out.println("Enter the First name of the record you want to change the last name of:");
		x = input.next();
		name = x;
		System.out.println("Enter the Last name of the record you want to change the last name of");
		x = input.next();
		name += " " + x;
		for (int i = 0; i < list.size(); i++) {
			// substring from beginning of name to space, representing first name
			if (list.get(i).getFname().equals(name.substring(0, name.indexOf(" ")))) {
				// substring form space to end of name, representing last name
				if (list.get(i).getLname().equals(name.substring(name.indexOf(" ") + 1, name.length()))) {
					System.out.println("Now enter the new last name:");
					x = input.next();
					list.get(i).setLname(x);
					break;

				} else if (i == list.size() - 1){
					System.out.println("Customer not found.\n");
					changeLname();
				}

			} else if (i == list.size() - 1){
				System.out.println("Customer not found.\n");
				changeLname();
			}
		}

		displayMenu();
	}

	/**
	 * This method prompts user input for first and last name of customer and
	 * matches that to a customer in LinkedList. If not matched, retries. Sets
	 * the first name of that customer to user input(no spaces for first name).
	 * Recalls menu.
	 */
	public static void changeFname() {
		Scanner input = new Scanner(System.in);
		String x;
		String name;
		printRecords();
		System.out.println("Enter the First name of the record you want to change the first name of:");
		x = input.next();
		name = x;
		System.out.println("Enter the Last name of the record you want to change the first name of");
		x = input.next();
		name += " " + x;
		for (int i = 0; i < list.size(); i++) {
			// substring from beginning of name to space, representing first name
			if (list.get(i).getFname().equals(name.substring(0, name.indexOf(" ")))) {
				// substring form space to end of name, representing last name
				if (list.get(i).getLname().equals(name.substring(name.indexOf(" ") + 1, name.length()))) {
					System.out.println("Now enter the new first name:");
					x = input.next();
					list.get(i).setFname(x);
					break;

				} else if (i == list.size() - 1){
					System.out.println("Customer not found.\n");
					changeFname();
				}

			} else if (i == list.size() - 1){
				System.out.println("Customer not found.\n");
				changeFname();
			}
		}

		displayMenu();
	}

	/**
	 * This methods prompts user for first name and last name of customer and
	 * matches that to one in LinkedList. If not matched, retries. Sets phone
	 * number of that customer to user input(no spaces for phone number).
	 * Recalls menu.
	 */
	public static void changePhone() {
		Scanner input = new Scanner(System.in);
		String x;
		String name;
		printRecords();
		System.out.println("Enter the First name of the record you want to change the phone number name of:");
		x = input.next();
		name = x;
		System.out.println("Enter the Last name of the record you want to change the phone number name of");
		x = input.next();
		name += " " + x;
		for (int i = 0; i < list.size(); i++) {
			// substring from beginning of name to space, representing first name
			if (list.get(i).getFname().equals(name.substring(0, name.indexOf(" ")))) {
				// substring form space to end of name, representing last name
				if (list.get(i).getLname().equals(name.substring(name.indexOf(" ") + 1, name.length()))) {
					System.out.println("Now enter the new phone number:");
					x = input.next();
					list.get(i).setNumber(x);
					break;

				} else if (i == list.size() - 1){
					System.out.println("Customer not found.\n");
					changePhone();
				}

			} else if (i == list.size() - 1){
				System.out.println("Customer not found.\n");
				changePhone();
			}
		}

		displayMenu();
	}

	/**
	 * This method prompts user input for first and last name and matches
	 * customer in LinkedList. If not matched, retries. Subtracts user input
	 * (floating $ sign) from current balance. Cannot be more than current
	 * balance. Recalls displayMenu.
	 */
	public static void withdraw() {
		Scanner input = new Scanner(System.in);
		String x;
		String name;
		printRecords();
		System.out.println("Enter the First name of the record you want to withdraw from:");
		x = input.next();
		name = x;
		System.out.println("Now enter the last name:");
		x = input.next();
		name += " " + x;
		for (int i = 0; i < list.size(); i++) {
			// substring from beginning of name to space, representing first name
			if (list.get(i).getFname().equals(name.substring(0, name.indexOf(" ")))) {
				// substring form space to end of name, representing last name
				if (list.get(i).getLname().equals(name.substring(name.indexOf(" ") + 1, name.length()))) {
					System.out.println("The record is: " + name + " who currently has $" + list.get(i).getBal());
					System.out.println("Enter withdraw amount:(with $ sign)");
					x = input.next();
					// subtract user input converted to Double disregarding
					// leading $ from customer's current balance
					list.get(i).setBal(list.get(i).getBal() - Double.parseDouble(x.substring(1, x.length())));
					System.out.println("The record now has $" + list.get(i).getBal());
					break;

				} else if (i == list.size() - 1){
					System.out.println("Customer not found.\n");
					withdraw();
				}

			} else if (i == list.size() - 1){
				System.out.println("Customer not found.\n");
				withdraw();
			}
		}

		displayMenu();

	}

	/**
	 * This method will delete the index of select - 1 from the LinkedList. If
	 * select = 0, nothing is removed. Resets select back to 0.
	 */
	public static void delete() {
		if (select == 0) {
			System.out.println("No record selected");
		} else {
			// select - 1 because index of list starts at 0
			list.remove(select - 1);
		}
		select = 0;
		displayMenu();
	}

}