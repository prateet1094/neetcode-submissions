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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return null;
        int length = 0;
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            length++;
        }
        int nodeIdx = length-n + 1;
        if(nodeIdx==1)return head.next;
        int i=1;
        curr = head;
        while(i<(nodeIdx-1)){
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return head;

    }
}
