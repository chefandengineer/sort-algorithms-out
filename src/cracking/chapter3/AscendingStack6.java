package cracking.chapter3;

import java.util.Stack;

public class AscendingStack6 {
	private Stack<Integer> _helperStack;
	private Stack<Integer> _stack;
	
	public AscendingStack6(){
		_helperStack = new Stack<Integer>();
		_stack = new Stack<Integer>();
	}
	
	public void push(int i){
		if(_stack.isEmpty()){
			_stack.push(i);
		}else{
			while(!_stack.isEmpty() && i < _stack.peek() ){
				_helperStack.push(_stack.pop());
			}
			_stack.push(i);
			while(!_helperStack.isEmpty()){
				_stack.push(_helperStack.pop());
			}
		}
	}
	
	public int pop(){
		return _stack.pop();
	}
	public int peek(){
		return _stack.peek();
	}
	
	public static Stack<Integer> sortStack(Stack<Integer> stack){
		Stack<Integer> helper = new Stack<Integer>();
		while(!stack.isEmpty()){
			int tmp = stack.pop();
			while(!helper.isEmpty() && tmp <= helper.peek()){
				stack.push(helper.pop());
			}
			helper.push(tmp);
		}
		return helper;
	}
	
	
	
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		Stack<Integer> newStack = sortStack(stack);
		System.out.println(newStack.peek());
		newStack.pop();
		System.out.println(newStack.peek());
		newStack.pop();
		System.out.println(newStack.peek());
		newStack.pop();
		System.out.println(newStack.peek());
		newStack.pop();
		System.out.println(newStack.peek());
		newStack.pop();
	}
}
