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
}
