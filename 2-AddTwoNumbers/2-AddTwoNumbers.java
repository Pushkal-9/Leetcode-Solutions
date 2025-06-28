// Last updated: 28/06/2025, 17:12:21
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
        ListNode head = new ListNode(-1);

        ListNode cur = head;

        int sum = 0;
        int carry = 0;

        while(l1!=null && l2!=null){
            sum = carry + l1.val + l2.val;
            carry = sum/10;
            sum = sum%10;

            ListNode node = new ListNode(sum);

            cur.next = node;

            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l2!=null){
            l1 = l2;
        }

        while(l1 != null){
            sum = carry + l1.val;
            carry = sum/10;
            sum = sum%10;

            ListNode node = new ListNode(sum);

            cur.next = node;
            cur = cur.next;  

            l1 = l1.next;  
        }

        if(carry!=0){
            ListNode node = new ListNode(carry);
            cur.next = node;
            cur = cur.next;            
        }

        return head.next;
    }
}