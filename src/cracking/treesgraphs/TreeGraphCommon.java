package cracking.treesgraphs;

import java.util.LinkedList;

import chapter4.GraphNode;
import chapter4.TreesAndGraphs.STATE;

public class TreeGraphCommon {

}


class Node {
	public Node left;
	public Node right;
	public int value;
	
	public Node(int _value){
		value = _value;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}


class CommonTree {
	Node node1;
	Node node2;
	Node node3;
	Node node4;
	Node node5;
	Node node6;
	Node node7;
	Node node8;
	Node node9;
	
	
	public void init(){
		node1 = new Node(1);
		node2 = new Node(2);
		node3 = new Node(3);
		node4 = new Node(4);
		node5 = new Node(5);
		node6 = new Node(6);
		node7 = new Node(7);
		node8 = new Node(8);
		node9 = new Node(9);	
	}
	
	public void makeBalanceTree(){
		init();
		node9.left = node8;
		node9.right = node7;
		node7.left = node6;
		node7.right = node5;
		node5.left = node4;
		node5.right = node3;
		node8.left = node2;
		node8.right = node1;
	}
	
	public void makeUnBalanceTree(){
		init();
		node9.left = node8;
		node9.right = node7;
		node7.left = node6;
		node7.right = node5;
		node5.left = node4;
		node5.right = node3;
		node8.left = node2;
		node3.right = node1;
	}
	
	public Node getRoot(){
		return node9;
	}
}

class GraphNode {
	public LinkedList<GraphNode> neighbors;
	int value;
	public STATE state;
}

class Graph {
	public LinkedList<GraphNode> nodes;
}

enum STATE {
	UNVISITED, VISITED, VISITING;
}