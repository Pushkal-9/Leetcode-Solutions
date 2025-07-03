// Last updated: 02/07/2025, 20:21:42
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

        ListNode prev = new ListNode(-1);
        prev.next = head;

        ListNode second = prev;

        for(int i=0;i<n;i++){
            second = second.next;
        }

        ListNode first = prev;

        while(second.next!=null){
            first = first.next;
            second=second.next;
        }

        first.next = first.next.next;

        return prev.next;

    }
}