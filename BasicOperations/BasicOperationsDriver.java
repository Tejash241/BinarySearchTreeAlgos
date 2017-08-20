package BasicOperations;

import java.util.ArrayList;
import java.util.Arrays;

class BasicOperationsDriver {
	public static void main(String[] args) {
		BinarySearchNode root = new BinarySearchNode(null, 10);
		BinarySearchNode.addNode(root, 5);
		BinarySearchNode.addNode(root, 14);
		BinarySearchNode.addNode(root, 4);
		BinarySearchNode.addNode(root, 7);
		BinarySearchNode.addNode(root, 12);
		BinarySearchNode.addNode(root, 16);
		BinarySearchNode.addNode(root, 15);
		BinarySearchNode.addNode(root, 11);
		BinarySearchNode.addNode(root, 13);
		BinarySearchNode.addNode(root, 19);
		BinarySearchNode.addNode(root, 18);
		BinarySearchNode.addNode(root, 20);
		System.out.println("DFS view...");
		BSTViews.displayTreeDFS(root);
		BinarySearchNode nodeToRemove = BinarySearchNode.searchNode(root, 16);
		System.out.println("\nRemoval node details "+nodeToRemove.left.val+" "+nodeToRemove.right.val);
		BinarySearchNode.removeNode(nodeToRemove);
		System.out.println("DFS view...");
		BSTViews.displayTreeDFS(root);
		System.out.print("\nHeight is "+BinarySearchNode.getTreeHeight(root));
		BSTViews.displayTreeBFS(root);
		ArrayList<Integer> inOrder = BSTTraversers.inOrderTraversal(root);
		System.out.println("\nInorder Traversal is: "+Arrays.toString(inOrder.toArray()));
		ArrayList<Integer> preOrder = BSTTraversers.preOrderTraversal(root);
		System.out.println("\nPreorder Traversal is: "+Arrays.toString(preOrder.toArray()));
		ArrayList<Integer> postOrder = BSTTraversers.postOrderTraversal(root);
		System.out.println("\nPostorder Traversal is: "+Arrays.toString(postOrder.toArray()));
		System.out.println("\nHeight Balancing the tree...");
		BinarySearchNode newRoot = TreeBalancers.heightBalanceTree(root);
		BSTViews.displayTreeBFS(newRoot);
	}
}
