package cracking.treesgraphs;


public class BinarySearchTreeChecker {
	public static boolean checkBST(Node root, int max, int min){
		if(root == null) {
			return true;
		}
		if (root.value > max || root.value < min){
			return false;
		}
		boolean isLeftBST = checkBST(root.left,root.value,min);
		if(!isLeftBST){
			return false;
		}
		boolean isRightBST = checkBST(root.right,max,root.value);
		if(!isRightBST){
			return false;
		}
		return true;
	}
	public static int min = Integer.MIN_VALUE;
	public static boolean checkBSTInOrderTraversal(Node root){
		if(root == null){
			return true;
		}
		if (!checkBSTInOrderTraversal(root.left)){
			return false;
		}
		if (root.value < min){
			return false;
		} 
		min = root.value;
		if (!checkBSTInOrderTraversal(root.right)){
			return false;
		}
		return true;
	}
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node root = CreateBinarySearchTree.createBST(arr,0,arr.length - 1);
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		System.out.println(checkBST(root,max,min));
		System.out.println(checkBSTInOrderTraversal(root));
	}
}
