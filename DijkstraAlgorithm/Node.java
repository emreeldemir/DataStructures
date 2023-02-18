import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Node {
    private String name;
    private int distance;
    private LinkedList<Node> shortestPath;
    private Map<Node, Integer> adjVertices;

    public Node(String name) {
        this.name = name;
        this.distance = Integer.MAX_VALUE;
        this.adjVertices = new HashMap<>();
        this.shortestPath = new LinkedList<>();
    }

    public void addDestination(Node destination, int distance) {
        adjVertices.put(destination, distance);
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public LinkedList<Node> getShortestPath() {
        return shortestPath;
    }
    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
    public Map<Node, Integer> getAdjVertices() {
        return adjVertices;
    }
    public void setAdjVertices(Map<Node, Integer> adjVertices) {
        this.adjVertices = adjVertices;
    }
   


}
