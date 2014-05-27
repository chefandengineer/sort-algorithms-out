package cracking.chapter3;

import java.util.Stack;

public class StackWithMinFunction {
	private Stack<Integer> _stack;
	private Stack<Integer> _minStack;
	
	public StackWithMinFunction(){
		_stack = new Stack<Integer>();
		_minStack = new Stack<Integer>();
	}
	public void push(Integer i){
		_stack.push(i);
		if(_minStack.isEmpty()){
			_minStack.push(i);
		} else {
			int min = _minStack.peek();
			if (i <= min){
				_minStack.push(i);
			}
		}
	}

	public int pop(){
		if(!_stack.isEmpty()){
			int top = _stack.peek();
			int min = _minStack.peek();
			if(top == min){
				_minStack.pop();
			}
			_stack.pop();
			return top;
		} else {
			return -1;
		}
	} 
	
	public int min(){
		return _minStack.isEmpty() ? Integer.MAX_VALUE: _minStack.peek();
	}
	
	public static void main(String[] args){
		StackWithMinFunction stack = new StackWithMinFunction();
		stack.push(2);
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(2);
		
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
	}
}
