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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){
            return head;
        }

        List<ListNode> list = new ArrayList<>();

        list.add(head);

        ListNode current = head;

        int count=0;

        ListNode prev =null;

        while(current!=null){
            count++;
            prev=current;
            current=current.next;
            if(count%k==0){
                list.add(current);
                prev.next=null;
            }
        }

        List<ListNode> reverseList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(i==list.size()-1 && count%k!=0){
                reverseList.add(list.get(i));
                break;
            }

            ListNode reversed = reverse(list.get(i));
            reverseList.add(reversed);
        }

        for(int i=0;i<reverseList.size()-1;i++){
            ListNode node = reverseList.get(i);
            while(node.next!=null){
                node=node.next;
            }
            node.next=reverseList.get(i+1);
        }

        return reverseList.get(0);

    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while(current!=null){
            ListNode next =current.next;
            current.next = prev;
            prev=current;
            current = next;
        }

        return prev;
    }
}