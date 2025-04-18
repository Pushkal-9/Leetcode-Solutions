// Last updated: 18/04/2025, 17:21:57
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

        if(head==null){
            return head;
        }
        List<ListNode> list = new ArrayList<>();

        while(head!=null){
            list.add(head);
            head=head.next;
        }

        Collections.sort(list, (a,b) -> a.val-b.val);

        ListNode result = list.get(0);

        for(int i=0;i<list.size()-1;i++){
            list.get(i).next = list.get(i+1);
        }

        list.get(list.size()-1).next=null;

        return result;
    }
}