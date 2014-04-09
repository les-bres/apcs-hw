import cs1.Keyboard;
import java.util.*;
import java.io.*;


public class Postfix {

    private MyStack stack;

    public Postfix() {
	stack = new MyStack();
    }

    public void use() {
	while (true) {
	    String line = getString("Enter your a number or operation (or enter clear): ");
	    calculate( line );
	    System.out.println( stack );
	}
    }

    public void calculate( String s ) {
	
	if (s.equals("clear")) {
	    stack = new MyStack();
	    return;
	}
	
	if (isDoub( s )) {
	    stack.push( Double.parseDouble(s) + "" );
	}
	else {
	    
	    if (stack.size() < 2) {
		System.out.println("You need to enter numbers first") ;
		return;
	    }
	    
	    Double num1 = Double.parseDouble(stack.pop());
	    Double num2 = Double.parseDouble(stack.pop());

	    if (s.equals("+")) {
		stack.push( num1 + num2 + "");
	    }
	    else if (s.equals("-")) {
		stack.push( num1 - num2 + "");
	    }
	    else if (s.equals("*")) {
		stack.push( num1 * num2 + "" );
	    }
	    else if (s.equals("/")) {
		stack.push( num1 / num2 + "" );
	    }
	}
    }

    public boolean isDoub( String s ) {
	try {
	    Double.parseDouble( s );
	}
	catch (NumberFormatException e ) {
	    return false;
	}
	return true;
    }
	     


    public String getString( String x ) {
	boolean getString = true;
	String inString = "0";
	while (getString) {
	    System.out.print( x );
	    try {
		inString = Keyboard.readString();
		getString = false;
	    }
	    catch (InputMismatchException e){
		System.out.println("Oops, invalid input, try again.");
	    }
	}
	return inString;
    }

    public static void main (String[] args) {
	Postfix calc = new Postfix();
	calc.use();
    }
}
