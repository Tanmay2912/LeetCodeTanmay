/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    // Map to store <Original Node, Cloned Node>
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        // Base case: Empty graph
        if (node == null) {
            return null;
        }
        // If node is already cloned, return its clone
        if (map.containsKey(node)) {
            return map.get(node);
        }
        // Create a clone of the current node
        Node cloneNode = new Node(node.val);
        // Store it in the map BEFORE cloning neighbors
        map.put(node, cloneNode);
        // Clone all the neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}