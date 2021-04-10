public class DLLTester {    
	public static void main(String[] args) {
		// Create DNodes a (element = 1), b (element = 2), c (element = 3)
		DLLNode a = new DLLNode(1, null, null);
		DLLNode b = new DLLNode(2, null, null);
		DLLNode c = new DLLNode(3, null, null);
		DLLNode D = new DLLNode(4, null, null);
		DLLNode e = new DLLNode(5, null, null);

		// Create DList d
		DLL d = new DLL();

		// Print all elements in d // output nothing
		d.print();

		// Call addFirst to add b to d; Call addFirst to add a to d; Call addLast to add
		// c to d; then print all elements in d // output 1, 2, 3
		d.setHead(b);
		d.setHead(a);
		d.setTail(c);
		d.print();

		// Remove b, and then print all elements in d // output 1, 3
		d.remove(b);
		d.print();

		// Remove a, and then print all elements in d // output 3
		d.remove(a);
		d.print();

		// Remove c, and then print all elements in d // output nothing
		d.remove(c);
		d.print();

		// Call addFirst to add b to d; Call addFirst to add a to d; Call addLast to add
		// c to d; then print all elements in d // output 1, 2, 3
		d.setHead(D);
		d.setHead(c);
		d.setHead(b);
		d.setHead(a);
		d.setTail(e);
		d.print();

		// Reverse d, and then print all elements in d // output 3, 2, 1
		d.reverse();
		d.print();

		// Add a method in DList to search whether it contains an element x
		System.out.println(d.search(1));
		System.out.println(d.search(0));

		// Add a method in DList to return the index i of element x
		var index = d.getIndex(1);
		System.out.println("Index of Element 1 is " + index);
		index = d.getIndex(0);
		System.out.println("Index of Element 0 is " + index);

		// Add a method in DList to add a node at index i
		//DLLNode x = new DLLNode(4, null, null);
		d.addAtIndex(4, 1);
		d.print();

		// Add a method in DList to remove the node at index i
		d.removeAtIndex(1);
		d.print();
		
		d.swap(1,3);
		d.print();
		
		System.out.println("E Prev: " + e.getPrev());
		System.out.println("E Next: " + e.getNext().getElement());
		System.out.println("C Prev: " + c.getPrev().getElement());
		System.out.println("C Next: " + c.getNext().getElement());
		System.out.println("B Prev: " + b.getPrev().getElement());
		System.out.println("B Next: " + b.getNext().getElement());
		System.out.println("D Prev: " + D.getPrev().getElement());
		System.out.println("D Next: " + D.getNext().getElement());
		System.out.println("A Prev: " + a.getPrev().getElement());
		System.out.println("A Next: " + a.getNext());
		// Add a method to find the number of nodes in SLL
		//var length = d.Length();
		//System.out.println("DList contains " + length + " nodes.");
		
		// Sort s in ascending order, and then print all elements in s // output 1, 2, 3
		//d.Sort();
		//d.Print();
	}
}


