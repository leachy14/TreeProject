/**
 * 
 */

/**
 * @author Professor Bamford
 *
 */
public class BinarySearchTreeNode<T extends Comparable<T>> 
{
	//Used to hold references to Binary Search Tree nodes for the linked implementation
	protected T info;  //The info in a Binary Search Tree node
	protected BinarySearchTreeNode<T> left;		//A link to the left child node
	protected BinarySearchTreeNode<T> right;	//A link to the right child node
	
	public BinarySearchTreeNode(T info)
	{
		this.info = info;
		left = null;
		right = null;
	}
	
	
	/*
	 * Sets info of this Binary Search Node
	 */
	public void setInfo(T info)
	{
		this.info = info;
	}
	
	/*
	 * @return - returns info of this Binary Search Node
	 */
	public T getInfo()
	{
		return info;
	}
	
	/*
	 * Sets left link of this Binary Search Tree Node
	 */
	public void setLeft(BinarySearchTreeNode<T> link)
	{
		left = link;
	}
	
	/*
	 * Sets right link of this Binary Search Tree Node
	 */
	public void setRight(BinarySearchTreeNode<T> link)
	{
		right = link;
	}
	
	/*
	 * @return - returns left link of this Binary Search Tree Node
	 */
	public BinarySearchTreeNode<T> getLeft()
	{
		return left;
	}
	
	/*
	 * @return - returns right link of this Binary Search Tree Node
	 */
	public BinarySearchTreeNode<T> getRight()
	{
		return right;
	}
	
	
	public void addNode(BinarySearchTreeNode<T> newNode)
	{
		int comp = newNode.info.compareTo(info);
		if(comp < 0)
		{
			if(left == null)
				left = newNode;
			else
				left.addNode(newNode);
		}
		if(comp > 0)
		{
			if(right == null)
				right = newNode;
			else
				right.addNode(newNode);
		}

	}

	public void addNode(BinarySearchTreeNode<T> newNode, int first, String code)
	{
		char start = code.charAt(first);
		if(start == '.')
		{
			if(left == null)
				left = newNode;
			else
				left.addNode(newNode, first+1, code);
		}
		if(start == '-')
		{
			if(right == null)
				right = newNode;
			else
				right.addNode(newNode, first+1, code);
		}

	}
	
	public boolean hasLeft()
	{
		return left != null;
	}
	
	public boolean hasRight()
	{
		return right != null;
	}
	
	public boolean isLeaf()
	{
		return (left == null) && (right == null);
	}
	
	/*
	 * Prints this node and all of its descendants in sorted order
	 */	
	public void printNodes()
	{
		if(left != null)
			left.printNodes();
		System.out.print(info + " ");
		if(right != null)
			right.printNodes();
	}
}