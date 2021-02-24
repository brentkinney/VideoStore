public class SLLTester {    
	public static void main(String[] args) {
		// Create Nodes a (element = 1), b (element = 2), c (element = 3)
		SLLNode a = new SLLNode(1, null);
		SLLNode b = new SLLNode(2, null);
		SLLNode c = new SLLNode(3, null);

		// Create SLL s
		SLL s = new SLL();

		// Print all elements in s // output nothing
		s.print();

		// Add a, b, c to s, and then print all elements in s // output 1, 2, 3
		s.add(a);
		s.add(b);
		s.add(c);
		s.print();
		System.out.println(s.middle());

		// Remove, and then print all elements in s // output 1, 2
		s.remove();
		s.print();
		System.out.println(s.middle());

		// Remove, and then print all elements in s // output 1
		s.remove();
		s.print();

		// Remove, and then print all elements in s // output nothing
		s.remove();
		s.print();

		// Add a, b, c to s, and then print all elements in s // output 1, 2, 3
		s.add(a);
		s.add(b);
		s.add(c);
		s.print();

		// Reverse s, and then print all elements in s // output 3, 2, 1
		s.reverse();
		s.print();

		// Add a method in SLL to search whether it contains an element x
		System.out.println(s.search(1));
		System.out.println(s.search(0));

		// Add a method in SLL to return the index i of element x
		var index = s.getIndex(1);
		System.out.println("Index of Element 1 is " + index);
		index = s.getIndex(0);
		System.out.println("Index of Element 0 is " + index);

		// Add a method in SLL to add a node at index i
		//SLLNode d = new SLLNode(4, null);
		s.addAtIndex(4, 1);
		s.print();
		System.out.println(s.middle());

		// Add a method in SLL to remove the node at index i
		s.removeAtIndex(1);
		s.print();

		// Add a method to find the number of nodes in SLL
		//var length = s.Length();
		//System.out.println("SLL contains " + length + " nodes.");

		// Sort s in ascending order, and then print all elements in s // output 1, 2, 3
		//s.Sort();
		//s.Print();

		// Get the middle node
		//Node middle = s.middle();
		System.out.println(s.middle());

	}
}
