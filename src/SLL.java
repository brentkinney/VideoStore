public class SLL {
    private SLLNode head;

    /**
     * The default constructor
     */    
    public SLL() {
        head = null;
    }

    /**
     * get node at the head
     * @return head node
     */
    public SLLNode getHead() {
        return head;
    }

    /**
     * set head to given node
     * @param n the node that will become the head
     */
    public void setHead(SLLNode n) {
        head = n;
    }

    /**
     * print out all elements in the list
     * @return output string
     */
    public String print() {
        String out ="The SLList contains:\n";
		SLLNode ref = head;
		if(ref == null)
			return out + "0 nodes.";
		else
			out += "head ->\t";
		
		while(ref.getNext() != null)
		{
			out += ref.getElement() + "\t->\t";
			ref = ref.getNext();
		}
		
		out += ref.getElement() +"\t->null"; //Add the last node.
		return out;
    }

    /**
     * adds given element to the end of the list, becoming the new tail
     * @param n the node to set as tail
     */
    public void add(SLLNode n) {
        n.setNext(null);

        if(head == null) {
            head = n;
            return;
        }

        SLLNode node = head;

        while(node.getNext() != null) {
            node = node.getNext();
        }

        node.setNext(n);
    }

    /**
     * remove last element (tail) in the list
     */
    public void remove() {
        if(head == null) {            
            return;
        }

        SLLNode node = head;
        if(node.getNext() == null) {
            head = null;
        }

        while(node.getNext() != null) {
            SLLNode temp = node.getNext();
            if(temp.getNext() == null) {
                node.setNext(null);
            }
            else {
                node = node.getNext();
            }
        }
    }

    /**
     * reverse nodes contained in list
     */
    public void reverse() {        
        SLLNode previous = null;
        SLLNode current = head;

        while(current != null) {
            SLLNode next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    /**
     * check to see if list contains given element
     * @param element to search for
     * @return true if element found in list
     */
    public boolean search(Object element) {
        if(head == null) {            
            return false;
        }
       if(head.getElement() == element) {
           return true;
       }

       SLLNode ref = head;
       while(ref.getNext() != null) {
           if(ref.getNext().getElement() == element) {
               return true;
           }
           ref = ref.getNext();
       }
       return false;
    }
}
