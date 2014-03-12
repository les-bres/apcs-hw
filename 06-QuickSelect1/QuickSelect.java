

public class QuickSelect {

    public static int quickselect( int[] a, int k, int low, int high) {
	if (low >= high)
	    return a[low];

	int ran = (int) (Math.random() * (high - low + 1)) + low;

	int[] n = new int[ a.length ];

	int left = low;
	int right = high;

	for (int i = low; i <= high; i++) {
	    if ( i == ran ) {}
	    else if ( a[i] < a[ran] ) {
		n[left] = a[i];
		left++;
	    }
	    else {
		n[right] = a[i];
		right--;
	    }
	}
		
	
	if ( k == right )
	    return a[ran];

	if (k > right)
	    return quickselect( n,k,right+1,high);

	return quickselect( n,k, low, right-1);

    }

    public static int quickselect( int[] a, int k ) {
	return quickselect( a, k, 0, a.length - 1 );
    }



    public static void main( String[] args ) {

	int[] a = {10,4,1,8,7,9,12,3};

	System.out.println( quickselect( a, 0 ) );
	System.out.println( quickselect( a, a.length - 1 ) );
	System.out.println( quickselect( a, 3 ) );
	
    }
}
    

/* 
   Trace diagram:

   a = [4,1,5,7,6,10,3,2]
   quickselect( a, 6, 0, 7 )
   ran = 4
   a[ran] = 6
   left = 0
   right = 7

   n = [0,0,0,0,0,0,0,0]

   n = [4,0,0,0,0,0,0,0]
   n = [4,1,0,0,0,0,0,0]
   n = [4,1,5,0,0,0,0,0]
   n = [4,1,5,0,0,0,0,7]
   n = [4,1,5,0,0,0,10,7]
   n = [4,1,5,3,0,0,10,7]
   n = [4,1,5,3,2,0,10,7]

   now both left and right = 5


   quickselect( n, 6, 6, 7 )

   ran = 7
   a[ran] = 7
   left = 6
   right = 7

   n = [0,0,0,0,0,0,0,0]
   n = [0,0,0,0,0,0,0,10]

   now both left and right = 6
   so DONE!
*/	
