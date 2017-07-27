package BasicOperations;

public class BinarySearchNode {
	int val;
	BinarySearchNode left;
	BinarySearchNode right;
	BinarySearchNode parent;

	public BinarySearchNode(BinarySearchNode parent, int val) {
		this.val = val;
		this.parent = parent;
		this.left = null;
		this.right = null;
	}
	
	/** Adds a node to the Tree (assumes val is unique within the tree)
	 * @param root
	 * @param value of the new node
	 */
	public static void addNode(BinarySearchNode root, int val) {
		if(root.val<val) {
			if(root.right==null) {
				BinarySearchNode newNode = new BinarySearchNode(root, val);
				root.right = newNode;
			}
			else {
				addNode(root.right, val);
			}
		}
		else {
			if(root.left==null) {
				BinarySearchNode newNode = new BinarySearchNode(root, val);
				root.left = newNode;
			}
			else {
				addNode(root.left, val);
			}
		}
		
	}
	/** Removes the node in the BST with a given val
	 * @param root
	 * @param val
	 */
	public static void removeNode(BinarySearchNode node) {
		boolean isRightChild = isRightChild(node);
		if(node.left==null && node.right==null) { // case 1: both children are empty
			if(isRightChild) {
				node.parent.right = null;
			}
			else {
				node.parent.left = null;
			}
		}
		else if(node.left==null) { 		// case 2a: right child is empty
			if(isRightChild) {
				node.parent.right = node.right;
			}
			else {
				node.parent.left = node.right;
			}
		}
		else if(node.left==null){ // case 2b: left child is empty
			if(isRightChild) {
				node.parent.right = node.left;
			}
			else {
				node.parent.left = node.left;
			}
		}
		else { //case 3: none of the children are empty
			BinarySearchNode successor = getSuccessor(node);
			node.val = successor.val;
			removeNode(successor);
		}
	}
	
	/** Returns the node in the BST with the given value
	 * @param root
	 * @param value to search for
	 * @return A BinarySearchNode with given value
	 */
	public static BinarySearchNode searchNode(BinarySearchNode root, int val) {
		if(root.val==val) {
			return root;
		}
		else if(root.val>val) {
			return root.left==null?null:searchNode(root.left, val);
		}
		else {
			return root.right==null?null:searchNode(root.right, val);
		}
	}
	
	/** Returns the successor of a given node. A successor is a node with the least value that greater than the given node
	 * @param node
	 * @return successor
	 */
	public static BinarySearchNode getSuccessor(BinarySearchNode node) {
		BinarySearchNode successor = node.right;
		while(successor.left!=null) {
			successor = successor.left;
		}
		return successor;
	}
	
	/** Returns the predecessor of a given node. A predecessor is a node with the largest value less than the given node
	 * @param node
	 * @return predecessor
	 */
	public static BinarySearchNode getPredecessor(BinarySearchNode node) {
		BinarySearchNode predecessor = node.left;
		while(predecessor.right==null) {
			predecessor = predecessor.right;
		}
		return predecessor;
	}
	
	/** Returns whether the given node is a right child or a left
	 * @param node
	 * @return True if right child, else False
	 */
	public static boolean isRightChild(BinarySearchNode node) {
		return node.parent.right==node;
	}
	
	/** Returns whether the given tree is balances
	 * @param root
	 * @return True if balanced, else False
	 */
	public static boolean isTreeBalanced(BinarySearchNode root) {
		if(root.left!=null&&root.right!=null&&root.val<root.right.val&&root.val>root.left.val){
			return isTreeBalanced(root.left)&&isTreeBalanced(root.right);
		}
		else if(root.left!=null&&root.val>root.left.val) {
			return isTreeBalanced(root.left);
		}
		else if(root.right!=null&&root.val<root.right.val) {
			return isTreeBalanced(root.right);
		}
		else if(root.left==null&&root.right==null){
			return true;
		}
		else {
			return false;
		}
	}
	
	/** Returns the height of the tree (also called level) assuming root is height 1
	 * @param root
	 * @return height
	 */
	public static int getTreeHeight(BinarySearchNode root) {
		if(root.left!=null&&root.right!=null){
			return 1+Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
		}
		else if(root.left!=null) {
			return 1+getTreeHeight(root.left);
		}
		else if(root.right!=null) {
			return 1+getTreeHeight(root.right);
		}
		else {
			return 1;
		}
	}
}
