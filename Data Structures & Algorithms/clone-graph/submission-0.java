/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if(node==null)return null;

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        HashMap<Integer,Node> map = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();

        while(!stack.isEmpty()){
            Node curr = stack.pop();
            if(visited.contains(curr))continue;

            Node curr_d = map.getOrDefault(curr.val,new Node(curr.val));
            
            for(Node nbr : curr.neighbors){
                Node nbr_d = map.getOrDefault(nbr.val,new Node(nbr.val));
                curr_d.neighbors.add(nbr_d);
                stack.push(nbr);
                map.put(nbr_d.val,nbr_d);
            }
            map.put(curr_d.val,curr_d);
            visited.add(curr);
        }
        return map.containsKey(1)?map.get(1):null;


        
    }
}