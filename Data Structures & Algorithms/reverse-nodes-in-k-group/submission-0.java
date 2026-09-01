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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy  = new ListNode(0,head);
        ListNode groupPrev = dummy;
        while(true){
            ListNode kth = getKth(groupPrev,k);
            if(kth==null)break;

            ListNode prev = kth.next;
            ListNode groupNext = kth.next;
            ListNode curr = groupPrev.next;
            while(curr!=groupNext){
                ListNode temp  = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev  = temp;


        }
        return dummy.next;
    }
    public ListNode getKth(ListNode groupPrev, int k){
        ListNode curr = groupPrev;
        while(curr!=null && k>0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
