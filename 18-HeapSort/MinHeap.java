import java.util.*;
import java.io.*;

public class MinHeap{

    private int[] nums;
    private int length;

    public MinHeap() {
	nums = new int[50];
	length = 0;
    }

    public void grow() {
	int[] temp = new int[(int) (nums.length * 1.5)];
	for (int i = 0; i < nums.length; i++) {
	    temp[i] = nums[i];
	}
	nums = temp;
    }

    public int avail() {
	int i = 0;
	while ( i < nums.length && nums[i] != 0 ) {
	    i++;
	}
	return i;
    }



    public void add(int x) {
       
	int loc = avail();

	//if tree full
	if ( loc >= nums.length ) {
	    grow();
	}
	nums[loc] = x;	

	// if too big 
	while ( nums[loc] < nums[ findParent(loc) ] ) {
	    swap( loc, findParent(loc) );
	    loc = findParent(loc);
	}
	length++;

    }

    public int remove() {
	int num = nums[0];
	
	nums[0] = 9999;

	removerec(0);
	length--;

	for (int i = 0; i < length; i++) {
	    if (nums[i] == 9999) {
		nums[i] = 0;
		break;
	    }
	}

	return num;
    }

    public void removerec( int ind ) {
	int left = leftChild(ind);
	int right = rightChild(ind);

	//if left
	if (nums[left] != 0) {
	    if ( nums[ind] > nums[left ] ) {
		swap( ind, left );
		removerec( left );
	    }
	}
	//if right
	if (nums[right] != 0) {
	    if ( nums[ind] > nums[right] ) {
		swap( ind, right );
		removerec( right );
	    }
	}
    }

    public void swap( int one, int two ) {
	int temp = nums[one];
	nums[one] = nums[two];
	nums[two] = temp;
    }

    public int findParent(int ind) {
	return ind/2;
    }

    public int leftChild( int ind ) {
	return (2* ind) +1;
    }

    public int rightChild( int ind ) {
	return (2*ind) + 2;
    }
    
    public String toString() {
	String retStr = "";

	for (int i = 0; i < length; i++ ) {
	    retStr += nums[i] + ", ";
	}
	return retStr;
    }

    public static void main( String[] args ) {
	MinHeap heap = new MinHeap();
	heap.add(1);
	heap.add(2);
	heap.add(8);
	heap.add(7);
	heap.add(3);
	heap.add(5);
	heap.add(10);
	System.out.println( heap );
	heap.remove();
	System.out.println( heap );
    }
}

