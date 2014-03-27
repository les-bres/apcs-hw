import java.io.*;
import java.util.*;

public class LLIterator<E> implements Iterator<E> {
    private Node<E> current;

    public LLIterator(Node<E> head) {
	current = head;
    }

    public boolean hasNext() {
	return (current.getNext() != null);
    }
    public E next() {
	if (hasNext()) {
	    current = current.getNext();
	    return current.getData();
	}
	return null;
    }
    public void remove() {
	return;
    }
}