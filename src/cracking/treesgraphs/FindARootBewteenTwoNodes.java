package cracking.treesgraphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class FindARootBewteenTwoNodes {
	public static Node root;
	public boolean BFS(Graph graph, GraphNode target){
		List<GraphNode> nodes = graph.nodes;
		Queue<GraphNode> visitingNodes = new LinkedList<GraphNode>();
		GraphNode startNode = nodes.get(0);
		visitingNodes.add(startNode);
		while(visitingNodes.size() != 0){
			GraphNode visitingNode = visitingNodes.poll();
			visitingNode.state = STATE.VISITING;
			if(visitingNode.equals(target)){
				return true;
			} else {
				for(GraphNode neighborNode : visitingNode.neighbors){
					if(neighborNode.state != STATE.VISITED)
						visitingNodes.add(neighborNode);
					}
				}
				visitingNode.state = STATE.VISITED;
			}
		return false;
	}
	
	public boolean DFS(Graph graph, GraphNode target){
		List<GraphNode> nodes = graph.nodes;
		Stack<GraphNode> visitingNodes = new Stack<GraphNode>();
		GraphNode startNode = nodes.get(0);
		visitingNodes.add(startNode);
		while(visitingNodes.size() != 0){
			GraphNode visitingNode = visitingNodes.pop();
			visitingNode.state = STATE.VISITING;
			if(visitingNode.equals(target)){
				return true;
			} else {
				for(GraphNode neighborNode : visitingNode.neighbors){
					if(neighborNode.state != STATE.VISITED)
						visitingNodes.push(neighborNode);
					}
				}
				visitingNode.state = STATE.VISITED;
			}
		return false;
	}
	
	public boolean DFSRecursive(Graph graph, GraphNode target){
		
		
		if ( (target.state == STATE.VISITED)){
			if (target.)
			target.state = STATE.VISITED;
			
		} else{
		
		}
	}
}
