package com.google.tree;

import java.util.Collections;
import java.util.LinkedList;

class Edge implements Comparable<Edge> {
    int start;
    int end;

    public Edge(int s, int e) {
        start = s;
        end = e;
    }

    public int compareTo(Edge e) {
        if (this.start == e.start) return this.end - e.end;
        return this.start - e.start;
    }
}

class RemoveStoneSolution {
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return 0;
        LinkedList<Edge> edgeList = new LinkedList<>();
        for (int[] s : stones) {
            Edge edge = new Edge(s[0], s[1]);
            edgeList.add(edge);
        }
        Collections.sort(edgeList);
        for (int i = 0; i < edgeList.size(); i++) {
            if( i == 0){
                Edge current = edgeList.getFirst();
                Edge next = edgeList.get(1);
                if(!hasPath(current,next)){
                    edgeList.removeFirst();
                }
            }

        }
        int count = 0;
        for (int i = 1; i < edgeList.size(); i++) {
            Edge current = edgeList.get(i);
            Edge previous = edgeList.get(i - 1);
            if (hasPath(current, previous)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasPath(Edge current, Edge previous) {
        return (current.start == previous.start ||
                current.start == previous.end ||
                current.end == previous.start ||
                current.end == previous.end);
    }
}

public class RemoveStone {
}
