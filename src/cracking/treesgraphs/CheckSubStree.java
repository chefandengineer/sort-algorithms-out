package cracking.treesgraphs;

/**
 * Check if a tree is a subtree of another
 * Space(O(log*n + log*m))
 * Time(O(n + km)) where k is most likey to be n/p p is the range of the nodes of t2
 * @author apple
 *
 */
public class CheckSubStree {
	
	public static boolean findSameNode(Node t1, Node t2){
		if(t1 == null){
			return false;
		}
		if(t2.value == t1.value) {
			return isSubTree(t1,t2);
		}
		return findSameNode(t1.left,t2) || findSameNode(t1.right,t2);
	}
	public static boolean isSubTree(Node t1, Node t2){
		if(t2 == null && t1 == null){
			return true;
		}
		if(t2 == null || t1 == null){
			return false;
		}
		if(t2.value != t1.value){
			return false;
		}
		return isSubTree(t1.left,t2.left) || isSubTree(t1.right,t2.right);
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6};
		Node t1 = CreateBinarySearchTree.createBST(arr,0,arr.length - 1);
		int[] arr1 = {1,2,3,4,5,6,7,8,9};
		Node t2 = CreateBinarySearchTree.createBST(arr1,0,arr1.length - 1);
		System.out.println(findSameNode(t2,t1));
	}
}
