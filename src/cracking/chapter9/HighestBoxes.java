package cracking.chapter9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HighestBoxes {

	public static BoxStack getMaximumHeight(Box[] boxes, Box bottom,
			HashMap<Box, BoxStack> maximumHeight) {
		BoxStack stack = new BoxStack();
		stack.boxes.add(bottom);
		stack.height = bottom.height;
		int height = bottom.height;
		int maxHeight = 0;
		for (int j = 0; j < boxes.length; ++j) {
			Box top = boxes[j];
			if (!bottom.equals(top) && top.canBePlacedOn(bottom)) {
				int topHeight = 0;
				BoxStack topStack = null;
				if (maximumHeight.containsKey(top)) {
					topStack = maximumHeight.get(top);
					topHeight = topStack.height;
				} else {
					topStack = getMaximumHeight(boxes, top, maximumHeight);
					topHeight = topStack.height;
				}
				height = topHeight + bottom.height;
				if (height > maxHeight) {
					List<Box> newStack = new ArrayList<Box>();
					newStack.add(bottom);
					newStack.addAll(topStack.boxes);
					stack.boxes = newStack;
					stack.height = height;
					maxHeight = height;
				}
			}
		}
		maximumHeight.put(bottom, stack);
		return stack;
	}
	public static BoxStack buildHighestStack(Box[] boxes){
		BoxStack maxstack = new BoxStack();
		HashMap<Box,BoxStack> maximumHeight = new HashMap<Box,BoxStack>();
		for(int i = 0; i < boxes.length; ++i){
			Box box = boxes[i];
			BoxStack stack = getMaximumHeight(boxes,box,maximumHeight);
			if(stack.height > maxstack.height){
				maxstack = stack;
			}
		}
		return maxstack;
	}
	
	public static void main(String[] args){
		Box[] boxes = {new Box(1,2,3),
					   new Box(2,4,5),
					   new Box(7,8,9)};
		HashMap<Box,BoxStack> maximumHeight = new HashMap<Box,BoxStack>();
	//	BoxStack maxstack = getMaximumHeight(boxes,new Box(7,8,9),maximumHeight);
		BoxStack maxstack = buildHighestStack(boxes);
		System.out.println(maxstack.height);
	}
}

class BoxStack {
	List<Box> boxes;
	int height;

	public BoxStack() {
		boxes = new ArrayList<Box>();
		height = 0;
	}
}

class Box {
	int width;
	int height;
	int depths;

	public Box(int width, int height, int depths) {
		super();
		this.width = width;
		this.height = height;
		this.depths = depths;
	}

	public boolean canBePlacedOn(Box b) {
		if (this.width < b.width && this.depths < b.depths
				&& this.height < b.height) {
			return true;
		}
		return false;
	}

	public int height() {
		return 0;
	}
}