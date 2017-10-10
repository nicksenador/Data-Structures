/*Nicholas Senador ---- Documentation Below

1. PURPOSE: The purpose of this program is to first ask the user for a directory to a file. For example,
the file inside this project I use to test is test.txt, when the program prompts me for a
directory to a file, I type "test.txt". The program will then read the input file and display
on screen as well as in an output file, "output.txt", the amount of words, lines, alphanumeric
characters, sentences, vowels, and puncuations that are in the file. If the file given by the user is empty, 
the program will print to the screen and "output.txt" that the file is empty, and the program will be terminated.

2.SOLUTION: For this program I will divide the counts of each word, lines, alphanumeric characters, sentences,
vowels, and punctuations into separate problems. These separate problems each have their own methods. But first I need to 
create a scanner object to read what the user inputs as a file. Next, I will take the user input and make a file object 
out of it and use that with another scanner to be able to open and read the file. The next step is to check whether or not the
file is empty or not, if so, it needs to print to screen and "output.txt" that the file is empty and then terminate 
the program. Otherwise, I will use a while loop to check if the file has a next line and then open each line and call 
the methods to get the solutions to the counts I need. I should call these methods for each line and pass the line as a string and return and add the total
to each count.
	Word count: 	I will divide the string passed to this method with the String.split method with the parameter as space. The size
	of the array that the String.split method returns will be the amount of words. One thing I need to take into account is 
	words with more than one space. To solve this problem, I should make a for loop going through the array, and if a string in
	the array is null, subtract one from the word count. This is repeated for every line in the file and added to the total count.
	Line count:	 I do not need a method for this problem. I can just add one to the line count every time the while loop happens because 
	the while loop is while (file.hasNextLine), and if this is true, it'll add one to the line count.
	Alphanumeric character count: 	The alphanumeric characters are a-z and 0-9. The line passed through this method will go through a for loop.
	The for loop will check each character and use the Character.isLetter or Character.isDigit methods from the Character class on each character. 
	If either of these cases are true, the count will add one and return the value for each line.
	Sentence count: 	To signify a sentence end, there can be a period(.), exclamation point(!), or a question mark(?). I also need to make
	sure that there is a word before each of those sentence endings to make sure it is a sentence and take care of sentences that end
	with multiple sentence enders like .. or ?! or !! or just sentence enders by themselves. I will use String.split again to separate the string into segments seperated 
	by spaces. If a word has a period, exclamation point, or question mark at the end, the count goes up and the value is returned 
	after the whole line is done. Note: this assumes the grammar in the file correct and if there is a sentence ender, it is truly a sentence.
	Vowel count: 	The vowels are a, e, i, o, and u. I need to take the string passed to this method and convert it to all lower case. Then a for loop will go through
	each character in the string and an if statement will ask if the character is an a, e, i, o, or u. If any of these cases are true, the count will go up. The 
	value is returned after the string is finished.
	Punctuation count: 	The punctuations are comma(,), period(.), question mark(?), exclamation point(!), quotation mark("), parentheses(()), colon(:), and semicolon(;).
	A for loop will go through each character in the string and if the character is any of these punctuations, the count will go up. The total is returned at the end.
Finally after we have collected all of our data, we need a printwriter to create the file output.txt and print all of these answers to the file as well as on screen.
	
3. DATA STRUCTURES: Scanner for reading input from user
					Scanner for reading input file that user specified
					integers for all of the counts - this is the main data we want for the answer
					String for each line in the file
					arrays for String.split method						
					PrintWriter for output.txt
						
4. HOW TO USE: Run the program. When it prompts you for a directory to a file, enter a directory to the file you want the program to count. For example, test.txt
already exists in my java project on my computer, I type in "test.txt". Press enter. The program will run and print the number of words, lines, alphanumeric characters,
sentences, vowels, and punctuations. You can also see the same text that is on screen in "output.txt" this program creates in the project.

5. CLASSES: The only class I need for this project is the main class. All of the answers are completed through methods and are explained in "SOLUTION."
*/

import java.io.*;
import java.util.*;

public class wordcount {
	
