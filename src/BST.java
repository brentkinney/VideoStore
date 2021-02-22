public class BST {
    public BSTNode root;

    /**
     * default constructor
     */
    public BST() {
        root = null;
    }

    /**
     * add element to the tree
     * @param obj is the element to add
     */
    public void add(Object obj) {
        BSTNode node = new BSTNode(obj);
        if(root == null) 
        {
            root = node;
        }
        else
        {
            BSTNode current = root;
            while(current.getRight() != null) {
                current = current.getRight();
            }
            current.setRight(node);
        }
    }
}
