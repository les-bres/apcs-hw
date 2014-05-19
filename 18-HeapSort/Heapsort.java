public class Heapsort {

    public static int[] sort( int[] a ) {
	
        MinHeap min = new MinHeap();
	int[] temp = new int[ a.length ];

	for (int i = 0; i < a.length; i++) {
	    min.add( a[i] );
	}

	for (int i = 0; i < temp.length; i++) {
	    temp[i] = min.remove();
	}
	
	return temp;
    }

    public static void main( String[] args ) {
	Heapsort heap = new Heapsort();
	int[] b = {4,5,9,1,3,7};
	b = heap.sort( b );
        for (int i = 0; i < b.length; i++) {
	    System.out.println(b[i]);
	}
    }
}
