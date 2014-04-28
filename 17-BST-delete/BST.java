public class BST {
    private Node dummy, root;

    public BST() {
	dummy = new Node( -1 );
	root = null;
    }
    

    public void insert(Node n) {

	Node pig = dummy;
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
	
	if (n.getData() < pig.getData()) {
	    pig.setLeft( n );
	}
	else {
	    pig.setRight( n );
	}

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


	if ( x > c.getData() ) {
	    return search2( c.getRight(), x);
	}
	else {
	    return search2( c.getLeft(), x);
	}
    }


    public Node searchParent( int x ) {
	Node temp = root;
	Node parent = dummy;

	while ( temp != null && temp.getData() != x) {
	    parent = temp;

	    if (x > temp.getData()) {
		temp = temp.getRight();
	    }
	    else {
		temp = temp.getLeft();
	    }
	}

	return parent;
    }

    public Node largest( Node c ) {
	Node temp = c;
	Node parent = c;

	while (temp != null) {
	    parent = temp;
	    temp = temp.getRight();
	}

	return parent;
    }

    public void delete(int x) {
	Node parent = searchParent(x);
	Node cur = null;
	boolean isLeft = false;

	if (parent.getData() < x) {
	    cur = parent.getRight();
	}
	else {
	    cur = parent.getLeft();
	    isLeft = true;
	}
	
       
	if (cur == null) {
	    return ;
	}

	
	Node left, right;
	left = cur.getLeft();
	right = cur.getRight();

	// Cases A & B

	if ( left == null || right == null ) { 

	    Node insert = left;
	    if (right != null)
		insert = right;

	    if (isLeft) {
		parent.setLeft( insert );
	    }
	    else {
		parent.setRight( insert );
	    }
	    return ;
	}
	

	// Case C

	Node mover = largest( left );
	delete( mover.getData() );

	if (isLeft)
	    parent.setLeft( mover );
	else
	    parent.setRight( mover );

	mover.setRight( right );

	cur = mover;
	while (cur.getLeft() != null) {
	    cur = cur.getLeft();
	}
	cur.setLeft( left );
    }
		

}