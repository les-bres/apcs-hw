
public class BinSearch2 {


 
    public static int binSearch ( Comparable[] a, Comparable target ) {

        return binSearchIter( a, target, 0, a.length-1 );
        //return binSearchRec( a, target, 0, a.length-1 );
    }


    public static int binSearchRec( Comparable[] a, Comparable target, int lo, int hi ) {
        int tPos = -1; 
        int m = (lo + hi) / 2; 

	//exit case. If lo & hi have crossed, target not present
        if (lo > hi) {
	    tPos = -1;
	}

	// target found
        else if ( a[m].equals(target) ) {
	    tPos = m;
	}
	
	// value at middle index higher than target
        else if ( a[m].compareTo( target) > 0 ) {
	    return binSearchRec( a, target, lo, m - 1);
	}

	// value at middle index lower than target
        else if ( a[m].compareTo( target) < 0 )  {
	    return binSearchRec( a, target, m + 1, hi);
	}

        return tPos;
    }


    public static int binSearchIter( Comparable[] a, Comparable target, int lo, int hi ) {
        int tPos = -1; 
        int m = (lo + hi) / 2; 

	// run until lo & hi cross
        while( lo <= hi ) { 
            //update mid pos var
	    m = (lo + hi) / 2; 


	    // target found
            if ( a[m].equals( target ) ) {
		tPos = m;
		break;
	    }

	    // value at middle index higher than target
            else if ( a[m].compareTo( target) > 0 ) {
		hi = m - 1;	
	    }

	    // value at mid index lower than target
            else if ( a[m].compareTo( target) < 0 ) {
		lo = m + 1;

	    }
                
        }

        return tPos;
    }




    private static void printArray( Comparable[] arr ) {
        String output = "[ "; 

        for( Comparable i : arr )
            output += i + ", ";

        output = output.substring( 0, output.length()-2 ) + " ]";

        System.out.println( output );
    }



    public static void main ( String[] args ) {


        //declare String array
	String[] sArr = {"aang", "bang", "cang", "dang", "eang", "fang"};
	// in String compareTo method, the later letters in the alphabet have the lower value

        printArray( sArr );

        //search for 6 in array 
        System.out.println( binSearch(sArr,sArr[0]) );
        System.out.println( binSearch(sArr,sArr[1]) );
        System.out.println( binSearch(sArr,sArr[2]) );
        System.out.println( binSearch(sArr,sArr[3]) );
        System.out.println( binSearch(sArr,sArr[4]) );
        System.out.println( binSearch(sArr,sArr[5]) );

	String sThing = "cat";

        //search for cat in array 
        System.out.println( binSearch(sArr,"cat") );

        

    }//end main()

}//end class BinSearch