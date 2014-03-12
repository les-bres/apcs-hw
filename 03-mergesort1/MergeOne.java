public class MergeOne {

    public static int[] merge( int[] a, int[] b) {
	return merge( a, b, new int[ a.length + b.length ], 0, 0, 0 );
    }

    public static int[] merge( int[] a, int[] b, int[] cG, int aPP, int bPP, int cPP ) { 



	int aP = aPP;
	int bP = bPP;
	int cP = cPP;

	//System.out.println( aP + " " + bP + " " + cP );
	int[] c = cG;

	if ( aP >= a.length ) {
	    for (int i = bP; i < b.length; i++){
		c[ cP ] = b[ i ];
		cP++;
	    }
	    return c;
	}
	else if ( bP >= b.length ) {
	    for (int i = aP; i < a.length; i++){
		c[ cP ] = a[ i ];
		cP++;
	    }
	    return c;
	}
	
	if ( a[aP] < b[bP] ) {
	    c[ cP ] = a[aP];
	    aP++;
	}
	else {
	    c[ cP ] = b[bP];
	    bP++;
	}
	cP++;

	return merge( a, b, c, aP, bP, cP );
    }

    public static void main( String[] args ) {
	int[] a = {1,2,3,4,5,6};
	int[] b = {0,6,8,14};
	int[] c = new int[ a.length + b.length ];

	c = merge( a, b );

	String retStr = "";
	for (int i = 0; i < c.length; i++) {
	    retStr += c[i] + ",";
	}
	System.out.println( retStr );
    }
}