	public static void main(String args[]) {
		Scanner str = new Scanner(System.in);
		Scanner filein = null;
		int words = 0, lines = 0, alphchars = 0, sents = 0, vows = 0, puncs = 0;         //These are all of the values we are trying to find.
		
		System.out.println("Enter a directory to a file");
		String file = str.next();                  								//this portion gets the input from the user and makes it a file
		str.close();
		File infile = new File(file);
		
		try {
			filein = new Scanner(infile);                                 //This try block opens the file
			String s;                       //Initializing s for filein.nextLine()
			if (!filein.hasNextLine()) {                          //If the file doesn't have any lines, calls the end method with string x
				String x = ("the input file is empty.");
				end(x);
			} else {                                          //Otherwise, the while loop will go through each line of the file and read each line and call all of the methods
				while (filein.hasNextLine()){
					s = filein.nextLine();
					words+=countwords(s);             // += because each value will update after each line until the end
					lines++;                                   //adds line count, needs no method
					alphchars+=alphcharscount(s);
					sents+=sentscount(s);
					vows+=vowscount(s);
					puncs+=puncscount(s);
				}
				PrintWriter output = null;                                  //initialize PrintWriter
				try {
					output = new PrintWriter(new FileWriter("output.txt"));       //try block to start writing to output.txt
					output.println("The amount of words is: " + words);               //Prints the answer to the screen and output.txt
					System.out.println("The amount of words is: " + words);
					output.println("The amount of lines is: " + lines);
					System.out.println("The amount of lines is: " + lines);
					output.println("The amount of alphanumeric characters is: " + alphchars);
					System.out.println("The amount of alphanumeric characters is: " + alphchars);
					output.println("The amount of sentences is: " + sents);
					System.out.println("The amount of sentences is: " + sents);
					output.println("The amount of vowels is: " + vows);
					System.out.println("The amount of vowels is: " + vows);
					output.println("The amount of punctuations is: " + puncs);
					System.out.println("The amount of punctuations is: " + puncs);
					
					output.close();                                               //close output.txt
					
				} catch(IOException e) {                                       //catch block and error message for output.txt
					System.out.println("error writing to file");                   
				}
			}
			
			filein.close();                                                     //input file close
			 
		} catch (FileNotFoundException e) {                                    //catch block and error message for input file
			System.out.println("Error reading file");
		}
		
	}

	public static int countwords(String s){                       //this method is used to count the words in each line. This method also assumes the user spelled words correctly.
		String wordarray[] = s.split(" ");                   //splits the string into an array each divided by where spaces were
		int count = 0;
		for (int i = 0; i < wordarray.length; i++) {
			count++;
			if (wordarray[i].equals("")) {                          //the case where the original string had two spaces and String.split created a null entry
				count--;                                              //subtract that case
			}
			
		}
		return count;
	}
	
	public static int alphcharscount(String s) {                           //alphanumeric character counting method
		int count = 0;
		for (int i = 0; i < s.length(); i ++) {
			if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {               //goes through each character and uses the Character.isLetter and Character.isDigit
				count++;                                                                           //methods to check if the character is a letter or number, if either, add one to count.
			}
		}
		return count;
	}
	
	public static int sentscount(String s) {                                           //sentence counting method
		int count = 0;                                                  //This method assumes sentences are gramatically correct in the file.
		String wordarray[] = s.split(" ");                                         //splitting the sentence into an array that was divided by the spaces
		for (int i = 0; i < wordarray.length; i++) {
			if (wordarray[i].endsWith(".") || wordarray[i].endsWith("?") || wordarray[i].endsWith("!")) {   //if any of the words in the array has a sentence ender, add one to count
				count++;
			}
		}
		return count;
		
	}
	
	public static int vowscount(String s) {                                //vowel counting method
		int count = 0;
		s = s.toLowerCase();                                          //converts the string into lower case so this method works with capital vowels as well
		for (int i = 0; i < s.length(); i ++) {                         //for every character in the string, if a,e,i,o, or u, add one to count
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
				count++;
			}
		}
		return count;
	}
	
	public static int puncscount(String s) {                                 //punctuation counting method
		int count = 0;
		for (int i = 0; i < s.length(); i ++) {                     //for each character in the string, if it is . , ? ! " ( ) : or ; then add one to count
			if (s.charAt(i) == '.' || s.charAt(i) == ',' || s.charAt(i) == '?' || s.charAt(i) == '!' || s.charAt(i) == '"' || s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == ':' || s.charAt(i) == ';') {
				count++;
			}
		}
		return count;
	}
	
	public static void end(String x) {                          //end method called when the file does not have next line from beginning
		System.out.println(x);                                    //x string was "the file is empty"
		PrintWriter output = null;                                //prints x and uses PrintWriter to write to output.txt string x as well
		try {
			output = new PrintWriter(new FileWriter("output.txt"));
			output.println(x);
			
			output.close();
			
		} catch (IOException e) {                                        //catch block and error statement for PrintWriter
			System.out.println("error writing to file");
		}
		System.exit(0);                                            //Program Terminate: after we print to screen and output.txt that the file is empty, this terminates the program
	}
}
