package cracking.chapter2;

import java.util.Stack;

public class CheckLinkedListIsPalindrome7 {
	public static boolean isPalindrome(Node n){
		Node fast = n;
		Node slow = n;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.next != null){
			stack.push(slow.value);
			fast = fast.next.next;
			slow = slow.next;
		}
		//has odd number
		if(fast != null){
			slow = slow.next;
		} else {
			stack.push(slow.value);
			slow = slow.next;
		}
		while(slow != null){
			int value = stack.peek();
			if(value != slow.value){
				return false;
			}
			stack.pop();
			slow = slow.next;
		}
		return true;
	}
	
	public static Node reverseLinkedList(Node n){
		Node previous = null;
		Node temp;
		while(n != null){
			temp = n.next;
			n.next = previous;
			previous = n;
			n = temp;
		}
		return previous;
	}
	
	
	public static void main(String[] args){
		Node n0 = new Node(null,1);
		Node n1 = new Node(n0,2);
		Node n2 = new Node(n1,3);
		Node n3 = new Node(n2,4);
		Node n4 = new Node(n3,3);
		Node n5 = new Node(n4,4);
		Node n6 = new Node(n5,5);
		System.out.println(isPalindrome(n6));
		Node n7 = reverseLinkedList(n6);
		n7.print();
	}
}
