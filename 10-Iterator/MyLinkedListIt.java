// Leslie Bresnahan & Peter Duchovni

public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    public LLIterator<E> iterator() {
	return new LLIterator(head);
    }

    public LinkedList() {
	head = new Node();
	tail = head;
    }

    public void add( E d ) {
	tail.setNext( new Node<E>(d) );
	tail = tail.getNext();
    }


    public static void index_error(String s) {
	System.err.println("Index Error for " + s);
    }

    public void add( int i, E s ) {
	Node<E> graft = new Node<E>(s);
	Node<E> onto = head;
	int j = 0;
	while ( j < i ) {
	    if ( onto == null ) {
		index_error("add: " + i + ">= length " + this.size());
		return;
	    }
	    onto = onto.getNext();
	    ++j;
	}
	graft.setNext(onto.getNext());
	onto.setNext(graft);
	if (tail.getNext() != null) {
	    tail = tail.getNext();
	}
    }

    public E get ( int i ) {
	Node<E> n = head.getNext();
	int j = 0;
	while ( j < i ) {
	    if ( n == null ) {
		throw new IndexOutOfBoundsException("get: " + i + ">= length" + this.size());
	    }
	    n = n.getNext();
	    ++j;
	}
	return n.getData();
    }

    public E set( int i, E s ) {
	Node<E> graft = new Node<E>(s);
	Node<E> onto = head;
	int j = 0;
	while ( j < i ) {
	    if ( onto == null ) {
		throw new IndexOutOfBoundsException("set: " + i + ">= length" + this.size());
	    }
	    onto = onto.getNext();
	    ++j;
	}
	E ret = onto.getNext().getData();
	graft.setNext(onto.getNext().getNext());
	onto.setNext(graft);
	return ret;
    }

    public E remove(int i) {
	Node<E> n = head;
	int j = 0;
	while ( j < i ) {
	    if ( n == null ) {
		throw new IndexOutOfBoundsException("remove: " + i + ">= length" + this.size());
	    }
	    n = n.getNext();
	    ++j;
	}
	if (n.getNext() == tail) {
	    tail = n;
	}
	else if (n.getNext() == null) {
	    return null;
	}
	E ret = n.getNext().getData();
	n.setNext(n.getNext().getNext());
	return ret;
    }

    public int find(E s) {
	int i;
	Node<E> n = head.getNext();
	for (i = 0; n != null; ++i) {
	    if (n.getData().equals(s)) {
		return i;
	    }
	    n = n.getNext();
	}
	return -1;
    }

    public int size() {
	int i;
	Node n = head.getNext();
	for (i = 0; n != null; ++i) {
	    n = n.getNext();
	}
	return i;
    }

    public String toString() {
	String s = "";
	Node n = head.getNext();
	do  { 
	    s += "" + n + " -> ";
	} while ( (n = n.getNext()) != null );
	s += "\n";
	return s;
    }
}