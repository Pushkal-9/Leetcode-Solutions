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
        int carry = 0;

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(l1!=null && l2!=null){
            int sum = carry + l1.val+l2.val;
            carry = sum/10;
            sum = sum%10;
            ListNode node = new ListNode(sum);
            current.next = node;
            current = current.next;
            l1=l1.next;
            l2=l2.next;
        }

        if(l2!=null){
            l1=l2;
        }

        while(l1!=null){
            if(carry==0){
                current.next=l1;
                return dummy.next;
            }
            int sum =carry + l1.val;
            carry=sum/10;
            sum=sum%10;
            ListNode node = new ListNode(sum);
            current.next = node;
            current = current.next;
            l1=l1.next;   

        }

        if(carry!=0){
            ListNode node = new ListNode(carry);
            current.next = node;
            current = current.next;
        }

        return dummy.next;
    }
}