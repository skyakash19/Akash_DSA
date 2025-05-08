class Solution {
    
    HashMap<Node, Node> visitedNode = new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {
   
        if(head == null){
            return null;
        }
        
        if(this.visitedNode.containsKey(head)){
            return this.visitedNode.get(head);
        }
        
           Node node = new Node(head.val, null, null);
           
           this.visitedNode.put(head, node);
           node.next = copyRandomList(head.next);
           node.random = copyRandomList(head.random);
           
           return node;
           
    }
}
