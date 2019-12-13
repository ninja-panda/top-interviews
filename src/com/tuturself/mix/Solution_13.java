package com.tuturself.mix;

import java.util.*;

public class Solution_13 {

	private static final int WHITE = 0;
	private static final int GRAY = 1;
	private static final int BLACK = 2;

	boolean possible = true;
	Stack<Integer> topologicalOrder;
	Map<Integer, List<Integer>> adjacencyMatrix;
	Map<Integer, Integer> color;

	private void init(int num) {
		topologicalOrder = new Stack<>();
		adjacencyMatrix = new HashMap<>();
		color = new HashMap<>();

		for (int i = 0; i < num; i++) {
			color.put(i, WHITE);
		}
	}

	private void dfs(int node) {
		if(!possible) return;
		color.put(node,GRAY);
		List<Integer> adjList = adjacencyMatrix.getOrDefault(node,new ArrayList<>());
		for(int n : adjList){
			int col = color.get(n);
			if(col == WHITE) dfs(n);
			if(col == GRAY){
				possible = false;
				break;
			}
		}
		color.put(node,BLACK);
		topologicalOrder.push(node);
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		this.init(numCourses);

		for (int i = 0; i < prerequisites.length; i++) {
			int src = prerequisites[i][1];
			int dest = prerequisites[i][0];
			List<Integer> adjList = adjacencyMatrix.get(src);
			if (adjList == null) {
				adjList = new ArrayList<>();
				adjacencyMatrix.put(src, adjList);
			}
			adjList.add(dest);
		}

		for(int i = 0 ; i < numCourses ; i++){
			if(color.get(i) == WHITE){
				dfs(i);
			}
		}
		if(!possible) return new int[0];
		return topologicalOrder.stream().mapToInt( i -> i).toArray();
	}
}
