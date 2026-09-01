/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
   
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode l:lists){
            pq.add(l);
        }
        ListNode dummy = new ListNode(0);
        ListNode head  = dummy;

        while(!pq.isEmpty()){
            ListNode curr = pq.remove();
            dummy.next = curr;
            curr = curr.next;
            dummy = dummy.next;
            if(curr!=null)pq.add(curr);
            
        }
        return head.next;
    }
  
}
