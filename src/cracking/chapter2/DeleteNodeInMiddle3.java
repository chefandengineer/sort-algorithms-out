package cracking.chapter2;

public class DeleteNodeInMiddle3 {
	public static boolean delete(Node node){
		if(node != null && node.next != null){
			node.value = node.next.value;
			node.next = node.next.next;
			return true;
		} 
		return false;
	}
	public static void main(String[] args){
		Node n0 = new Node(null,1);
		Node n1 = new Node(n0,1);
		Node n2 = new Node(n1,2);
		Node n3 = new Node(n2,3);
		Node n4 = new Node(n3,4);
		Node n5 = new Node(n4,5);
		Node n6 = new Node(n5,5);
		delete(n3);
		n6.print();
	}
}
