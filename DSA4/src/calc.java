
/**
 * @author Nicholas Senador
 * 
 * Assignment #4
 * 
 * PURPOSE OF THIS PROGRAM
 * The purpose of this program is to create a calculator from user input using the stack data structure. 
 * The calculator will take user input of an infix expression of binary operators(+,-,/,*,%), parenthesis,
 * and non-decimal numbers and convert the expression into a postfix expression using a stack. The program 
 * repeatedly ask the user for a value of x, and evaluate the postfix expression using another stack.
 * 
 * SOLUTION FOR PROGRAM
 * The main method for this program will ask for user input for infix expression and then call the methods 
 * checkExpr(check the expression for errors), convertToPostfix, and calcExpr.
 * 
 * checkExpr(x) - There are many errors to check for in the user's input of an infix expression. Each of
 * 				  these errors will be checked by the following methods. If any of these errors are found,
 * 				  print the error and terminate the program.
 * 		checkDecimal(expr) - Uses String method contains to check for any decimals in expression
		checkFirstAndLast(expr) - Checks first and last characters of expression to check if they are operands
		 						  or '(' for the first or ')' for the last character.
		checkRightParenthBeforeLeft(expr) - Use stack to store left parenthesis, and if a right parenthesis 
											is found and the stack is empty, error.
		checkParenthCount(expr) - If left and right parenthesis count is uneven, no closing parenthesis for
								  and opening parenthesis. The above method covers the vice versa.
		checkOpFollowOp(expr) - For every +,-,/,*, and % in expression, make sure there is not another operator
								following the first operator(ignoring spaces).
		checkOpBetweenParenth(expr) - For every '(', check for operand after(ignoring spaces). And For every
									  ')', make sure operand before(ignoring spaces).
		checkOpBetweenOperands(expr) - Check for operand followed by operand. This covers postfix and prefix 
									   expressions. A number can be multiple digits such as 8798 and a space 
									   indicates another operand or number. Ex: 234 2343 + and +243 2343 are
									   incorrect expressions.
									   
 * convertToPostfix(x) - Converts checked expression to postfix and assigns it back to x.
 * 						 Go through each character in string and use cases for each input. Ignore spaces, push 
 *                       '(' to stack, case ')' output everything until '(' then pop '(', case any operand if
 *                       top of stack is operator check precedence if higher prec push else output top and push
 *                       new operator, case operand(0-9 and x) save to output. After all characters, pop remaining
 *                       contents of stack to output.
 *    
 * calcExpr(x) - Takes converted expression and calculates the value
 * 				 Converts passed string to array using String.split by space. This is because the expression
 * 				 will be in correct format of each operator or operand or parenthesis separated by a space due
 * 				 to the convertToPostfix(x) method. This eliminates dealing with multiple digit numbers(2222).
 * 				 It will go through the array at least once(if no x) or continuously(if x is present) until x == q.
 * 				 Case 'x' or digit : Ask for x value(if necessary) and push onto stack. If x == q, terminate.
 * 	             Case operator : rightOperator = top of stack, leftOperator = next top of stack, perform said
 *                               operator in the form left operator right.
 * 
 * DATA STRUCTURES
 * Scanner to read standard input
 * String for user input expression
 * Stack to check if right parenthesis comes before a left
 * int for counting left and right prenthesis
 * Stack to use when converting from infix to postfix
 * Stack to use when calculating postfix expression
 * Array of type string to use when calculating postfix expression
 * 
 * HOW TO USE
 * Run the program
 * Input an infix expression including multiple digit numbers and x using binary operators, +, -, /, *, and % as 
 * well as parenthesis. There can not be any decimal numbers. There can be as many spaces between tokens as long
 * as the first character and last character are not spaces in the input. Incorrect infix expression will result
 * in an error and not attempt to calculate. If x entered as a variable, enter the desired value for x each time
 * the program asks for it. Enter "q" as the value for x to quit.
 */
import java.util.*;

public class calc {

