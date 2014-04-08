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
	    String line = getString("Enter your desired calculation in postfix notation (or enter clear):");
	    calculate( line );
	    System.out.println( stack );
	}
    }

    public void calculate( String s ) {
	
	if (s.equals("clear")) {
	    stack = new MyStack();
	    return;
	}

	String c;
	while ( s.length() > 0 ) {
	    c = s.substring(0,1);
	    if (isInt( c )) {
		stack.push( c );
	    }
	    else {
		String num1 = stack.pop();
		String num2 = stack.pop();

		if (c.equals("+")) {
		    stack.push( (Integer.parseInt( num1 ) + Integer.parseInt( num2 )) + "" );
		}
		else if (c.equals("-")) {
		    stack.push( (Integer.parseInt( num1 ) - Integer.parseInt( num2 )) + "" );
		}
		else if (c.equals("*")) {
		    stack.push( (Integer.parseInt( num1 ) * Integer.parseInt( num2 )) + "" );
		}
		else if (c.equals("/")) {
		    stack.push( (Integer.parseInt( num1 ) / Integer.parseInt( num2 )) + "" );
		}
	    }
	    s = s.substring(1);

	}
    }

    public boolean isInt( String s ) {
	try {
	    Integer.parseInt( s );
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
	    System.out.println( x );
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
	