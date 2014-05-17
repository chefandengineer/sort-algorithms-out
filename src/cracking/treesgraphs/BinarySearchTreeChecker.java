package cracking.treesgraphs;

public class BinarySearchTreeChecker {
	public boolean checkBST(Node root, int max, int min){
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
}
