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
    // A-> B->C
    
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode curr = head;
        // ListNode head1 = new ListNode(0,null);
        ListNode next = null;
        while(curr.next!=null){
            ListNode temp = curr.next;
            curr.next = next;
            next = curr;
            curr = temp;
        }
        curr.next = next;
        return curr;
    }
}
