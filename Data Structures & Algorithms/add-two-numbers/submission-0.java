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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        ListNode result = new ListNode(-1);
        ListNode resPointer = result;
        int carry = 0;
        while(curr1!=null && curr2!=null){
            int sum = curr1.val+curr2.val + carry;
            int val = sum%10;
            carry  = sum/10;
            resPointer.next = new ListNode(val);
            resPointer = resPointer.next;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while(curr1!=null){
            int sum = curr1.val+ carry;
            int val = sum%10;
            carry  = sum/10;
            resPointer.next = new ListNode(val);
            resPointer = resPointer.next;
            curr1 = curr1.next;
        }
         while(curr2!=null){
            int sum = curr2.val+ carry;
            int val = sum%10;
            carry  = sum/10;
            resPointer.next = new ListNode(val);
            resPointer = resPointer.next;
            curr2 = curr2.next;
        }
        if(carry!=0){
            resPointer.next = new ListNode(carry);
        }
        return result.next;
    }
}
