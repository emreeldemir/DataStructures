package edu.akdeniz.graph;
public class App {
    public static void main(String[] args) throws Exception {
        

        Graph gg= createGraph();
        GraphTraversal.floydWarshall(gg);

        // System.out.println(gg.printGraph());
  
        // System.out.println(GraphTraversal.depthFirstTraversal(gg, "n1")); 

        // System.out.println(GraphTraversal.breadthFirstTraversal(gg, "n1")); 


    }

    static Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("n1");
        graph.addVertex("n2");
        graph.addVertex("n3");
        graph.addVertex("n4");
        graph.addVertex("n5");
        graph.addVertex("n6");
        
        graph.addEdge("n1", "n2",5);
        graph.addEdge("n1", "n6",8);
        graph.addEdge("n1", "n5",16);

        graph.addEdge("n2", "n3",1);
        graph.addEdge("n2", "n6",2);

        graph.addEdge("n3", "n4",1);
        graph.addEdge("n3", "n6",6);

        graph.addEdge("n4", "n5",4);
        graph.addEdge("n4", "n6",5);

        graph.addEdge("n5", "n6",4);

        return graph;
    }

}
