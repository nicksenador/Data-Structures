/**
 *@author Nicholas Senador
 *
 *PURPOSE
 *The purpose of this class to to be able to create Customer objects. Customer objects hold the values
 *of first name, last name, phone number, and balance.
 *
 *SOLUTION
 *I need a default construction to initialize a customer object. From there, I need setters to set
 *all of the values in customer class. I also need getters for all of the data structures in customer class.
 *All of the methods need to be public because I need access to them outside of the class.
 *
 *DATA STRUCTURES
 *All private data structures because I don't want access to them outside of the class
 *Strings for first name, last name, and phone number
 *Double for balance (never < 0)
 *
 *HOW TO USE
 *first create a new Customer object with Customer()
 *use the getters and setters to get or set values for the calling customer with custName.methodName(paramaters)
 */
public class Customer {
	
	private String fname;          //no spaces
	private String lname;          //no spaces
	private String number;         //no spaces
	private double bal;            //cannot be < 0

	/**
	 * This method is the default constructor of the Customer class.
	 * It sets the first name to John, the last name to Doe, number to 999-999-9999, and balance to 0.
	 */
	public Customer() {
		fname = "John";
		lname = "Doe";
		number = "999-999-9999";
		bal = 0;
	}

	/**
	 * This method set the first name for a customer object.
	 * 
	 * @param x - String with no spaces for first name
	 */
	public void setFname(String x) {
		this.fname = x;
	}

	/**
	 * This method sets the last name for a customer object.
	 * 
	 * @param x - String with no spaces for last name
	 */
	public void setLname(String x) {
		this.lname = x;
	}

	/**
	 * This method sets the phone number for a customer object.
	 * 
	 * @param x -  String with no spaces in the format of xxx-xxx-xxxx
	 */
	public void setNumber(String x) {
		this.number = x;
	}

	/**
	 * This method sets the balance for a customer object.
	 * 
	 * @param x - Double that is never < 0
	 */
	public void setBal(double x) {
		this.bal = x;
	}

	/**
	 * This method returns the first name of a customer object.
	 * 
	 * @return - returns String fname(first name) of this customer
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * This method returns the last name of a customer object.
	 * 
	 * @return -  return String lname(last name) of this customer.
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * This method returns the phone number of a customer object
	 * 
	 * @return - return String number(phone number) of this customer.
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * This method returns the current balance of a customer object.
	 * 
	 * @return - return Double bal(balance) of this customer. bal is always > 0.
	 */
	public Double getBal() {
		return bal;
	}
}
