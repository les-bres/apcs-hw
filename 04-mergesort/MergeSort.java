import java.util.*;


public class MergeSort {


    // merges two arrays putting them together in sorted order
    public static ArrayList<Comparable> merge( ArrayList<Comparable> a, ArrayList<Comparable> b, ArrayList<Comparable> c) {
	
	if ( a.size() == 0 ) {
	    for (int i = 0; i < b.size(); i++){
		c.add( b.get( i ) );
	    }
	    return c;
	}
	else if ( b.size() == 0 ) {
	    for (int i = 0; i < a.size(); i++){
		c.add( a.get( i ) );
	    }
	    return c;
	}
	
	if ( (a.get(0).compareTo( b.get(0) )) < 0 ) {
	    c.add( a.get(0) );
	    a.remove(0);
	}
	else {
	    c.add( b.get(0) );
	    b.remove( 0 );
	}

	return merge( a, b, c );
    }

    // takes an array of comparable objects and continuously splits until left with an array of arrays of length 1
    public static ArrayList<ArrayList<Comparable>> split( ArrayList<Comparable> a ) {


	ArrayList<ArrayList<Comparable>> retArr = new ArrayList<ArrayList<Comparable>>();
	retArr.add( a );

	

	while (notSplit( retArr ) ) {
	   
	    for ( int i = 0; i < retArr.size(); i++ ) {

		ArrayList<Comparable> arr = retArr.get( i );
	

		if (arr.size() > 1) {

		    int mid = arr.size() / 2;
		    ArrayList<Comparable> one = new ArrayList<Comparable>();
		    ArrayList<Comparable> two = new ArrayList<Comparable>();

		    for (int n = 0; n < mid; n++ ) {
			one.add( arr.get( n ) );
		    }
		    for (int n = mid; n < arr.size(); n++) {
			two.add( arr.get( n ) );
		    }

		    retArr.remove( i );
		    retArr.add( i, two );
		    retArr.add( i, one );
		}
	    }
	}
	return retArr;
    }

    // checks if there are still arrays with more than 1 object
    public static boolean notSplit( ArrayList<ArrayList<Comparable>> arr ) {
	
	for ( ArrayList<Comparable> a : arr ) {
	    if (a.size() > 1) {
		return true;
	    }
	} return false;
    }

    public static ArrayList<Comparable> mergeSort( ArrayList<Comparable> a ) {

	return mergeSort2( split( a ) );
	
    }
		
    public static ArrayList<Comparable> mergeSort2( ArrayList<ArrayList<Comparable>> a ) {

	//System.out.print( a + "\n\n" );

	if ( a.size() == 1 ) 
	    return a.get(0);


	for (int i = 0; i < a.size() - 1; i++) {
	    ArrayList<Comparable> combined = merge( a.get(i), a.get(i + 1), new ArrayList<Comparable>() );
	    a.remove( i );
	    a.remove( i );
	    a.add( i, combined );
	}

	return mergeSort2( a );
    }
	
	
    public static void main( String[] args ) {
	
	// create array
	ArrayList a = new ArrayList<String>();

	a.add("cat");
	a.add("dog");
	a.add("rhino");
	a.add("giraffe");
	a.add("apple");

	System.out.println( a );
	System.out.println( mergeSort( a ) );
    }
}