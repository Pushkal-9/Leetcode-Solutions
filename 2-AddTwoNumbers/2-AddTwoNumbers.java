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
        int sum = 0;
        int carry = 0;

        ListNode node = new ListNode(-1);
        ListNode head = node;

        while(l1!=null && l2!=null){
            sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val +l2.val + carry)/10;

            node.next = new ListNode(sum);
            node=node.next;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            sum = (l1.val + carry) % 10;
            carry = (l1.val + carry)/10;

            node.next = new ListNode(sum);
            node=node.next;
            l1=l1.next;
        }

        while(l2!=null){
            sum = (l2.val + carry) % 10;
            carry = (l2.val + carry)/10;

            node.next = new ListNode(sum);
            node=node.next;
            l2=l2.next;
        }

        if(carry!=0){
            node.next = new ListNode(carry);
        }

        return head.next;
    }
}