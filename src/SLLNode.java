public class SLLNode {
    private Object element;//The element which will be stored in the List
    private SLLNode next;//Next node pointer
    
    public SLLNode(Object obj, SLLNode n) {
        element = obj;//object taken in when the node is created
        next = n;//the next element after initial
    }
    
    public Object getElement() {
        return element;//return the element at current spot
    }
    
    public SLLNode getNext() {
        return next;//return the next element from current spot
    }
    
    public void setElement(Object obj) {
        element = obj;//set the element based on input
    }
    
    public void setNext(SLLNode n) {
        next = n;//setting the next node to input
    }
}
