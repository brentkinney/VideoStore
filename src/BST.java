import javax.lang.model.util.ElementScanner6;

public class BST {
    public BSTNode root;

    /**
     * default constructor
     */
    public BST() {
        root = null;
    }

    /**
     * get root of tree
     * @return root node
     */
    public BSTNode getRoot() {
        return root;
    }

    private BSTNode addRecursive(BSTNode current, Object element) {
        if (current == null) {
            return new BSTNode(element);
        }
        if (element < current.getElement()) {
            current.setLeft(addRecursive(current.getLeft(), element));
        }
        else if (element > current.getElement()) {
            current.setRight(addRecursive(current.getRight(), element));
        }
        else
        {
            return current;
        }
        return current;
    }
}
