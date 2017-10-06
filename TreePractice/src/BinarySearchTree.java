/**
 * Binary Tree practice problems
 * 
 * @author Matt Boutell and <<<YOUR NAME HERE>>>. 2014.
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
		// DONE: 1 Write this.
		return countPositivesHelper(this.root);
	}

	private int countPositivesHelper(BinarySearchTree<T>.BinaryNode node) {
		// DONE Auto-generated method stub.
		if(node == NULL_NODE || node.element==null){
			return 0;
		}
		if(node.left == NULL_NODE && node.right == NULL_NODE){
			if((int)node.element>=1	){
				return 1;
			}
		}
		if(node.right!=NULL_NODE && node.left!=NULL_NODE){
			if((int)node.element>=1){
				return 1 + countPositivesHelper(node.left) + countPositivesHelper(node.right);
			}
		}
		if(node.right==NULL_NODE){
			if((int)node.element>=1){
				return 1+ countPositivesHelper(node.left);
			}
		}
		if(node.left==NULL_NODE){
			if((int)node.element>=1){
				return 1+ countPositivesHelper(node.right);
			}
		}
		return countPositivesHelper(node.right) + countPositivesHelper(node.left);
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
		// DONE: 2 Write this.
		return getDepthHelper(item, this.root,0);
	}

	private int getDepthHelper(T item, BinarySearchTree<T>.BinaryNode node, int height) {
		// DONE Auto-generated method stub.
		if(node == NULL_NODE || node.element == null){
			return -1;
		}
		if(node.element.compareTo(item)==0){
			return 0;
		}
		if(node.element.compareTo(item)<0){
			if(node.right==NULL_NODE && node.element.compareTo(item)!=0){
				return -height-1;
			}
			return 1 + getDepthHelper(item, node.right,height+1);
		}
		if(node.element.compareTo(item)>0){
			if(node.left==NULL_NODE && node.element.compareTo(item)!=0){
				return -height-1;
			}
			return 1 + getDepthHelper(item, node.left,height+1);
		}
		return 0;
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
		// DONE: 3 Write this.
		return numChildrenOfEachNodeHelper(this.root);
	}

	private String numChildrenOfEachNodeHelper(BinarySearchTree<T>.BinaryNode node) {
		// DONE Auto-generated method stub.
		if(node==NULL_NODE){
			return"";
		}
		if(node.right != NULL_NODE && node.left !=NULL_NODE){
			return "2" + numChildrenOfEachNodeHelper(node.left) + numChildrenOfEachNodeHelper(node.right);
		}
		if(node.right == NULL_NODE && node.left != NULL_NODE){
			return "1" + numChildrenOfEachNodeHelper(node.left);
		}
		if(node.left == NULL_NODE && node.right != NULL_NODE){
			return "1" + numChildrenOfEachNodeHelper(node.right);
		}
		if(node.right==NULL_NODE && node.left==NULL_NODE){
			return "0";
		}
		return "";
	}

	/**
	 * This method determines if a BST forms a zig-zag pattern. By this we mean
	 * that each node has exactly one child, except for the leaf. In addition,
	 * the nodes alternate between being a left and a right child. An empty tree
	 * or a tree consisting of just the root are both said to form a zigzag
	 * pattern. For example, if you insert the elements 10, 5, 9, 6, 7 into a
	 * BST in that order. , you will get a zig-zag.
	 * 
	 */
	public boolean isZigZag() {
		// Done: 4 Write this.
		String str = isZigZagHelper(this.root);
		boolean isR = false;
		boolean isTrue = false;
		if(str.length()<=2){
			return true;
		}
		if(str.charAt(0)=='2'){
			return false;
		}
		char temp = str.charAt(0);
		return isZigZagChecker(str.substring(1,str.length()),temp);
	}
	
	

	private boolean isZigZagChecker(String str,char prev) {
		if(str.length()==0){
			return true;
		}
		if(str.charAt(0)=='2'){
			return false;
		}
		if(str.charAt(0)==prev){
			return false;
		}
		char previous = str.charAt(0);
		return isZigZagChecker(str.substring(1, str.length()),previous);
	}

	private String isZigZagHelper(BinarySearchTree<T>.BinaryNode node) {
		// DONE Auto-generated method stub.
		if(node==NULL_NODE){
			return"";
		}
		if(node.right != NULL_NODE && node.left !=NULL_NODE){
			return "2" + isZigZagHelper(node.left) + isZigZagHelper(node.right);
		}
		if(node.right == NULL_NODE && node.left != NULL_NODE){
			return "L" + isZigZagHelper(node.left);
		}
		if(node.left == NULL_NODE && node.right != NULL_NODE){
			return "R" + isZigZagHelper(node.right);
		}
		if(node.right==NULL_NODE && node.left==NULL_NODE){
			return "0";
		}
		return "";
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