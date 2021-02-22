public class DLL {
    private DLLNode head;
    private DLLNode tail;

    /**
     * default constructor
     */
    public DLL() {
        head = null;
        tail = null;
    }

    /**
     * get head node
     * @return head of list
     */
    public DLLNode getHead() {
        return head;
    }

    /**
     * set head of list (insert node in front)
     * @param node to set as new head
     */
    public void setHead(DLLNode node) {
        if(head == null)
		{
			head = tail = new DLLNode(node, null, null);
		}
        else
        {
            head.setPrev(node);
            node.setNext(head);
            node.setPrev(null);
            head = node;
        }
    }

    /**
     * get tail node
     * @return tail of list
     */
    public DLLNode getTail() {
        return tail;
    }

    /**
     * set tail of list (append node to end)
     * @param node to set as new tail
     */
    public void setTail(DLLNode node) {
        if(head == null)
		{
			head = tail = new DLLNode(node, null, null);
		}
		else 
		{
			tail.setNext(node);
            node.setPrev(tail);
            tail = node;
            tail.setNext(null);            			
		}
    }

    /**
     * print nodes in the list
     * @return output string
     */
    public String print() {
        String out = "The DLList contains: \n";
		DLLNode ref = head;
		if(head == null)
			return out + "0 nodes.";
		else
			out += "head -->\t";
		
		while(ref != tail) 
		{
			out += ref.getElement() + "\t<-->\t";
			ref = ref.getNext();
		}
		out += ref.getElement() + "\t<-- tail";
		return out;
    }

    /**
     * remove given node from list
     * @param node to be removed
     */
    public void remove(DLLNode node) {
        //if list is empty, exit
        if(head == null)
        {
            return;
        }
        //if head is node to remove, remove node and exit
        if(head.getElement() == node.getElement())
        {
            if(head == tail)
            {
                head = tail = null;
            }
            else
            {
                head = head.getNext();
                head.setPrev(null);
            }
            return;
        }

        //search through list for node to remove
        DLLNode temp = head.getNext();
        while(temp != tail) {
            if(temp.getElement() == node.getElement())
            {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                return;
            }
            temp = temp.getNext();
        }

        //if node not found in head or list, check tail
        if(tail.getElement() == node .getElement())
        {
            tail = tail.getPrev();
            tail.setNext(null);
        }        
    }

    /**
     * insert node after header
     * @param node to enter
     */
    public void addAfterHead(DLLNode node){
        if(head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            node.setPrev(head);
            node.setNext(head.getNext());
            head.getNext().setPrev(node);
            head.setNext(node);            
        }
    }

    public void addBeforeTail(DLLNode node) {
        if(head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
           node.setNext(tail);
           node.setPrev(tail.getPrev());
           tail.getPrev().setNext(node);
           tail.setPrev(node);
        }
    }

    /**
     * method to reverse the order of the doubly linked list
     */
    public void reverse() {
        DLLNode temp = head;
        head = tail;
        tail = temp;
        DLLNode p = head;

        while (p != null)
        { 
            temp = p.getNext();
            p.setNext(p.getPrev());
            p.setPrev(temp);
            p = p.getNext();
        }
    }

    /**
     * check to see if list contains given element
     * @param element to search for
     * @return true if element found in list
     */
    public boolean search(Object element) {
        if(head == null) 
        {            
            return false;
        }
       if(head.getElement() == element) 
       {
           return true;
       }
       DLLNode ref = head;
       while(ref.getNext() != null) {
           if(ref.getNext().getElement() == element) 
           {
               return true;
           }
           ref = ref.getNext();
       }
       return false;
    }

    /**
     * get index of element given
     * @param element to find index of
     * @return index position of element or -1 if not found
     */
    public int getIndex(Object element) {
        int index = 0;
        DLLNode node = head;

        while(node !=null) {
            if(node.getElement().equals(element)) 
            {
                return index;
            }
            index++;
            node = node.getNext();
        }
        return -1;
    }

    /**
     * add node at given index
     * @param element to insert
     * @param index position in list to add node
     */
    public void addAtIndex(Object element, int index) {
        DLLNode temp = new DLLNode(element, null, null);
        DLLNode current = head;
        if(index == 0) {
            temp.setNext(head);
            head.setPrev(temp);
            this.head = temp;
        }
        else {
            for(int i =1;i < index;i++) {
                current = current.getNext();
            }
            temp.setNext(current);
            temp.setPrev(current.getPrev());
            current.getPrev().setNext(temp);
            current.setPrev(temp);
        }  
    }

    /**
     * remove node at given index
     * @param index the position in the list to remove node
     */
    public void removeAtIndex(int index) {
        DLLNode current = head;
        if(index ==0) {
            head = head.getNext();
            head.setPrev(null);
        }
        else {
            for(int i =1;i < index;i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            current.setPrev(current.getPrev().getPrev());
        }
    }    
}
