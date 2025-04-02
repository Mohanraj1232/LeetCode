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
    public ListNode reverseList(ListNode head) {
        ListNode res=null;
        ListNode temp=null;

        while(head!=null){
            temp=head;
            head=head.next;
            temp.next=res;
            res=temp;
        }

        return res;
    }
}