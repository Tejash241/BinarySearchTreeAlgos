package BasicOperations;

import java.util.ArrayList;

public class BSTTraversers {

	/** In-order traversal is Root-Left-RIght. This also returns non-descending order of tree node values. Executes in O(n)
	 * @param root
	 * @return ArrayList of in-ordered values
	 */
	public static ArrayList<Integer> inOrderTraversal(BinarySearchNode root){
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		if(root!=null) {
			if(root.left!=null) {
				inOrder.addAll(inOrderTraversal(root.left));
			}
			inOrder.add(root.val);
			if(root.right!=null) {
				inOrder.addAll(inOrderTraversal(root.right));
			}
		}
		return inOrder;
	}
	/** Pre-order traversal is Root-Left-Right. Executes in O(n).
	 * @param root
	 * @return ArrayList of pre-ordered values
	 */
	public static ArrayList<Integer> preOrderTraversal(BinarySearchNode root){
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		if(root!=null) {
			preOrder.add(root.val);
			if(root.left!=null) {
				preOrder.addAll(preOrderTraversal(root.left));
			}
			if(root.right!=null) {
				preOrder.addAll(preOrderTraversal(root.right));
			}
		}
		return preOrder;
	}
	/** Post-order traversal is Left-Right-Root. Executes in O(n)
	 * @param root
	 * @return ArrayList of post-ordered values
	 */
	public static ArrayList<Integer> postOrderTraversal(BinarySearchNode root){
		ArrayList<Integer> postOrder = new ArrayList<Integer>();
		if(root!=null) {
			if(root.left!=null) {
				postOrder.addAll(postOrderTraversal(root.left));
			}
			if(root.right!=null) {
				postOrder.addAll(postOrderTraversal(root.right));
			}
			postOrder.add(root.val);
		}
		return postOrder;
	}
}
