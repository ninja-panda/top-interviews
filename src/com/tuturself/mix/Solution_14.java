package com.tuturself.mix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_14 {

	private static final int WHITE = 0;
	private static final int GRAY = 1;
	private static final int BLACK = 2;

	boolean possible = true;
	Map<Integer, Integer> color;
	Map<Integer, List<Integer>> adjacencyMatrix;

	private void init(int n) {
		color = new HashMap<>();
		adjacencyMatrix = new HashMap<>();
		for (int i = 0; i < n; i++) {
			color.put(i, WHITE);
		}
	}

	private void dfs(int node) {
		if(!possible) return;
		color.put(node,GRAY);
		List<Integer> adjList = adjacencyMatrix.getOrDefault(node,new ArrayList<>());
		for(int n : adjList){
			int clr = color.get(n);
			if(clr == WHITE) dfs(n);
			if(clr == GRAY){
				possible = false;
				break;
			}
		}
		color.put(node,BLACK);
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		this.init(numCourses);
		for(int i = 0 ; i < prerequisites.length ; i ++){
			int source = prerequisites[i][1];
			int destination = prerequisites[i][0];
			List<Integer> adjList = adjacencyMatrix.getOrDefault(source,new ArrayList<>());
			if(adjList.isEmpty()){
				adjacencyMatrix.put(source,adjList);
			}
			adjList.add(destination);
		}

		for(int i = 0 ; i< numCourses ; i++){
			if(color.get(i) == WHITE){
				dfs(i);
			}
		}
		return possible;
	}
}
