// still  needs some debugging, no time to fix tonight but i will do so tmrw!

public class QuickSelect {

    public int quickselect( int[] a, int k, int low, int high) {
	if (low >= high)
	    return a[low];

	int ran = (int) (Math.random() * (high - low)) + low;

	int[] n = new int[ a.length ];

	int left = low;
	int right = high;

	for (int i = low; i <= high; i++) {
	    if ( i = ran ) {}
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
	    return quickselect( n,k,right,high);

	if (k < right)
	    return quickselect( n,k, low, right);

    }

	


		
