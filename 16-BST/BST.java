public class BST {
    private Node root;

    public BST() {
	root = null;
    }
    

    public void insert(Node n) {

	Node pig = root;
	Node temp = root;


	while ( temp != null ) {
	    pig = temp;

	    if (n.getData() > temp.getData()) {
		temp = temp.getRight();
	    }
	    else {
		temp = temp.getLeft();
	    }
	}
	pig.setNext(n);
    }

    public Node search(int d){
	Node temp = root;

	while (temp != null) {
	    if (temp.getData() == d )
		return temp;

	    if (d > temp.getData()) {
		temp = temp.getRight();
	    }
	    else {
		temp = temp.getLeft();
	    }
	}

	return null;
    }

    public Node search2(Node c, int x) {

	if (c == null)
	    return null;

	if (c.getData() == x)
	    return c;


	if ( d > c.getData() ) {
	    return search2( c.getRight(), x);
	}
	else {
	    return search2( c.getLeft(), x);
	}
    }
}