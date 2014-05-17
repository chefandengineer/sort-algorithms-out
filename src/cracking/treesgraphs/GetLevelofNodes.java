package cracking.treesgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//TODO : Get clear of the Big O for this one. 

public class GetLevelofNodes {
	
	public static List<ArrayList<Node>>  getLevelofAllNodes(Node root){		
		if (root == null){
			return null;
		}
		List<ArrayList<Node>> nodes = new ArrayList<ArrayList<Node>>();
		ArrayList<Node> lastLevelNodes = new ArrayList<Node>();
		nodes.add(lastLevelNodes);
		lastLevelNodes.add(root);
		while(lastLevelNodes.size() != 0){
			ArrayList<Node> currentLevelNodes = new ArrayList<Node>();
			for(Node node : lastLevelNodes){
				if (node.left != null){
					currentLevelNodes.add(node.left);
				}
				if (node.right != null) {
					currentLevelNodes.add(node.right);
				}
			}
			nodes.add(currentLevelNodes);
			lastLevelNodes = currentLevelNodes;
		}
		return nodes;
	}
	
	public static void getLevelofAllNodesRecursive(Node root, List<ArrayList<Node>> levelOfNodes, int level){
		if (root == null){
			return;
		}
		ArrayList<Node> currentLevel;
		if (levelOfNodes.size() == level) {			
			currentLevel = new ArrayList<Node>();
			levelOfNodes.add(level,currentLevel);
		} else {
			currentLevel = levelOfNodes.get(level);
		}
		currentLevel.add(root);
		level += 1;
		getLevelofAllNodesRecursive(root.left,levelOfNodes,level);
		getLevelofAllNodesRecursive(root.right,levelOfNodes,level);
	}
	
	public static void printAllLevel(List<ArrayList<Node>> nodes){
		for(ArrayList<Node> list : nodes){
			System.out.println();
			for(int i = 0; i < list.size(); ++i){
				System.out.print(list.get(i).value + " ");
			}
		}
		
	}
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node root = CreateBinarySearchTree.createBST(arr,0,arr.length - 1);
		
		printAllLevel(getLevelofAllNodes(root));
		
		List<ArrayList<Node>> levelOfNodes = new ArrayList<ArrayList<Node>>();
		getLevelofAllNodesRecursive(root,levelOfNodes,0);
		printAllLevel(levelOfNodes);
		
	}
}