	/**
	 * This is the main method of the program. It will ask for user input of
	 * infix expression, call method to check the expression, call method to
	 * convert expression, and call method to calculate expression. User input
	 * can have spaces between tokens or not, as long as the first and last
	 * characters are not spaces.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter infix expression:");
		String x = sc.nextLine();
		checkExpr(x);
		x = convertToPostfix(x);
		System.out.println("Converted expression:" + x);
		calcExpr(x);
	}

	/**
	 * This method will take the checked infix expression and convert it into
	 * postfix expression with each token separated by a space.
	 * 
	 * @param a
	 *            - String passed and checked infix expression
	 * @return - String converted postfix expression with spaces between each
	 *         token
	 */
	public static String convertToPostfix(String a) {
		Stack<Character> st = new Stack();
		String output = "";
		for (int i = 0; i < a.length(); i++) {
			switch (a.charAt(i)) {
			case ' ':
				break;
			case '(':
				st.push(a.charAt(i));
				break;
			case ')':
				while (!st.isEmpty() && !st.peek().equals('(')) {
					output += " " + st.pop();
				}
				st.pop();
				break;
			case '*':
			case '/':
			case '%':
			case '+':
			case '-':
				if (!st.isEmpty() && st.peek().equals('*') | st.peek().equals('/') | st.peek().equals('%')
						| st.peek().equals('-') | st.peek().equals('+')) {
					if (checkHighPrec(a.charAt(i), st.peek())) {
						st.push(a.charAt(i));
					} else {
						output += " " + st.pop();
						st.push(a.charAt(i));
					}
				}
				if (st.isEmpty() || st.peek().equals('(')) {
					st.push(a.charAt(i));
				}
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case 'x':
				output += " " + a.charAt(i);
				while (i != a.length() - 1 && Character.isDigit(a.charAt(i + 1))) {
					output += a.charAt(i + 1);
					i++;
				}
				break;
			default:
				System.out.println("Invalid input character '" + a.charAt(i) + "'");
				System.exit(0);
				break;
			}
		}
		while (!st.isEmpty()) {
			output += " " + st.pop();
		}
		return output;
	}

	/**
	 * This method will take two operators(+,-,*,/,or %) and determine if a has
	 * higher precedence than b.
	 * 
	 * @param a
	 *            - Character operator of (+,-,*,/, or %)
	 * @param b
	 *            - Character operator of (+,-,*,/, or %)
	 * @return - True if a has higher precedence, false otherwise.
	 */
	public static Boolean checkHighPrec(char a, char b) {
		int aa, bb;
		switch (a) {
		case '*':
		case '/':
		case '%':
			aa = 1;
			break;
		default:
			aa = 0;
			break;
		}

		switch (b) {
		case '*':
		case '/':
		case '%':
			bb = 1;
			break;
		default:
			bb = 0;
			break;
		}
		return (aa > bb);
	}

	/**
	 * This method will take the converted postfix expression from infix and
	 * calculate the result. If x exists, it will ask the user for the value of
	 * x.
	 * 
	 * @param expr
	 *            - String converted postfix expression from infix from the
	 *            converting method. Tokens all separated by spaces.
	 */
	public static void calcExpr(String expr) {
		Stack<Integer> numStack = new Stack();
		Scanner sc = new Scanner(System.in);
		String input = "q";
		int right;
		int left;
		Integer val = null;
		int result;
		String[] exprInArray = expr.substring(1, expr.length()).split(" ");
		do {
			for (int i = 0; i < exprInArray.length; i++) {
				switch (exprInArray[i]) {
				case "+":
					right = numStack.pop();
					left = numStack.pop();
					numStack.push(left + right);
					break;
				case "-":
					right = numStack.pop();
					left = numStack.pop();
					numStack.push(left - right);
					break;
				case "*":
					right = numStack.pop();
					left = numStack.pop();
					numStack.push(left * right);
					break;
				case "/":
					right = numStack.pop();
					left = numStack.pop();
					numStack.push(left / right);
					break;
				case "%":
					right = numStack.pop();
					left = numStack.pop();
					numStack.push(left % right);
					break;
				case "x":
					if (val == null) {
						System.out.println("Enter value of x:");
						input = sc.next();
						if (input.equals("q")) {
							System.exit(0);
						}
						val = Integer.parseInt(input);
						numStack.push(val);
					} else {
						numStack.push(val);
					}
					break;
				default:
					numStack.push(Integer.parseInt(exprInArray[i]));
				}
			}
			result = numStack.pop();
			val = null;
			System.out.println("Answer to expression: " + result);
			System.out.println();
		} while (!input.equals("q"));
	}

	/**
	 * This method calls all of the necessary possible errors in the user's
	 * input of infix expression
	 * 
	 * @param expr
	 *            - String infix expression where the first and last characters
	 *            are not spaces
	 */
	public static void checkExpr(String expr) {
		checkDecimal(expr);
		checkFirstAndLast(expr);
		checkRightParenthBeforeLeft(expr);
		checkParenthCount(expr);
		checkOpFollowOp(expr);
		checkOpBetweenParenth(expr);
		checkOpBetweenOperands(expr);
	}

	/**
	 * This method checks to see if there are any floating point numbers in the
	 * expression. It will terminate the program if there are.
	 * 
	 * @param expr
	 *            - String infix expression where the first and last characters
	 *            are not spaces.
	 */
	private static void checkDecimal(String expr) {
		if (expr.contains(".")) {
			System.out.println("Error in expression! Cannot accept floating point numbers.");
			System.exit(0);
		}
	}

	/**
	 * This method checks if the first character is a '(' or and operand, and
	 * also checks if the last character is ')' or operand. If not, the program
	 * will terminate.
	 * 
	 * @param expr
	 *            - String infix expression where the first and last characters
	 *            are not spaces.
	 */
	private static void checkFirstAndLast(String expr) {
		if (!(expr.charAt(0) == '(' || Character.isDigit(expr.charAt(0)) || expr.charAt(0) == 'x')) {
			System.out.println("Error in expression! Expression must start with '(' or operand.");
			System.exit(0);
		}
		if (!(expr.charAt(expr.length() - 1) == ')' || Character.isDigit(expr.charAt(expr.length() - 1))
				|| expr.charAt(expr.length() - 1) == 'x')) {
			System.out.println("Error in expression! Expression must end with ')' or operand.");
			System.exit(0);
		}
	}

