

public class Nqueens {

    private char[][] board;
    private boolean solved = false;
    final private char queen = 'q';
    final private char empty = ' ';

    public Nqueens( int n ) {

	board = new char[n][n];

	for (int i = 0; i < n; i++) {
	    for (int num = 0; num < n; num++) {
		board[i][num] = empty;
	    }
	}
    }

    public String toString() {

	String line = "";
	for ( int i = 0; i <= board.length * 2 ; i++ ) {
	    line += "-";
	}

	String retStr = line + "\n";	

	for ( int i = 0; i < board.length; i ++ ) {
	    for ( int num = 0; num < board.length; num++ ) {
		retStr += "|" + board[i][num];
	    }
	    retStr += "|\n" + line + "\n" ;
	}
	return retStr;
    }

    public boolean safeSpace(int x, int y) {

	// check verticle
	for (int i = 0; i < board.length; i++) {
	    if (board[x][i] == queen) 
		return false;
	}

	//check across
	for (int i = 0; i < board.length; i++) {
	    if (board[i][y] == queen)
		return false;
	}

	// check downwards diagonal
	int r = x;
	int c = y;

	while ( inBounds( r, c ) ) {
	    if (board[r][c] == queen)
		return false;
	    r++;
	    c++;
	}
	r = x;
	c = y;
	while ( inBounds( r, c ) ) {
	    if (board[r][c] == queen)
		return false;
	    r--;
	    c--;
	}

	// check for upwards diagonal
       	r = x;
	c = y;

	while ( inBounds( r, c ) ) {
	    if (board[r][c] == queen)
		return false;
	    r++;
	    c--;
	}
	r = x;
	c = y;
	while ( inBounds( r, c ) ) {
	    if (board[r][c] == queen)
		return false;
	    r--;
	    c++;
	}

	return true;
	
    }
    
    public boolean inBounds( int x, int y ) {
	int n = board.length;
	return (x > -1 && x < n && y > -1 && y < n);
    }



    private void delay(int n)
    {
	try{
	    Thread.sleep(n);
	}
	catch (InterruptedException e) {
	    System.exit(0);
	}
    }

    public int countQ() {
	int retInt = 0;
	for (int i = 0; i < board.length; i++) {
	    for (int n = 0; n < board.length; n++) {
		if (board[i][n] == queen)
		    retInt++;
	    }
	}
	return retInt;
    }

    public int nextCol(int y) {
	int n = y+1;
	if (!(n < board.length)) {
	    n -= board.length;
	}
	return n;
    }
	       

    public void solve(int x, int y)  {
	if (countQ() == board.length) {
	    solved = true;
	    System.out.println( this );
	}
	else if ( inBounds( x, y ) && safeSpace( x, y ) ) {
	    delay( 100 );
	    board[x][y] = queen;
	    System.out.println( this );
	    
	    int col = nextCol( y );

	    solve( 0, col);

	    for ( int i = 1; i < board.length; i ++ ) {
		if (!solved)
		    solve( i, col);
	    }

	    board[x][y] = empty;
	}
    }


    public static void main( String[] args ) {
	Nqueens game = new Nqueens( 5 );
	System.out.println( game );
	game.solve( 0, 4 );
    }
}

  
