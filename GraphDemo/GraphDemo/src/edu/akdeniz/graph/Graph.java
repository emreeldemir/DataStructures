package edu.akdeniz.graph;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Graph {
    private LinkedHashMap<Vertex, LinkedHashMap<Vertex,Integer>> adjVertices;

    public Graph() {
        adjVertices = new LinkedHashMap<Vertex, LinkedHashMap<Vertex,Integer>>();
    }

        
    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new LinkedHashMap<Vertex,Integer>());
    }

    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }
    
    void addEdge(String label1, String label2, int distance) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).put(v2, distance);
        adjVertices.get(v2).put(v1, distance);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        LinkedHashMap<Vertex,Integer> eV1 = adjVertices.get(v1);
        LinkedHashMap<Vertex,Integer> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    LinkedHashMap<Vertex,Integer> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    ArrayList<Vertex> getKeySet(){
        return new ArrayList<>(adjVertices.keySet());
    }

    
    String printGraph() {
        StringBuffer sb = new StringBuffer();
        for(Vertex v : adjVertices.keySet()) {
            sb.append(v);
            sb.append(adjVertices.get(v));
        }
        return sb.toString();
    }

    class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private Graph getOuterType() {
            return Graph.this;
        }
    }
}