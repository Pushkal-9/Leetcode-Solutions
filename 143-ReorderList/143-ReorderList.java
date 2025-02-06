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
        ListNode fast = head;

        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }


        ListNode head2 = reverse(slow);
        ListNode head1 = head;
        ListNode current = new ListNode(-1);

        while(head1!=null && head2!=null){
            current.next=head1;
            head1=head1.next;
            current.next.next=head2;
            head2=head2.next;
            current=current.next.next;
        }

        if(head2!=null){
            current.next=head2;
            head2.next=null;
        }


        
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while(current!=null){
            ListNode next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        return prev;
    }


}