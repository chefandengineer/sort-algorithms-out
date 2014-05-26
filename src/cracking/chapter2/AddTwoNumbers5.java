package cracking.chapter2;

public class AddTwoNumbers5 {
	public static Node addTwoNumbers(Node num1, Node num2){
		Node num3 = null;
		Node head = null;
		int updigit = 0;
		while(num1 != null && num2 != null){
			int digit1 = num1.value;
			int digit2 = num2.value;
			int newdigit = (digit1 + digit2 + updigit) % 10;
			updigit = (digit1 + digit2) / 10;
			Node numNode = new Node(null,newdigit);
			if (num3 == null){
				num3 = numNode;
				head = num3;
			} else {
				num3.next = numNode;
				num3 = numNode;
			}
			num1 = num1.next;
			num2 = num2.next;
		}
		if (num1 != null){
			num3.next = num1;
		}
		if (num2 != null){
			num3.next = num2;
		}
		return head;
	}
	public static void main(String[] args){
		Node n0 = new Node(null,1);
		Node n1 = new Node(n0,1);
		Node n2 = new Node(n1,2);
		Node n3 = new Node(n2,3);
		Node n4 = new Node(null,4);
		Node n5 = new Node(n4,5);
		Node n6 = new Node(n5,10);
		Node n7 = addTwoNumbers(n6,n3);
		n7.print();
	}
}
