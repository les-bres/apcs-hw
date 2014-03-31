// Leslie Bresnahan & Norman Li

public class CircularList<E>
{
    private class Node<E>
    {
        E data;
        Node<E> next, prev;
        
        public Node(E d)
        {
            data = d;
            next = this;
            prev = this;
        }
        
        public String toString() { return "" + data; }
        
        public void setData(E d) { data = d; }
        public E getData() { return data; }
        
        public void setNext(Node<E> n) { next = n; }
        public Node<E> getNext() { return next; }
        
        public void setPrev(Node<E> p) { prev = p; }
        public Node<E> getPrev() { return prev; }
    }
    
    private Node<E> current, head, tail;
    
    public void insert(E d)
    {
        Node<E> n = new Node<E>(d);
        
        if (current == null)
        {
            current = n;
            head = n;
            tail = n;
        }
        else
        {
            if (current == head)
                head = n;

            n.next = current;
            current.prev.next = n;
            n.prev = current.prev;
            
            current.prev = n;
            current = n;
        }
    }
    
    public E getCurrent() { return current.getData(); }
    
    public void forward()
    {
        if ( current.getNext() != null )
            current = current.getNext();
    }
    
    public void back()
    {
        if ( current.getPrev() != null )
            current = current.getPrev();
    }
    
    public String toString()
    {
        if ( current == null )
            return "";
        
        Node<E> temp = head;
        String s = new String("");
        
        while ( temp != tail )
        {
            s += ( temp.getData() + " " );
            temp = temp.getNext();
        }
        
        s += ( tail.getData() );
        
        return s;
    }
    
    public static void main( String[] arg )
    {
        CircularList<String> L = new CircularList<String>();
        System.out.println(L);
        L.insert("hello");
        System.out.println(L);
        L.insert("world");
        System.out.println(L);
        L.insert("three");
        System.out.println(L);
        
        System.out.println( L.getCurrent() );
        L.back();
        System.out.println( L.getCurrent() );
        L.back();
        System.out.println( L.getCurrent() );
        L.back();
        System.out.println( L.getCurrent() );
        L.back();
    }
}