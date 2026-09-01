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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode firstHalf = slow;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode reversedList = reverseList(secondHalf);
        ListNode result  = new ListNode(-1);
        ListNode curr = result;
        while(firstHalf!=null && reversedList!=null){
            ListNode temp = firstHalf.next;
            ListNode temp2 = reversedList.next;
            firstHalf.next = null;
            reversedList.next = null;
            curr.next = firstHalf;
            curr.next.next = reversedList;

            firstHalf = temp;
            reversedList = temp2;
            curr = curr.next.next;
        }
        if(firstHalf==null && reversedList!=null){
            curr.next = reversedList;
        }
        if(reversedList==null && firstHalf!=null){
            curr.next = firstHalf;
        }
        head = result.next;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
