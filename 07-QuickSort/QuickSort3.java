// i'm getting a stackoverflow error that i couldn't quite resolve but i at least know my partition method standing alone works

import java.util.*;
import java.io.*;


public class QuickSort3 {

    public static int partition( int[] a, int l, int r ) {

	int pivotIdx = (int) (Math.random() * (r-l + 1)) + l;

	int temp = a[r];
	int pivot = a[pivotIdx];
	
	// set pivot aside
	a[r] = pivot;
	a[pivotIdx] = temp;

	
	System.out.println( pivot );
	System.out.println( printArr( a ) );
	
	// wall stands in for the furthest left number > pivot
	int wall = l;
	int rwall = l;

	for (int i = l; i < (r - (rwall - wall) ); i++) {
	    if ( a[i] == pivot ) {
		System.out.println( a[i] );
		int spot = r - (rwall - wall) - 1;
		temp = a[spot];
		a[spot] = a[i];
		a[i] = temp;
		rwall++;
		System.out.println( printArr( a ) );
	    }

	    if ( a[i] < pivot ) {
	        System.out.println( a[i] );
		temp = a[wall];
		a[wall] = a[i];
		a[i] = temp;
		System.out.println( printArr( a ) );
		wall++;
		rwall++;
	    }
	}

	for (int i = 0; i <= (rwall -wall); i++) {
	    temp = a[ wall + i];
	    a[ wall + i ] = pivot; 
	    a[ r - i ] = temp;
	}

	
	System.out.println( wall );
	System.out.println( printArr( a ) );
	System.out.println ( "~~~~~~~~~~~~" );
	

	return (wall + rwall) / 2;

    }

    public static void quickSort( int[] a, int l, int r) {

	if ( a.length <= 1 ){
	}
	
	else {
	    int num = partition( a, l, r );
	    // if the lower section has more than 1 element:
	    if ( num -1 > l )
		quickSort( a, l, num );
	    if ( num +1 < r )
		quickSort( a, num, r );
	}
    }

    public static void quickSort( int[] a ) {
	quickSort( a, 0, a.length-1 );
    }

    public static String printArr( int[] a ) {
	String retStr = "[";
	for ( int i = 0 ; i < a.length; i ++ ) {
	    retStr += a[i] + ",";
	}
	retStr = retStr.substring( 0, retStr.length() -1);
	return retStr + "]";
    }

    public static void main( String[] args ) {

	int[] a = {12,4,7,3,9,8,10,3,2,2,3,9,12,10};
	System.out.println( printArr( a ));
	quickSort( a );
	System.out.println( printArr( a ));

    }
}



       
