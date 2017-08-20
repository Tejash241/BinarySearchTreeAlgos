package BasicOperations;

import java.util.Arrays;

public class BSTViews {
	
	/** Prints a top-bottom DFS view of the tree (left first)
	 * Executes in O(n)
	 * @param root
	 */
	public static void displayTreeDFS(BinarySearchNode root) {
		System.out.print(root.val+" ");
		if(root.left!=null&&root.right!=null){
			displayTreeDFS(root.left);
			displayTreeDFS(root.right);
		}
		else if(root.left!=null) {
			displayTreeDFS(root.left);
		}
		else if(root.right!=null) {
			displayTreeDFS(root.right);
		}
	}
	
	/** Converts a BST into a one-dimensional array in BFS order
	 * @param root
	 * @param nLevels
	 * @return array containing all the elements in BFS order
	 */
	public static int[] BSTToArray(BinarySearchNode root, int nLevels) {
		int[] bstArr = new int[(int)Math.pow(2, nLevels)-1];
		Arrays.fill(bstArr, Integer.MIN_VALUE);
		bstArr[0] = root.val;
		if(root.left!=null&&root.right!=null){
			fillArray(root.left, 0, bstArr, false);
			fillArray(root.right, 0, bstArr, true);
		}
		else if(root.left!=null) {
			fillArray(root.left, 0, bstArr, false);
		}
		else if(root.right!=null) {
			fillArray(root.right, 0, bstArr, true);
		}
		return bstArr;
	}
	
	/** Helper function to BSTTOArray. Recursively calls itself to fill values from BST to array in BFS order
	 * Executes in O(n)
	 * @param node
	 * @param parentId
	 * @param bstArr
	 * @param isRightChild
	 */
	public static void fillArray(BinarySearchNode node, int parentId, int[] bstArr, boolean isRightChild) {
		int currId = -1;
		if (isRightChild) {
			currId = 2*parentId+2;
		}
		else {
			currId = 2*parentId+1;
		}
		bstArr[currId] = node.val;
		if(node.left!=null&&node.right!=null){
			fillArray(node.left, currId, bstArr, false);
			fillArray(node.right, currId, bstArr, true);
		}
		else if(node.left!=null) {
			fillArray(node.left, currId, bstArr, false);
		}
		else if(node.right!=null) {
			fillArray(node.right, currId, bstArr, true);
		}
	}
	
	/** Prints the top-bottom BFS view of the tree (left first)
	 * @param root
	 */
	public static void displayTreeBFS(BinarySearchNode root) {
		System.out.println("\nBFS View...");
		int[] bstArr = BSTViews.BSTToArray(root, BinarySearchNode.getTreeHeight(root));
		for(int i=0; i<bstArr.length; i++) {
			System.out.print(bstArr[i]+" ");
		}
	}
}
