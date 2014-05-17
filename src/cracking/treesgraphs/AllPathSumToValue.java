package cracking.treesgraphs;

import java.util.ArrayList;
import java.util.List;
/**
 * Question 4.9
 * Time Complexity : O(log*n * n)
 * Space Complexity : O(log*n)
 * @author apple
 *
 */
public class AllPathSumToValue {
	public static List<ArrayList<Node>> paths = new ArrayList<ArrayList<Node>>();
	public static int totalSum = 100;
	public void findAllPath(ArrayList<Node> path, int sum, Node node){
		int value = node.value;
		int remainSum = 0;
		path.add(node);
		if (value == sum){
			paths.add(path);
		} 
		remainSum = sum - value;
		ArrayList<Node> newPath = (ArrayList<Node>)path.clone();
		findAllPath(newPath,remainSum,node.left);
		findAllPath(newPath,remainSum,node.right);
		ArrayList<Node> newPathStartsFromHere = new ArrayList<Node>();
		findAllPath(newPathStartsFromHere,totalSum,node);
	}
	
	public int getSum(ArrayList<Node> path){
		int sum = 0;
		for(int i = 0; i < path.size(); ++i){
			sum += path.get(i).value;
		}
		return sum;
	}
	
	
	public static void findAllPathSolution2(Node node, int sum, int[] path, int level){
		if (node == null){
			return;
		}
		path[level] = node.value;
		int total = 0;
		for(int i = level; i >=0 ; --i){
			total += path[i];
			if(total == sum){
				printPath(path,i,level);
			}
		}
		findAllPathSolution2(node.left,sum,path,level+1);
		findAllPathSolution2(node.right,sum,path,level+1);
	}
	
	public static void printPath(int[] arr, int i,int level){
		System.out.println();
		for(; i <= level ; ++i){
			System.out.print((arr[i]) + " ");
		}
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9,-1,3,4,5,9,1,1,2,2,3,3,4,5};
		Node root = CreateBinarySearchTree.createBST(arr,0,arr.length - 1);
		int[] path = new int[20];
		findAllPathSolution2(root,10,path,0);
	}
}
