package cracking.chapter2;

public class PartitionLinkedList4 {
	public static Node partition(Node n, int x){
		Node before = null;
		Node after = null;
		Node head = null;
		while(n != null){
			Node newNode = new Node(null,n.value);
			if(n.value < x){
				if (before == null){
					before = newNode;
				} else {
					newNode.next = before;
					before = newNode;
				}
			} else {
				if (after == null){
					after = newNode;
				} else {
					newNode.next = after;
					after = newNode;
				}
			}
			n = n.next;
		}
		head = before;
		while(before.next != null){
			before = before.next;
		}
		before.next = after;
		return head;
	}
	public static void main(String[] args){
		Node n0 = new Node(null,1);
		Node n1 = new Node(n0,1);
		Node n2 = new Node(n1,2);
		Node n3 = new Node(n2,3);
		Node n4 = new Node(n3,4);
		Node n5 = new Node(n4,2);
		Node n6 = new Node(n5,8);
		Node n7 = partition(n6,3);
		n7.print();
	}
}
