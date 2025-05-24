// Last updated: 23/05/2025, 19:52:27
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(mid);

        return merge(list1,list2);
    }

    public ListNode getMid(ListNode node){
        ListNode slow = node;
        ListNode fast = node;

        ListNode prev = new ListNode(-1);

        while(slow!=null && fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        return slow;
    }

    public ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(-1);

        ListNode cur = dummy;

        while(node1!=null && node2!=null){
            if(node1.val < node2.val){
                cur.next = node1;
                cur = cur.next;
                node1=node1.next;
            }
            else{
                cur.next = node2;
                cur = cur.next;
                node2 = node2.next;
            }
        }

        while(node1!=null){
            cur.next = node1;
            cur = cur.next;
            node1=node1.next;            
        }

        while(node2!=null){
            cur.next = node2;
            cur = cur.next;
            node2 = node2.next;            
        }

        return dummy.next;
    }
}