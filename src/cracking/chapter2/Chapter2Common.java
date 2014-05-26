package cracking.chapter2;

public class Chapter2Common {
	
}

class Node{
	Node next;
	int value;
	public Node(Node _next, int _value){
		next = _next;
		value = _value;
	}
	public void print(){
		Node n = this;
		while(n != null){
			System.out.println(n.value);
			n = n.next;
		}
	}
}
