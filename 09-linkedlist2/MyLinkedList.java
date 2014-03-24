public class MyLinkedList {

    private Node head;

    public MyLinkedList() {
	head = new Node("dummy");
    }

    public void add(String d) {
	Node tmp = new Node( d );	
	tmp.setNext( head.getNext() );
	head.setNext(tmp);
    }

    public String toString() {
	String s = "";
	Node temp = head.getNext();
	while (temp != null) {
	    s +=  temp + ", ";
	    temp = temp.getNext();	
	}
	return s;
    }

    public void add(int i, String s) {

	Node temp = head.getNext();
	Node follow  = head;

	for (int n = 0; n <= i; n++) {
	    if (n == i) {
		Node newN = new Node(s);
		newN.setNext( temp );
		follow.setNext( newN );
	    }
	    follow = follow.getNext();
	    temp = temp.getNext();
	}
    }

    public String get( int i ) {
	Node temp = head.getNext();

	for (int n = 0; n <= i; n++ ) {
	    if (n == i) {
		return temp.getData();
	    }
	    temp = temp.getNext();
	}
	return "Invalid input";
    }


    public String set( int i, String s ) {

	String retStr = "";
	Node temp = head.getNext();

	for (int n = 0; n <= i; n++) {
	    if ( n == i ) {
		retStr= temp.getData();
		temp.setData( s );
	    }
	    temp = temp.getNext();
	}
	return retStr;
    }


    public String remove( int i ) {

	String retStr = "";
	Node temp = head.getNext();
	Node follow = head;
	for (int n = 0; n <= i; n++) {
	    if ( n == i ) {
		retStr = temp.getData();
		follow.setNext( temp.getNext() );
	    }
	    follow = follow.getNext();
	    temp = temp.getNext();

	}
	return retStr;
    }

    public int find( String s ) {
	int spot = -1;
	Node temp = head.getNext();
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
	Node temp = head.getNext();
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
