public class DLLNode {
    private Object element;
    private DLLNode next;
    private DLLNode prev;

    /**
     * default constructor
     * @param obj the element to set
     * @param n the ref to the next node
     * @param p the ref to the prev node
     */
    public DLLNode(Object obj, DLLNode n, DLLNode p) {
        element = obj;
        next = n;
        prev = p;
    }

    /**
     * get element of current node
     * @return element of node
     */
    public Object getElement() {
        return element;
    }

    /**
     * set element of node
     * @param obj to set new element too
     */
    public void setElement(Object obj) {
        element = obj;
    }

    /**
     * get ref to next node
     * @return next node
     */
    public DLLNode getNext() {
        return next;
    }

    /**
     * set ref to next node
     * @param node to set as next
     */
    public void setNext(DLLNode node) {
        next = node;
    }

    /**
     * get ref to prev node
     * @return prev node
     */
    public DLLNode getPrev() {
        return prev;
    }

    /**
     * set ref to prev node
     * @param node to set as prev
     */
    public void setPrev(DLLNode node) {
        prev = node;
    }
}
