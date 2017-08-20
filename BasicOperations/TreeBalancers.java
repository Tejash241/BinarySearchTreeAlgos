package BasicOperations;

import java.util.ArrayList;

public class TreeBalancers {
	/** Driver method to height-balance a BST. It initializes a few required variables and then calls balanceSubArray
	 * Executes in O(n)
	 * @param root
	 * @return root of a new height-balanced tree guaranteed to have minimum height
	 */
	public static BinarySearchNode heightBalanceTree(BinarySearchNode root) {
		ArrayList<Integer> inOrder = BSTTraversers.inOrderTraversal(root);
		return balanceSubArray(inOrder, 0, inOrder.size()-1, null);
	}
	
	/** Arranges an array of size n into a BST of height O(log n)
	 * Executes in O(n)
	 * @param inOrder - inOrder traversal list of the tree
	 * @param lo - start index of the subarray to be considered 
	 * @param hi - end index of the subarray to be considered
	 * @param parent - node formed by the calling method
	 * @return root of new height-balanced tree
	 */
	public static BinarySearchNode balanceSubArray(ArrayList<Integer> inOrder, int lo, int hi, BinarySearchNode parent) {
		if(hi-lo==1) {
			BinarySearchNode newNode = new BinarySearchNode(parent, (int)inOrder.get(lo));
			BinarySearchNode newNode1 = new BinarySearchNode(newNode, (int)inOrder.get(hi));
			newNode.right = newNode1;
			return newNode;
		}
		else if(hi-lo==0) {
			return new BinarySearchNode(parent, (int)inOrder.get(lo));
		}
		int mid = hi-(int)((hi-lo)/2);
		BinarySearchNode newNode = new BinarySearchNode(parent, (int)inOrder.get(mid));
		newNode.left = balanceSubArray(inOrder, lo, mid-1, newNode);
		newNode.right = balanceSubArray(inOrder, mid+1, hi, newNode);
		return newNode;
	}
}