	/**
	 * This method will check if there is a right parenthesis without a matching
	 * left parenthesis. It will terminate if there is.
	 * 
	 * @param expr
	 *            - String infix expression where the first and last characters
	 *            are not spaces
	 */
	private static void checkRightParenthBeforeLeft(String expr) {
		Stack<Character> st = new Stack();
		for (int i = 0; i < expr.length(); i++) {
			if (expr.charAt(i) == '(') {
				st.push(expr.charAt(i));
			}
			if (expr.charAt(i) == ')') {
				if (st.isEmpty()) {
					System.out.println("Error in expression! No opening parenthesis for closing parenthesis.");
					System.exit(0);
				} else {
					st.pop();
				}
			}
		}
	}

	/**
	 * This method will check if the balance of left and right parenthesis is
	 * off. It will terminate if it is unbalanced.
	 * 
	 * @param expr
	 *            - String infix expression where the first and last characters
	 *            are not space
	 */
	private static void checkParenthCount(String expr) {
		int rightParenth = 0;
		int leftParenth = 0;
		for (int i = 0; i < expr.length(); i++) {
			if (expr.charAt(i) == '(') {
				leftParenth += 1;
			}
			if (expr.charAt(i) == ')') {
				rightParenth += 1;
			}
		}
		if (rightParenth != leftParenth) {
			System.out.println("Error in expression! No matching right parenthesis for left parenthesis.");
			System.exit(0);
		}
	}

	/**
	 * This method will check if there is an operator followed by another
	 * operator in the user input expression(ignoring spaces). If so, the
	 * program terminates.
	 * 
	 * @param expr
	 *            - String infix expression where the first and last characters
	 *            are not space
	 */
	private static void checkOpFollowOp(String expr) {
		for (int i = 0; i < expr.length(); i++) {
			if (expr.charAt(i) == '+' || expr.charAt(i) == '-' || expr.charAt(i) == '*' || expr.charAt(i) == '/'
					|| expr.charAt(i) == '%') {
				while (expr.charAt(i + 1) == ' ') {
					i++;
				}
				if (expr.charAt(i + 1) == '+' || expr.charAt(i + 1) == '-' || expr.charAt(i + 1) == '*'
						|| expr.charAt(i + 1) == '/' || expr.charAt(i + 1) == '%') {
					System.out.println("Error in expression! Cannot have operator followed by operator.");
					System.exit(0);
				}
			}
		}
	}

	/**
	 * This method will check if there is an operand after '(' and if there is
	 * an operand before ')'. If not, the program terminates.
	 * 
	 * @param expr
	 *            - String infix expression where the first and last characters
	 *            are not space
	 */
	private static void checkOpBetweenParenth(String expr) {
		for (int i = 0; i < expr.length(); i++) {
			if (expr.charAt(i) == '(') {
				while (expr.charAt(i + 1) == ' ') {
					i++;
				}
				if (expr.charAt(i + 1) == '+' || expr.charAt(i + 1) == '-' || expr.charAt(i + 1) == '*'
						|| expr.charAt(i + 1) == '/' || expr.charAt(i + 1) == '%') {
					System.out.println("Error in expression! No operand between opening parenthesis and operator.");
					System.exit(0);
				}
			}
			if (expr.charAt(i) == '+' || expr.charAt(i) == '-' || expr.charAt(i) == '*' || expr.charAt(i) == '/'
					|| expr.charAt(i) == '%') {
				while (expr.charAt(i + 1) == ' ') {
					i++;
				}
				if (expr.charAt(i + 1) == ')') {
					System.out.println("Error in expression! No operand between operator and closing parenthesis.");
					System.exit(0);
				}
			}
		}
	}

	/**
	 * This program will check if there are two operands sequentially with no
	 * operator between. This will cover if user inputs a postfix expression or
	 * prefix expression. If so, terminate the program.
	 * 
	 * @param expr
	 *            - String infix expression where the first and last characters
	 *            are not space
	 */
	private static void checkOpBetweenOperands(String expr) {
		for (int i = 0; i < expr.length(); i++) {
			if (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == 'x') {
				while (i != expr.length() - 1 && Character.isDigit(expr.charAt(i + 1))) {
					i++;
				}
				while (i != expr.length() - 1 && expr.charAt(i + 1) == ' ') {
					i++;
				}
				if (i == expr.length() - 1) {
					return;
				}
				if (Character.isDigit(expr.charAt(i + 1)) || expr.charAt(i + 1) == 'x') {
					System.out.println("Error in expression! No operator between operands.");
					System.exit(0);
				}
			}
		}
	}

}
