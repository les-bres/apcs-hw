public class MyLinkedList {

    private Node head;

    public MyLinkedList() {
	head = null;
    }

    public void add(String d) {
	Node tmp = new Node( d );	
	tmp.setNext( head );
	head = tmp;
    }

    public String toString() {
	String s = "";
	Node temp = head;
	while (temp != null) {
	    s +=  temp + ", ";
	    temp = temp.getNext();	
	}
	return s;
    }

    public void add(int i, String s) {
	int spot = -1;
	Node temp = head;
	while ( temp != null ) {
	    spot++;
	    if (spot == (i-1)) {
		Node newN = new Node( s );
		newN.setNext( temp.getNext() );
		temp.setNext( newN );
	    }
	    temp = temp.getNext();
	}
    }

    public String get( int i ) {
	int spot = -1;
	Node temp = head;
	while ( temp != null ) {
	    spot++;
	    if ( spot == i ) {
		return temp.getData();
	    }
	    temp = temp.getNext();
	}
	return "invalid input";
    }

    public String set( int i, String s ) {
	int spot = -1;
	String retStr = "";
	Node temp = head;
	while ( temp != null ) {
	    spot++;
	    if ( spot == (i-1) ) {
		retStr = temp.getNext().getData();
		Node newN = new Node( s );
		newN.setNext( temp.getNext().getNext() );
		temp.setNext( newN );
	    }
	    temp = temp.getNext();
	}
	return retStr;
    }

    public String remove( int i ) {
	int spot = -1;
	String retStr = "";
	Node temp = head;
	while ( temp != null ) {
	    spot++;
	    if ( spot == (i-1) ) {
		retStr = temp.getNext().getData();
		temp.setNext( temp.getNext().getNext() );
	    }
	    temp = temp.getNext();
	}
	return retStr;
    }

    public int find( String s ) {
	int spot = -1;
	Node temp = head;
	while ( temp != null ) {
	    spot++;
	    if ( temp.getData().equals( s ) ) {
		return spot;
	    }
	    temp = temp.getNext();
	}
	return -1;
    }
    
    public int length() {
	int retInt = 0;
	Node temp = head;
	while (temp != null) {
	    retInt++;
	    temp = temp.getNext();
	}
	return retInt;
    }


    public static void main( String[] args ) {
	MyLinkedList l =  new MyLinkedList();
	l.add("cat" );
	l.add("dog");
	l.add("monkey");
	l.add("gorilla");
	System.out.println( l );

	l.add(2, "cow");
	System.out.println ( l );
	System.out.println(l.get( 2 ));
	
	l.set(2, "sheep");
	System.out.println( l );

	l.remove(2);
	System.out.println( l );

	System.out.println( l.find( "cat" ) );
	System.out.println( l.length() );

    }
}
