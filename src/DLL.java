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
}
