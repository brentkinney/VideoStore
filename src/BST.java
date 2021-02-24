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
	 * Insert the newItem as the element value into the tree.
	 * @param newItem	The element value to be inserted.
	 */
	public void insert(Object newItem)
	{
		root = insertHelper(root, new BSTNode(newItem));
	}
	/*
	 * The helper method for the insert().
	 * @param	rt	The root of current subtree.
	 * @param	newNode	The new node contain the newItem to be inserted.
	 * @return	The root of the subtree.
	 */
	private BSTNode insertHelper(BSTNode rt, 
					BSTNode newNode)
	{
		if (rt == null)
		{
			rt = newNode;
			return rt;
		}
		
		if (newNode.compareTo(rt) < 0)
		{
			rt.left = insertHelper(rt.left, newNode);
		}
		else
		{
			rt.right = insertHelper(rt.right, newNode);
		}
		return rt;
	}
	
	/**
	 * Find the maximum element value in the tree nodes.
	 * @return	The maximum element value.
	 */
	public Object max()
	{
		if (root == null)
			return null;
		
		return maxHelper(root).element;
	}
	/*
	 * The helper method for max().
	 * @param	The root of the current subtree.
	 * @return	The tree node contains the maximum element value.
	 */
	private BSTNode maxHelper(BSTNode rt)
	{
		return (rt.right == null) ? rt : maxHelper(rt.right);
	}
	
	/**
	 * Find the minimum element value in the tree nodes.
	 * @return	The minimum element value.
	 */
	public Object min()
	{
		if (root == null)
			return null;
		
		return minHelper(root).element;
	}
	/*
	 * The helper method for min().
	 * @param	The root of the current subtree.
	 * @return	The tree node contains the minimum element value.
	 */
	private BSTNode minHelper(BSTNode rt)
	{
		return (rt.left == null) ? rt : minHelper(rt.left);
	}
	
	/**
	 * Find the tree node contains the same element value as the target.
	 * @param target	The target element value to be compared to.
	 * @return			The tree node contains the element value.
	 */
	public BSTNode find(Object target)
	{
		return findHelper(root, new BSTNode(target));
	}
	/*
	 * The helper method for find().
	 * @param	rt	The root of the current subtree.
	 * @param	target	A tree node contains the target value.
	 * @return	The tree node contains the same value as the target node.
	 */
	private BSTNode findHelper(BSTNode rt, 
					BSTNode targetNode)
	{
		if (rt == null)
			return null;
		
		if (targetNode.compareTo(rt) < 0)
			return findHelper(rt.left, targetNode);
		
		if (targetNode.compareTo(rt) > 0)
			return findHelper(rt.right, targetNode);
		
		return rt;
	}
	
	/**
	 * Remove a tree node contains the same element value as the target.
	 * Update the tree structure so that it maintains BST property.
	 * To update is using a successor to replace the node being removed. 
	 * @param target	The target element value to be compared to.
	 */
	public void remove(Object target)
	{
		if (root == null)
			return;
		
		BSTNode targetNode = new BSTNode(target);
		if (root.compareTo(targetNode) == 0)
		{//The root node is the node to be removed.
			BSTNode sp1 = successorParent(root);
			
			if(sp1 == null && root != null)
			{//The root node has no right child.
				root = root.left;
			}
			else if (sp1 == root)
			{//The right child is the successor. It must have no left child.
				sp1.right.left = root.left;
				root = root.right;
			}
			else
			{//The successor must be the left child of successor parent.
				BSTNode rightChildOfsucc = sp1.left.right;
				sp1.left.left = root.left;
				sp1.left.right = root.right;
				root = sp1.left;
				sp1.left = rightChildOfsucc;
			}
			return;
		}
		
		//The root node is not the node to be removed.
		BSTNode targetParent = findParent(root, targetNode);
		if(targetParent == null)
		{
			return;
		}
	
		if(targetParent.left != null)
		{
			if (targetParent.left.compareTo(targetNode) == 0)
			{//The left child of targetParent is the node to be removed.
				BSTNode rNode = targetParent.left;
				BSTNode sp2 = successorParent(rNode);
				
				if(rNode.left == null && rNode.right == null)
				{
					targetParent.left = null;
					return;
				}
				else if (sp2 == null && rNode != null)
				{//The target node has no right child.
					targetParent.left = rNode.left;
				}
				else if (sp2 == rNode)
				{//The right child is the successor. 
				 //It must have no left child.
					sp2.right.left = rNode.left;
					targetParent.left = rNode.right;
				}
				else
				{//The successor must be the left child of successor parent.
					BSTNode rightChildOfsucc = sp2.left.right;
					sp2.left.left = rNode.left;
					sp2.left.right = rNode.right;
					targetParent.left = sp2.left;
					sp2.left = rightChildOfsucc;
				}
				
				return;
			}
		}
		
		if(targetParent.right != null)
		{
			if (targetParent.right.compareTo(targetNode) == 0)
			{//The right child of targetParent is the node to be removed.
				BSTNode rNode = targetParent.right;
				BSTNode sp3 = successorParent(rNode);
				
				if(rNode.left == null && rNode.right == null)
				{
					targetParent.right = null;
					return;
				}
				else if (sp3 == null && rNode != null)
				{//The target node has no right child.
					targetParent.right = rNode.left;
				}
				else if (sp3 == rNode)
				{//The right child is the successor. 
				 //It must have no left child.
					sp3.right.left = rNode.left;
					targetParent.right = rNode.right;
				}
				else
				{//The successor must be the left child of successor parent.
					BSTNode rightChildOfsucc = sp3.left.right;
					sp3.left.left = rNode.left;
					sp3.left.right = rNode.right;
					targetParent.right = sp3.left;
					sp3.left = rightChildOfsucc;
				}
				
				return;
			}
		}
	}
	/*
	 * Private helper method to be used in remove.
	 * Finds the parent node of a node contains the value as the targetNode.
	 * @param	rt	The root of the current subtree.
	 * @param	targetNode	The target node to be compared to.
	 * @return	The parent node of the node  
	 * 			contains the same value as the target node.
	 */
	private BSTNode findParent(BSTNode rt, 
					BSTNode targetNode)
	{
		if (targetNode.compareTo(rt) < 0)
		{
			if (rt.left == null)
			{
				return null;
			}
			else if(targetNode.compareTo(rt.left) == 0)
			{
				return rt;
			}
			else
			{
				return findParent(rt.left, targetNode);
			}
		}
		else
		{
			if (rt.right == null)
			{
				return null;
			}
			else if(targetNode.compareTo(rt.right) == 0)
			{
				return rt;
			}
			else
			{
				return findParent(rt.right, targetNode);
			}
		}
	}
	/*
	 * Private helper method to be used in remove.
	 * Finds the parent node of the successor node in the subtree.
	 * @param	The root of the current subtree.
	 * @return	The parent node of the successor node of 
	 * 			a subtree rooted at rt.
	 * 			null, if no successor node exists.
	 */
	private BSTNode successorParent(BSTNode rt)
	{
		if (rt == null)
			return null;
		
		if (rt.right == null)
			return null;
		
		if (rt.right.left == null)
			return rt;
		
		BSTNode temp = rt.right;
		while (temp.left.left != null)
		{
			temp = temp.left;
		}
		return temp;
	}
    
    /**
	 * Remove all the tree nodes.
	 */
	public void clear()
	{
		root = null;
	}
	
	/**
	 * Check whether the tree is empty.
	 * @return	true if the tree contains no nodes, false otherwise.
	 */
	public boolean isEmpty()
	{
		return root == null;
	}
	
	/**
	 * Get the number of nodes in the tree.
	 * @return	The number of nodes in the tree.
	 */
	public int size()
	{
		return sizeHelper(root);
	}
	/*
	 * The private helper method for size().
	 * Get the number of nodes in the tree rooted at r.
	 * @param	rt	The current root of the tree.
	 * @return		The number of nodes in the tree.
	 */
	private int sizeHelper(BSTNode rt)
	{
		if (rt == null)
			return 0;
		
		return sizeHelper(rt.left) + sizeHelper(rt.right) + 1;
	}
	
	/**
	 * Get the height of the tree.
	 * @return		The height of the tree.
	 */
	public int height()
	{
		return heightHelper(root, -1);
	}
	/*
	 * The private helper method for height().
	 * Get the height of the subtree rooted at rt.
	 * @param rt	The current root.
	 * @param ht	The current height.
	 * @return		The height of the tree.
	 */
	private int heightHelper(BSTNode rt, int ht)
	{
		if (rt == null)
			return ht;
		
		return Math.max(heightHelper(rt.left, ht+1), 
						heightHelper(rt.right, ht+1));
	}
	
	/**
	 * Preorder traverse the tree and print out each node.
	 */
	public String preorderTraversal()
	{
		preorderHelper(root);
		System.out.println();
		return "";
	}
	/*
	 * The private helper method for preorderTraversal().
	 */
	private void preorderHelper(BSTNode rt)
	{
		if(rt == null)	return;

		System.out.print("\t" + rt.element);
		preorderHelper(rt.left);
		preorderHelper(rt.right);
	}
	
	/**
	 * Inorder traverse the tree and print out each node.
	 */
	public String inorderTraversal()
	{
		inorderHelper(root);
		System.out.println();
		return "";
	}	
	/*
	 * The private helper method for inorderTraversal().
	 */
	private void inorderHelper(BSTNode rt)
	{
		if(rt == null)	return;
		
		inorderHelper(rt.left);
		System.out.print("\t" + rt.element);
		inorderHelper(rt.right);
	}
	
	/**
	 * Postorder traverse the tree and print out each node.
	 */
	public String postorderTraversal()
	{
		postorderHelper(root);
		System.out.println();
		return "";
	}
	/*
	 * The private helper method for postorderTraversal().
	 */
	private void postorderHelper(BSTNode rt)
	{
		if(rt == null)	return;
		
		postorderHelper(rt.left);
		postorderHelper(rt.right);
		System.out.print("\t" + rt.element);
	}
}
