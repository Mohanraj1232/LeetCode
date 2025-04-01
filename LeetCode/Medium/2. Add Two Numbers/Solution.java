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
        int carry=0;
        ListNode res=null,temp=null;

        while(l1!=null || l2!=null){
            int val=(carry);
            if(l1!=null){
                val+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val+=l2.val;
                l2=l2.next;
            }
            carry=val/10;
            ListNode node=new ListNode(val%10);
            if(res==null){
                res=node;
                temp=node;
            }else{
                temp.next=node;
                temp=temp.next;
            }
            
        }
        if(carry==1){
            temp.next=new ListNode(1);
        }

        return res;
    }

    
}