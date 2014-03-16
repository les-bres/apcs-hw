// sorry i got confused about whether i was supposed to submit this for friday's class bc nothing was on the site but here it is now!

import java.util.*;
import java.io.*;


public class QuickSort2 {

    public static int partition( int[] a, int l, int r ) {

	int pivotIdx = (int) (Math.random() * (r-l + 1)) + l;

	int temp = a[r];
	int pivot = a[pivotIdx];
	
	// set pivot aside
	a[r] = pivot;
	a[pivotIdx] = temp;

	/*
	System.out.println( pivot );
	System.out.println( printArr( a ) );
	*/

	// wall stands in for the furthest left number > pivot
	int wall = l;

	for (int i = l; i < r; i++) {
	    if ( a[i] < pivot ) {
		//System.out.println( a[i] );
		temp = a[wall];
		a[wall] = a[i];
		a[i] = temp;
		//System.out.println( printArr( a ) );
		wall++;
	    }
	}

	temp = a[wall];
	a[wall] = pivot;
	a[r] = temp;

	/*
	System.out.println( wall );
	System.out.println( printArr( a ) );
	System.out.println ( "~~~~~~~~~~~~" );
	*/

	return wall;

    }

    public static void quickSort( int[] a, int l, int r) {

	if ( a.length <= 1 ){
	}
	
	else {
	    int num = partition( a, l, r );
	    // if the lower section has more than 1 element:
	    if ( num -1 > l )
		quickSort( a, l, num-1 );
	    if ( num +1 < r )
		quickSort( a, num+1, r );
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

	int[] a = {12,4,7,3,9,8,10,3,2};
	System.out.println( printArr( a ));
	quickSort( a );
	System.out.println( printArr( a ));

    }
}



       
