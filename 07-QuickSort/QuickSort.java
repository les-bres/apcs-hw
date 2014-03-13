import java.util.*;


public class QuickSort {



    // i experimented with going from int[] to integer and then back but it the converting from ArrayList<Integer> to int[] doesn't work
    public static int[] qSort( int[] a ) {

	ArrayList<Integer> arr = new ArrayList<Integer>();
	for (int i = 0; i < a.length; i++) {
	    arr.add( new Integer( a[i] ) );
	}
	

	ArrayList<Integer> sorted = qSort( arr );
	return sorted.toArray( new int[ sorted.size() ] );
    }


    // fully functional!
    public static ArrayList<Comparable> qSort( ArrayList<Comparable> a ) {
	
	int size = a.size();

	if ( size <= 1 )
	    return a;

	// use pivot to sort array into upper and lower arraylists

	int pivot = (int) (Math.random() * size );

	ArrayList<Comparable> lower = new ArrayList<Comparable>();
	ArrayList<Comparable> upper = new ArrayList<Comparable>();

	for (int i = 0; i < size; i++) {
	    if ( i == pivot ) {}
	    else if ( a.get(i).compareTo(a.get(pivot)) < 0 ) {
		lower.add( a.get(i) );
	    }
	    else {
		upper.add( a.get(i) );
	    }
	}


	// sort both parts, then combine

	ArrayList<Comparable> r1 = qSort( lower ); 
	ArrayList<Comparable> r2 = qSort( upper );

        ArrayList<Comparable> retArr = new ArrayList<Comparable>();

	for (int i = 0; i < r1.size(); i++) {
	    retArr.add( r1.get( i ) );
	}
	retArr.add( a.get( pivot ) );

	for (int i = 0; i < r2.size(); i++) {
	    retArr.add( r2.get(i) );
	}

	return retArr;
    }

    public static void main( String[] args ) {

	// create array
	ArrayList b = new ArrayList<Integer>();
	for ( int i = 0; i < 20; i++ ) {
	    b.add( new Integer((int) (Math.random() * ((i + 5) * 2)) ) );
	}
	System.out.println( b );
	System.out.println( qSort( b ) );

	int[] a = {12,4,7,3,9,8,10,3,2};
	System.out.println( a );
	System.out.println( qSort( a ) );

    }
}



       
