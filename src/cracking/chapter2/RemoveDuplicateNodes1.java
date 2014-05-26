package cracking.chapter2;

import java.util.HashSet;

public class RemoveDuplicateNodes1 {
	public static void removeDuplicates(Node n){
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		while(n != null){
			if(set.contains(n.value)){
				previous.next = n.next;
				n = n.next;
			} else {
				set.add(n.value);
				previous = n;
				n = n.next;
			}
		}
	}
	
	public static void main(String[] args){
		Node n0 = new Node(null,1);
		Node n1 = new Node(n0,1);
		Node n2 = new Node(n1,2);
		Node n3 = new Node(n2,3);
		Node n4 = new Node(n3,4);
		Node n5 = new Node(n4,5);
		Node n6 = new Node(n5,5);
		removeDuplicates(n6);
		n6.print();
	}
}
