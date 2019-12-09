package com.google.tree;

/*
class Graph {

	// number of vertices
	int V;
	Integer[][] adjArray;

	// Initialize graph's vertices with respective linked lists.
	Graph(int V) {
		this.V = V;
		this.adjArray = new Integer[V][2];
	}

	// ads edges to the graph. Takes a graph, a src vertice and destination
	// vertice
	public void addEdges(int src, int dest) {
		this.adjArray[src].addFirst(dest);
		// undirected graph
		this.adjArray[dest].addFirst(src);
	}

	public void printGraph() {

		for (int i = 0; i < this.V; i++) {
			System.out.println("Adjacency list for vertex " + i);
			System.out.print("start");
			for (Object list : this.adjArray[i]) {
				System.out.print(" -> " + list);
			}
			System.out.println("\n");
		}

	}
}

public class GraphDemo {
	public static void main(String[] args) {
		Graph graph = new Graph(5);

		graph.addEdges(0, 1);
		graph.addEdges(0, 4);
		graph.addEdges(1, 2);
		graph.addEdges(1, 3);
		graph.addEdges(1, 4);
		graph.addEdges(2, 3);
		graph.addEdges(3, 4);

		graph.printGraph();
	}

}
*/
