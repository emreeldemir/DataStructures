package edu.akdeniz.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import edu.akdeniz.graph.Graph.Vertex;

public class GraphTraversal {
    static Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex).keySet()) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    static Set<String> breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex).keySet()) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }

    static void floydWarshall(Graph graph) {
        ArrayList<Vertex> keySet = graph.getKeySet();

        int[][] matrix = new int[keySet.size()][keySet.size()];
        // int[][] next = new int[keySet.size()][keySet.size()];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                LinkedHashMap<Vertex,Integer> komsuSehirler = graph.getAdjVertices(keySet.get(i).label);

                Integer distance = komsuSehirler.get(keySet.get(j));

                if (i == j) {
                    matrix[i][j] = 0;
                } 

                else if (distance != null) {
                    matrix[i][j] = distance;
                } 

                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    if (matrix[j][k] > matrix[j][i] + matrix[i][k]) {
                        matrix[j][k] = matrix[j][i] + matrix[i][k];                            
                    }
                        print(matrix);
                    }
            }
        }

    }

    static void print (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == Integer.MAX_VALUE)
                    System.out.print("- ");
                else
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}