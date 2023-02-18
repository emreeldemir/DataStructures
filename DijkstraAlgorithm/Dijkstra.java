import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Map.Entry;

public class Dijkstra {
    
    public static void calculateMinDistance(Node sourceNode, Node destinationNode, int distance){

        int sourceDistance = sourceNode.getDistance();
        
        if(sourceDistance + distance < destinationNode.getDistance()){
            destinationNode.setDistance(sourceDistance + distance);
            
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            destinationNode.setShortestPath(shortestPath);
        }

    }

    public static Graph calculateShortestPath(Graph graph, Node sourceNode){
        sourceNode.setDistance(0);
        
        Set<Node> settledNodes = new HashSet<>();
        PriorityQueue<Node> unsettledNodes = new PriorityQueue<>(Comparator.comparingInt(n -> n.getDistance()));

        unsettledNodes.add(sourceNode);

        while(!unsettledNodes.isEmpty()){
            Node currentNode = unsettledNodes.poll();
            
            for(Entry<Node,Integer> e: currentNode.getAdjVertices().entrySet()){
                
                Node adjacentNode = e.getKey();
                Integer distance = e.getValue();
                
                if(!settledNodes.contains(adjacentNode)){
                    calculateMinDistance(currentNode, adjacentNode, distance);
                    unsettledNodes.add(adjacentNode);
                }
            }
                settledNodes.add(currentNode);

        }



        
        return graph;
    }


    

}
