
public class KnightTour {

    private char[][] board;
    private boolean solved = false;
    final private char knight = 'k';
    final private char empty = ' ';

    public KnightTour( int n ) {

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

    private void delay(int n)
    {
	try{
	    Thread.sleep(n);
	}
	catch (InterruptedException e) {
	    System.exit(0);
	}
    }


    public void solve(int x, int y) {

	
	if (solved()) {
	    solved = true;
	    System.out.println( this );
	}
	else if ( x < 5 && x > -1 && y < 5 && y > -1 && board[x][y] == empty ) {
	    //delay( 10 );
	    board[x][y] = knight;
	    System.out.println(this);

	    solve(x+2, y+1);
	    if (!solved)
		solve(x+2,y-1);
	    if (!solved)
		solve(x-1,y+2);
	    if (!solved)
		solve(x+1,y+2);
	    if (!solved)
		solve(x+1,y-2);
	    if (!solved)
		solve(x-1,y-2);
	    if (!solved)
		solve(x-2,y+1);
	    if (!solved)
		solve(x-2,y-1);

	    board[x][y] = empty;
	}


    }


    public boolean solved() {
	for (int i = 0; i < board.length; i++) {
	    for (int num = 0; num < board.length; num++) {
		if ( board[i][num] != knight ) 
		    return false;
	    }
	}
	return true;
    }


    public static void main( String[] args ) {

	KnightTour game = new KnightTour( 5 );
	System.out.println( game );
	game.solve(0,0);
    }

}
	
	    


