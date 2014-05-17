package cracking.treesgraphs;
/**
 * 
 * @author apple
 *
 */
public class BalancedBinaryTreeChecker {
	public static boolean check(Node node){
		if (node == null){
			return false;
		}
		return (max(node) - min(node)) <= 1;
	}
	
	public static int max(Node node) {
		if (node == null){
			return 0;
		}
		return Math.max(max(node.left), max(node.right)) + 1;
	}
	
	public static int min(Node node) {
		if (node == null){
			return 0;
		}
		return Math.min(min(node.left), min(node.right)) + 1;
	}
	
	public static void main(String[] args){
		CommonTree tree = new CommonTree();
		tree.makeBalanceTree();
		Node root = tree.getRoot();
		System.out.println(max(root));
		System.out.println(min(root));
		
		System.out.println(check(root));
		
		tree.makeUnBalanceTree();
		root = tree.getRoot();
		System.out.println(max(root));
		System.out.println(min(root));
		System.out.println(check(root));

	}
}


