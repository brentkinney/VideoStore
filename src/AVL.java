public class AVL {
    private AVLNode root;
    
	/**
     * get root of tree
     * @return tree root
     */
    public AVLNode getRoot() {
        return root;
    }
    /**
     * default constructor
     * @param n
     */
    public void setRoot(AVLNode n) {
        root = n;
    }
    
    /**
     * find item in tree
     * @param id of item to find
     * @return true if found or false if not found
     */
    public boolean find(int id) {
        AVLNode current = root;
        
        while(current != null) {
            if(current.getId() == id) {
                return true;
            } else if(current.getId() > id) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        
        return false;
    }
    
    /**
     * get element associated with node of given id
     * @param id of node to find
     * @return element of requested node
     */
    public Object getElement(int id) {
        AVLNode current = root;
        
        while(current != null) {
            if(current.getId() == id) {
                return current.getElement();
            } else if(current.getId() > id) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        
        return null;
    }
    
    
    /**
     * remove node from tree and rebalance if needed
     * @param id the node to remove
     * @return element of removed item
     */
    public Object remove(int id) {
        AVLNode parent = root;
        AVLNode current = root;
        boolean isLeftChild = false;
        Object element = null;
        
        while(current.getId() != id) {
            parent = current;
            
            if(current.getId() > id) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            
            if(current == null) {
                return element;
            }
        }
        element = current.getElement();
        
        //if node to be deleted has no children
        if(current.getLeft() == null && current.getRight() == null) {
            if(current == root) {
                root = null;
            }
            
            if(isLeftChild == true) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
        
        //if node to be deleted has only one child
        else if(current.getRight() == null) {
            if(current == root) {
                root = current.getLeft();
            } else if(isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if(current.getLeft() == null) {
            if(current == root) {
                root = current.getRight();
            } else if(isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else if(current.getLeft() != null && current.getRight() != null) {            
            AVLNode successor = getSuccessor(current);
            
            if(current == root) {
                root = successor;
            } else if(isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            
            successor.setLeft(current.getLeft());
        }
        
        return element;
    }
    
    
    /**
     * get children nodes of given node
     * @param n node to find children of
     * @return children node
     */
    public AVLNode getSuccessor(AVLNode n) {
        AVLNode successor = null;
        AVLNode successorParent = null;
        AVLNode current = n.getRight();
        
        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }        
        
        if(successor != n.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(n.getRight());
        }        
        return successor;
    }
    
    
    /**
     * check balance factor of tree
     * @param n node to check
     * @return factor of balance
     */
    public int balance(AVLNode n) {
        if(n != null) {
            return (getHeight(n.getLeft()) - getHeight(n.getRight()));
        }        
        return 0;
    }
    
    
    /**
     * get height of tree
     * @param n node to check from
     * @return height
     */
    public int getHeight(AVLNode n) {
        if(n != null) {
            return n.getHeight();
        }        
        return 0;
    }
    
    
    /**
     * rotate tree right for balancing
     * @param y node to balance from
     * @return node
     */
    public AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.getLeft();
        AVLNode T2 = x.getRight();
        
        //rotation
        x.setRight(y);
        y.setLeft(T2);
        
        //update heights
        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);
        
        return x;
    }
    
    
    /**
     * rotate tree left for balancing
     * @param x node to balance from
     * @return balanced node
     */
    public AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.getRight();
        AVLNode T2 = y.getLeft();
        
        //rotation
        y.setLeft(x);
        x.setRight(T2);
        
        //update heights
        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);
        
        return y;
    }
    
    
    /**
     * insert node into the tree
     * @param n node to insert
     * @param id id of node
     * @param obj element of node
     * @return inserted node
     */
    public AVLNode insert(AVLNode n, int id, Object obj) {
        if(n == null) {
            return new AVLNode(id, obj);
        }
        
        if(n.getId() > id) {
            n.setLeft(insert(n.getLeft(), id, obj));
        } else {
            n.setRight(insert(n.getRight(), id, obj));
        }
        
        //update the node height
        n.setHeight(Math.max(getHeight(n.getLeft()), getHeight(n.getRight())) + 1);
        
        int bal = balance(n);
        
        //left rotate
        if(bal > 1 && id < n.getLeft().getId()) {
            return rotateRight(n);
        }
        
        //right rotate
        if(bal < -1 && id > n.getRight().getId()) {
            return rotateLeft(n);
        }
        
        //left right rotate
        if(bal > 1 && id > n.getLeft().getId()) {
            n.setLeft(rotateLeft(n.getLeft()));
            return rotateRight(n);
        }
        
        //right left rotate
        if(bal < -1 && id < n.getRight().getId()) {
            n.setRight(rotateRight(n.getRight()));
            return rotateLeft(n);
        }
        
        return n;
    }
    
    
    /**
     * print nodes of the tree
     * @param n root of tree
     */
    public void print(AVLNode n) {
        if(n != null) {
            print(n.getLeft());
            System.out.print(n.getElement() + "\n");
            print(n.getRight());
        }
    }
}
