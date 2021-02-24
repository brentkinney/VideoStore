public class BST {
    public BSTNode root;

    /**
	 * Default Constructor
	 */
	public BST()
	{
		root = null;
	}

	/**
	 * get root of tree
	 * @return root node
	 */
	public BSTNode getRoot() {
		return root;
	}
	
	
	/**
	 * get node with given id
	 * @param id of node to find
	 * @return true if found and false if not found
	 */
    public boolean find(int id) {
        BSTNode current = root;        
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
	 * get element of node with given id
	 * @param id of node to get element of
	 * @return element of found node or null if not found
	 */
    public Object getElement(int id) {
        BSTNode current = root;       
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
	 * remove node with the given id
	 * @param id of node to be removed
	 * @return element of removed node
	 */
    public Object remove(int id) {
        BSTNode parent = root;
        BSTNode current = root;
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
        
        //if node to be removed has no children
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
        
        //if node to be removed has only one child
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
            BSTNode successor = getSuccessor(current);
            
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
	 * get successor of given node
	 * @param n to find sucessor of
	 * @return found node
	 */
    public BSTNode getSuccessor(BSTNode n) {
        BSTNode successor = null;
        BSTNode successorParent = null;
        BSTNode current = n.getRight();
        
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
	 * insert node with given id and element
	 * @param id of the node
	 * @param element of the node
	 */
    public void insert(int id, Object element) {
        BSTNode n = new BSTNode(id, element);
        
        if(root == null) {
            root = n;
            return;
        }        
        
        BSTNode current = root;
        BSTNode parent;
        
        while(true) {
            parent = current;
            
            if(id < current.getId()) {
                current = current.getLeft();
                
                if(current == null) {
                    parent.setLeft(n);
                    return;
                }
            } else {
                current = current.getRight();
                
                if(current == null) {
                    parent.setRight(n);
                    return;
                }
            }
        }
    }
    
    /**
	 * print the nodes in the tree
	 * @param n root of tree
	 */
    public void print(BSTNode n) {
        if(n != null) {
            print(n.getLeft());
            System.out.print(n.getElement() + "\n");
            print(n.getRight());
        }
    }
}
