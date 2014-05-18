package cracking.chapter9;

import java.util.ArrayList;
import java.util.HashMap;

public class PossibleWaysToMoveMatrix {
	public static int  moveOnMatrix(int x, int y){
		if (x < 0 || y < 0){
			return 0;
		}
		if(x == 0){
			return 1;
		}
		if(y == 0){
			return 1;
		}
		return moveOnMatrix(x-1,y) + moveOnMatrix(x,y-1);
	}
	
	public static boolean  getPath(int x, int y, ArrayList<Point> path){
		Point point = new Point(x,y);
		if(x == 0 && y == 0){
			path.add(point);	
			return true;
		}
		boolean found = false;
		if(x >= 1){
			found = getPath(x-1,y,path);
		}
		if(!found && y >= 1){
			found = getPath(x,y-1,path);
		}
		if (found){
			path.add(point);
		}
		return found;
	}
	
	public static boolean  getPathDP(int x, int y, ArrayList<Point> path,HashMap<Point,Boolean> map){
		Point point = new Point(x,y);
		if(x == 0 && y == 0){
			path.add(point);	
			return true;
		}
		if(map.containsKey(point)){
			return map.get(point);
		}
		boolean found = false;
		if(x >= 1){
			found = getPathDP(x-1,y,path,map);
		}
		if(!found && y >= 1){
			found = getPathDP(x,y-1,path,map);
		}
		if (found){
			path.add(point);
		}
		map.put(point, found);
		return found;
		
	}
	
	public static void main(String[] args){
	//	System.out.println(moveOnMatrix(1,1));
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point,Boolean> map = new HashMap<Point,Boolean>();
		getPathDP(5,5,path,map);
		for(Point p : path){
			System.out.println(p);
		}
	}
}

class Point{
	int x;
	int y;
	
	public Point(int _x,int _y){
		x = _x;
		y = _y;
	}
	public String toString(){
		return "x : " + x + " y : " + y;
	}
}
