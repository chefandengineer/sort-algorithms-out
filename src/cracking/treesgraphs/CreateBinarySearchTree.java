package cracking.treesgraphs;

import javax.swing.tree.TreeNode;

public class CreateBinarySearchTree {
	public static Node createBST(int[] arr,int start,int end){
		if (start > end){
			return null;
		}
		int rootIndex = (end + start) / 2;
		int rootValue = arr[rootIndex];
		Node node = new Node(rootValue);
		node.left = createBST(arr,start,rootIndex - 1);
		node.right = createBST(arr,rootIndex + 1, end);
		return node;
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6};
		Node root = createBST(arr,0,arr.length - 1);
		Node.postTraversal(root);
		System.out.println("iterative");
		Node newroot = createBST(arr,0,arr.length - 1);
		Node.postTraversalIterative(newroot);
	}
}
