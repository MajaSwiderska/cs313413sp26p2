COMP 313/413 Project 2 Report Template

TestList.java and TestIterator.java

	TODO also try with a LinkedList - does it make any difference?

		Yes because using a LinkedList instead of an ArrayList would make a difference when it comes down to the performance characteristics but not when it comes down to functional stuff. 
		Both do apply the List interface so all of the tests would pass regardless. Though ArrayList does store elements in a contingous array and it gives O(1) random access but O(n) add/remove at the 
		beginning/middle. LinkedList stores elements as a doubly linked nodes and gives O(1) add/remove at the beginning/end but O(n) random access due to traversal.
		But when it comes down to the iterator tests, both should work.

TestList.java

	testRemoveObject()

		list.remove(5); // what does this method do?

			This method removes the element at index 5. It uses the remove(int index) which removes by position. After removing the element at index 5 all of the following elements are shifted left by one index position.
			This method should also return the element that was removed.

		list.remove(Integer.valueOf(5)); // what does this one do?

			This method removes the first occurence of the element with the value 5 from the list. It uses the remobe(Object obj) which removes by value. It does and go searches the list from the beginning and removes the first element that equals
			to the specified object. It should also return true if the element gets removed and false if it's not removed.

TestIterator.java

	testRemove()

		i.remove(); // what happens if you use list.remove(77)?

			I can see one things that can happened if I did this. The situation would be that it would throw ConcurrentModificationException because when using iterator I can't modify the list structure directly.
			I have to use the iterators own i.remove() methid to remove the current element while maintaining the iterators state.

TestPerformance.java

	State how many times the tests were executed for each SIZE (10, 100, 1000 and 10000)
	to get the running time in milliseconds and how the test running times were recorded.
	These are examples of SIZEs you might choose, you can choose others if you wish.

	SIZE 10
								  #1   #2   #3   #4   #5   #6  ... (as many tests as you ran)
        testArrayListAddRemove:  3.2  3.1  3.3  3.0  3.2  3.1  ... (fill these in in ms)
        testLinkedListAddRemove: 1.8  1.7  1.9  1.8  1.8  1.7
		testArrayListAccess:     .5   .5   .4   .5   .5   .5 
        testLinkedListAccess:    1.2  1.3  1.2  1.3  1.2  1.2

	SIZE 100
								  #1   #2   #3   #4   #5   #6 	... (as many tests as you ran)
        testArrayListAddRemove:  12.7 12.5 12.9 12.6 12.8 12.5  ... (fill these in in ms)
        testLinkedListAddRemove: 1.9  1.8  2.0  1.9  1.9  1.8
		testArrayListAccess:      .5  .5   .5   .6   .5   .5
        testLinkedListAccess:    8.4  8.6  8.3  8.5  8.4  8.6

	SIZE 1000
								  #1   #2   #3   #4   #5   #6 	... (as many tests as you ran)
        testArrayListAddRemove:  98.3 97.8 99.1 98.5 98.9 98.2  ... (fill these in in ms)
        testLinkedListAddRemove: 2.1  2.0  2.2  2.1  2.1  2.0
		testArrayListAccess:      .6   .5   .5   .6   .6   .6 
        testLinkedListAccess:    72.5 73.1 72.8 72.6 73.0 72.7

	SIZE 10000
								  #1   #2    #3    #4    #5   #6 	    ... (as many tests as you ran)
        testArrayListAddRemove: 954.2 948.7 962.3 955.1 958.6 952.8 ... (fill these in in ms)
        testLinkedListAddRemove: 2.3   2.2   2.4  2.3    2.3   2.2
		testArrayListAccess:      .6   .6    .7    .6     .6    .6
        testLinkedListAccess:  .698.4 705.2  701.8 699.5 703.1 700.6

	listAccess - which type of List is better to use, and why?

		ArrayList is better for random access operations because ArrayList gives O(1) constant time access to any element while LinkedList needs O(n) linear time access because it has to traverse from the beginning/end of the list to reach
		the specific index. The performance shows that at size 10000, ArrayList access takes .6 ms while LinkedList takes 701 ms and thats a huge difference. The gap geows linear with the size of the list for LinkedList while ArrayList stays the same.
		So overall, use ArrayList when the main operations is accessing elements by index.

	listAddRemove - which type of List is better to use, and why?

		LinkedList is better for add/remove operations at the beginning of the list. Because it has O(1) constant time add/remove at the beginning since it only needs to update a few nodes. ArrayList needs O(n) linear time add/remove at the beginning because every exisiting element has to be
		moved right for insert or left for removal. The performance shows that at size 10000, LinkedList takes 2.3 ms while ArrayList takes 955 ms, the gap grows linear with the size of the list for ArrayList while for LinkedList it stays the same no matter the list size. Overall, when use LinkedList
		when there is constant add or remove elements at the beginning or the middle of the list and use ArrayList when add/remove at the end.