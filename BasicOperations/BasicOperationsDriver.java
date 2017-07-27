package BasicOperations;

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
		BSTViews.displayTreeDFS(root);
		BinarySearchNode nodeToRemove = BinarySearchNode.searchNode(root, 16);
		System.out.println("\nRemoval node details "+nodeToRemove.left.val+" "+nodeToRemove.right.val);
		BinarySearchNode.removeNode(nodeToRemove);
		BSTViews.displayTreeDFS(root);
		System.out.println("\nHeight is "+BinarySearchNode.getTreeHeight(root));
		BSTViews.displayTreeBFS(root);
	}
}
