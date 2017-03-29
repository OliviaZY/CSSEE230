/**
 * Binary Tree practice problems
 * 
 * @author Matt Boutell and <<<Olivia Zhou>>>. 2014.
 * @param <T>
 */

/*
 * TODO: 0 You are to implement the four methods below. I took most of them from
 * a CSSE230 exam given in a prior term. These can all be solved by recursion -
 * I encourage you to do so too, since most students find practicing recursion
 * to be more useful.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

	private BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	/**
	 * This method counts the number of occurrences of positive Integers in the
	 * tree that is of type Integer. Hint: You may assume this tree contains
	 * integers, so may use a cast.
	 * 
	 * @return The number of positive integers in the tree.
	 */

	public int countPositives() {
		return this.root.countPostives();
	}

	/**
	 * Recall that the depth of a node is number of edges in a path from this
	 * node to the root. Returns the depth of the given item in the tree. If the
	 * item isn't in the tree, then it returns -1.
	 * 
	 * @param item
	 * @return The depth, or -1 if it isn't in the tree.
	 */
	public int getDepth(T item) {
		if(this.root.contains(item) == false){
			return -1;
		}
		return this.root.getDepthHelper(item);
	}

	/**
	 * This method visits each node of the BST in pre-order and determines the
	 * number of children of each node. It produces a string of those numbers.
	 * If the tree is empty, an empty string is to be returned. For the
	 * following tree, the method returns the string: "2200110"
	 * 
	 * 10 5 15 2 7 18 10
	 * 
	 * @return A string representing the number of children of each node when
	 *         the nodes are visited in pre-order.
	 */

	public String numChildrenOfEachNode() {
		
		return this.root.numChildrenOfEachNodeHelper();
	}

	/**
	 * This method determines if a BST forms a zig-zag pattern. By this we mean
	 * that each node has exactly one child, except for the leaf. In addition,
	 * the nodes alternate between being a left and a right child. An empty tree
	 * or a tree consisting of just the root are both said to form a zigzag
	 * pattern. For example, if you insert the elements 10, 5, 9, 6, 7 into a
	 * BST in that order. , you will get a zig-zag.
	 * 
	 * @return True if the tree forms a zigzag and false otherwise.
	 */
	public boolean isZigZag() {
		
		return this.root.isZigZagHelper();
	}

	public void insert(T e) {
		root = root.insert(e);
	}

	// /////////////// BinaryNode
	public class BinaryNode {

		public T element;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(T element) {
			this.element = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		public boolean isZigZagHelper() {
			if(this == NULL_NODE){
				return true;
			}
			return false;
		}

		public String numChildrenOfEachNodeHelper() {
			if(this == NULL_NODE){
				return "";
			}if(this.left!=NULL_NODE&&this.right!=NULL_NODE){
				return "2"+this.left.numChildrenOfEachNodeHelper()+this.right.numChildrenOfEachNodeHelper();
			}else if(this.left== NULL_NODE && this.right == NULL_NODE){
				return "0";
			}else if(this.left!= NULL_NODE && this.right == NULL_NODE){
				return "1"+this.left.numChildrenOfEachNodeHelper();
			}else{
				return "1"+this.right.numChildrenOfEachNodeHelper();
			}
		}

		int count = 0;
		public int getDepthHelper(T item) {
			if(this == NULL_NODE){
				return 0;
			}
			if(this.element.equals(item)){
				return 0;
			}
			if(this.element.compareTo(item)<0){
				return 1+this.right.getDepthHelper(item);
			}
			return 1+this.left.getDepthHelper(item);
		}

		public boolean contains(T item) {
			if(this == NULL_NODE){
				return false;
			}
			if(this.element.equals(item)){
				return true;
			}
			return this.left.contains(item)|| this.right.contains(item);
		}

		public int countPostives() {
			if(this == NULL_NODE){
				return 0;
			}
			if((int)this.element>0){
				return 1+this.left.countPostives()+this.right.countPostives();
			}else{
				return this.right.countPostives();
			}
		}

		public BinaryNode insert(T e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e.compareTo(element) < 0) {
				left = left.insert(e);
			} else if (e.compareTo(element) > 0) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}
	}
}