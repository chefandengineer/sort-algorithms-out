package cracking.chapter18;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianValue9 {
	private static PriorityQueue<Integer> _minHeap = new PriorityQueue<Integer>();
	private static PriorityQueue<Integer> _maxHeap = new PriorityQueue<Integer>(100,new MaxComparator());
	
	public static void addNumber(int number) {
		if ( _minHeap.size() == _maxHeap.size()){
			if(_minHeap.peek() != null && number > _minHeap.peek()){
				_maxHeap.offer(_minHeap.poll());
				_minHeap.offer(number);
			} else {
				_maxHeap.offer(number);
			}
		} else {
			if (number < _maxHeap.peek()){
				_minHeap.offer(_maxHeap.poll());
				_maxHeap.offer(number);
			} else {
				_minHeap.offer(number);
			}
		}
	} 
	
	
	public static double getMedian(){
		if(_maxHeap.isEmpty()){
			return 0;
		} else if (_maxHeap.size() > _minHeap.size()){
			return _maxHeap.peek();
		} else {
			return ((double)_maxHeap.peek() + (double)_minHeap.peek()) / 2;
		}
	}
	
	
	public static void main(String[] args){
		int[] arr = {1,4,5,2,3,6,7,9,8};
		for(Integer i : arr){
			addNumber(i);
			System.out.println("Adding " + i);
			System.out.println(getMedian());
		}
	}
	
}

class MaxComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 > o2 ? -1 : 1;
	}
	
}