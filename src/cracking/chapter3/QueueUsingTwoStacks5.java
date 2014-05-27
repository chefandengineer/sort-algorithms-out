package cracking.chapter3;

import java.util.Stack;

public class QueueUsingTwoStacks5 {
	private Stack<Integer> _storeStack;
	private Stack<Integer> _queueStack;
	
	public QueueUsingTwoStacks5(){
		_storeStack = new Stack<Integer>();
		_queueStack = new Stack<Integer>();
	}
	
	public int size(){
		return _queueStack.size() + _storeStack.size();
	}
	public int dequeue(){
		if(_queueStack.isEmpty()){
			_copyStack(); 
		} 
		return _queueStack.pop();
	}
	
	public void enqueue(int i){
		_storeStack.push(i);
	}
	
	private void _copyStack(){
		while(!_storeStack.isEmpty()){
			int i = _storeStack.pop();
			_queueStack.push(i);
		}
	}
	
	public static void main(String[] args){
		QueueUsingTwoStacks5 queue = new QueueUsingTwoStacks5();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
