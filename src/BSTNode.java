public class BSTNode  {
    private int id;
	public Object element;
    public BSTNode left;
    public BSTNode right;

    /**
     * default contstructor
     * @param obj the element of node
     */
    public BSTNode (int num, Object obj) {
        id = num;
		element = obj;
        left = null;
        right = null;
    }

	/**
	 * get id of node
	 * @return node id
	 */
	public int getId() {
		return id;
	}

	/**
	 * get element of tree node
	 * @return element of node
	 */
    public Object getElement() {
		return element;
	}

	/**
	 * get node at left ref
	 * @return left node
	 */
	public BSTNode getLeft() {
		return left;
	}

	/**
	 * get node at right ref
	 * @return right node
	 */
	public BSTNode getRight() {
		return right;
	}

	/**
	 * set id of node
	 * @param num id
	 */
	public void setId(int num) {
		id = num;
	}

	/**
	 * set element of tree node
	 * @param obj to set as new element
	 */
	public void setElement(Object obj) {
		element = obj;
	}

	/**
	 * set ref to left node to given node
	 * @param l node to become new left ref
	 */
	public void setLeft(BSTNode l) {
		left = l;
	}

	/**
	 * set ref to right node to given node
	 * @param r node to become new right node
	 */
	public void setRight(BSTNode r) {
		right = r;
	}  
}
