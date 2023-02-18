public class Node {
    
    Character ch;  
    Integer freq;

    Node left = null;   
    Node right = null;   

    Node (Character ch, Integer freq) {  
        this.ch = ch;  
        this.freq = freq;  
    }  

    public Node(Character ch, Integer freq, Node left, Node right) {  
        this.ch = ch;  
        this.freq = freq;  
        this.left = left;  
        this.right = right;  
    }  
}
