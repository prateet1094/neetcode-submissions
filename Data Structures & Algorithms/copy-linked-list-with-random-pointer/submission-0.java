/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        map.put(null,null);
        Node curr = head;
        while(curr!=null){
            Node currD = new Node(curr.val);
            map.put(curr,currD);
            curr = curr.next;
        }
        Node result = new Node(-1);
        Node resultCurr = result;
        curr = head;
        while(curr!=null){
            resultCurr.next = map.get(curr);
            resultCurr.next.next = map.get(curr.next);
            resultCurr.next.random = map.get(curr.random);

            curr = curr.next;
            resultCurr = resultCurr.next;
        }
        return result.next;
        
    }
}
