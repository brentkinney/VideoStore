public class AVLNode {
    private int id;
    private Object element;
    private AVLNode left;
    private AVLNode right;
    private int height;
    
    
    /**
     *default constructor
     @param num id of node
     @param obj to set as node element
     */
    public AVLNode(int num, Object obj) {
        id = num;
        element = obj;
        left = null;
        right = null;
        height = 1;
    }

    /**
     * get id of node
     * @return id of node
     */
    public int getId() {
        return id;
    }
    
    /**
     * set id of node
     * @param num new id to give
     */
    public void setId(int num) {
        id = num;
    }

    /**
     * get element of node
     * @return element of node
     */
    public Object getElement() {
        return element;
    }
    
    /**
     * set element of node
     * @param obj to become new element
     */
    public void setElement(Object obj) {
        element = obj;
    }

    /**
     * get left child node
     * @return left node
     */
    public AVLNode getLeft() {
        return (AVLNode) left;
    }

    /**
     * get right child node
     * @return right node
     */
    public AVLNode getRight() {
        return (AVLNode) right;
    }
  
    
    /**
     * set left child node
     * @param n node to become left
     */
    public void setLeft(AVLNode n) {
        left = n;
    }
    
    /**
     * set right child node
     * @param n node to become right
     */
    public void setRight(AVLNode n) {
        right = n;
    }
    
    /**
     * get height of node
     * @return height
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * set height
     * @param num new height
     */
    public void setHeight(int num) {
        height = num;
    } 
}
