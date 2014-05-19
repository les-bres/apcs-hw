Set Interface:
	Set<E> extends Collection<E>
	is a collections that contains no duplicate elements
	boolean add( E e )
	boolean contains(Object o)
	boolean remove(Object o)

Map Interface:
	Map<K,V>, k = type of keys, v = type of mapped values
	object that maps keys to values, no dup keys
	boolean containsKey( Object key )
	boolean containsValue(Object value)
	V get(Object key)
	V put(K key, V value)
	V remove(Object key)

Difference between Hashset and Hashmap:
	Hashset sets it up like this: {1,2,3,4}, such that there are no duplicate values, implements the set interface, stores only objects, uses add method, uses hash functions
	Hashmap sets it up like this:{A->2, B->5, C->2}, such that there are no duplicate keys, but there can be duplicate values, and each key maps to a value, implements map interface, uses put method, uses hash table


Internal Implementation of Hashmap:
	When you execute put(key, value), a hasCode method is called on the Key object to find a bucket location for storing the value object.  If two different objects have the same hashcode, they will be implemented in a linked list.  The data structure this is all stored in is an Entry array, with an Entry having the functionality of a linked list Node.

Internal Implementation of Treemap:
	The distinction with a treemap is that the data is stored in a red-black tree as opposed to an array.

Speed Test Results:
	Although the difference was of course not noticable until I used data sets of massive size, HashMaps turned out to be faster than TreeMaps.  This is because Hashmaps have constant runtime for accessing elements instead of O(n) bc of iterating.

- Java Heap data structure = PriorityQueue


