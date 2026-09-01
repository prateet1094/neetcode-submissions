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
    public class PQList{
        int firstEle;
        ListNode list;
        public PQList(int firstEle, ListNode list){
            this.firstEle = firstEle;
            this.list = list;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        PriorityQueue<PQList> pq = new PriorityQueue<>((a,b)->Integer.compare(a.firstEle,b.firstEle));
        for(ListNode l:lists){
            pq.add(new PQList(l.val,l));
        }
        ListNode first = pq.remove().list;
        while(!pq.isEmpty()){
            ListNode second = pq.remove().list;
            first = merge(first,second);
        }
        return first;
    }
    public ListNode merge(ListNode first,ListNode second){
        if(first==null)return second;
        if(second==null)return first;
        ListNode result =  new ListNode(0);
        ListNode dummy = result;
        ListNode currFirst = first;
        ListNode currSecond = second;
        while(currFirst!=null && currSecond!=null){
            int fvalue = currFirst.val;
            int svalue  = currSecond.val;

            if(fvalue<svalue){
                ListNode temp = currFirst.next;
                currFirst.next = null;
                dummy.next = currFirst;
                currFirst = temp;
            } else {
                ListNode temp = currSecond.next;
                currSecond.next = null;
                dummy.next = currSecond;
                currSecond = temp;
            }
                dummy = dummy.next;

        }
        if(currFirst==null)dummy.next = currSecond;
        if(currSecond==null)dummy.next = currFirst;

        return result.next;
    }
}
