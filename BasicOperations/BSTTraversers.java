package BasicOperations;

import java.util.ArrayList;

public class BSTTraversers {

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
