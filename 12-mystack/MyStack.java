public class MyStack {

    private int top;
    private String[] data;

    public MyStack() {
	data = new String[10];
	top = -1;
    } 

    public void push( String s ) {
	if ( (top + 1) >= data.length ) {
	    grow();
	}
	top++;
	data[top] = s;
	
    }

    public String pop() {
	if (top < 0) {
	    return null;
	}
	String ret = data[top];
	data[top] = null;
	top--;
	return ret;
    }

    public String peek() {
	if (top < 0) {
	    return null;
	}
	return data[top];
    }

    public int size() {
	return top + 1;
    }

    public boolean isEmpty() {
	return top < 0;
    }

    public void grow() {
	String[] arr = new String[ data.length * 2 ];

	for (int i = 0; i < data.length; i++) {
	    arr[i] = data[i];
	}
	data = arr;
    }

	
    public String toString() {
	String retString = "";

        if (top < 0) {
	    return "";
	}

	int num = 0;
	String temp = data[num];

        while (temp != null) {
	    retString += temp + ", ";
	   
	    num++;
	    if ( num >= data.length ) 
		break;
	    temp = data[num];  
	}

	return retString;
    }


    public static void main( String[] args ) {

	MyStack stack = new MyStack();

	stack.push("cat");
	stack.push("dog");
	stack.push("monkey");
	stack.push("gorilla");
	stack.push("cow");

	System.out.println( stack );
	System.out.println( stack.peek() );
	System.out.println( stack );
	System.out.println( stack.pop() );
	System.out.println( stack );

	stack.push("cat");
	stack.push("dog");
	stack.push("monkey");
	stack.push("gorilla");
	stack.push("cow");
	stack.push("cat");
	stack.push("dog");
	stack.push("monkey");
	stack.push("gorilla");
	stack.push("cow");

	System.out.println( stack );
    }
}

	

       

	