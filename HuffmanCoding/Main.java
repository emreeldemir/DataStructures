import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) {

        String text = "abracadabra";

        Map<Character, Integer> freq = new HashMap<>();

        for (char c: text.toCharArray()) {  
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));

        for (var entry: freq.entrySet()) {  
            pq.add(new Node(entry.getKey(), entry.getValue()));  
        }
        
        while (pq.size() > 1) {    
            Node left = pq.poll();  
            Node right = pq.poll();

            pq.add(new Node(null, left.freq + right.freq, left, right));
        }
        
        
        
    }
    
    public static void encode(Node currentNode, String str, Map<Character,String> map) {

        if (currentNode == null) {  
            return;  
        }  
        
        if (isLeaf(currentNode)) {  
            map.put(currentNode.ch, str.length() > 0 ? str : "1");  
        }  
        
        encode(currentNode.left, str + '0', map);  
        encode(currentNode.right, str + '1', map);  
    }

    public static boolean isLeaf(Node root) {  
        return root.left == null && root.right == null;  
    }  

}

