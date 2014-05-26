package cracking.chapter2;

public class FindKthElementToEnd2 {
	public static Node findKthElement(Node root, int k){
		Node n1 = root;
		Node n2 = root;
		int i = 0;
		while(i < k){
			n1 = n1.next;
			i++;
		}
		while(n1.next != null){
			n1 = n1.next;
			n2 = n2.next;
		}
		return n2;
	}
	
	public static void main(String[] args){
		Node n0 = new Node(null,1);
		Node n1 = new Node(n0,1);
		Node n2 = new Node(n1,2);
		Node n3 = new Node(n2,3);
		Node n4 = new Node(n3,4);
		Node n5 = new Node(n4,5);
		Node n6 = new Node(n5,5);
		Node n7 = findKthElement(n6,3);
		System.out.println(n7.value);
	}
}

