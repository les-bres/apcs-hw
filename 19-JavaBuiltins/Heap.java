public class Heap {

    private MinHeap min;
    private MaxHeap max;

    public Heap() {
	min = new MinHeap();
	max = new MaxHeap();
    }

    public void add( int x ) {
	max.add(x);
	if ( max.size() > min.size() ) {
	    min.add( max.remove() );
	}
    }

    public int findMedian() {
	int maxN = max.size();
	int minN = min.size();

	if ( maxN > minN )
	    return max.pop();
	if ( minN > maxN )
	    return min.pop();
	else 
	    return (min.pop() + max.pop()) / 2;
    }

    public int removeMedian() {
	int maxN = max.size();
	int minN = min.size();

	if ( maxN > minN )
	    return max.remove();
	if ( minN > maxN )
	    return min.remove();
	else {
	    int n =  (min.pop() + max.pop()) / 2;
	    max.remove();
	    min.remove();
	    return n;
	}
    }


    public static void main( String[] args ) {

	Heap heap = new Heap();
	heap.add(1);
	heap.add(2);
	heap.add(8);
	heap.add(7);
	heap.add(3);
	heap.add(5);
	heap.add(10);

	System.out.println( heap.removeMedian() );
	System.out.println( heap.removeMedian() );
	System.out.println( heap.removeMedian() );
	System.out.println( heap.removeMedian() );
    }

	

}