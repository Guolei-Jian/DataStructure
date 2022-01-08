/* leetcode 删除一个链表中的所有元素

Defineition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {val = x;}
}
*/
public class Solution {
    public ListNode removeElement(ListNode head, int val) {

        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if(head == null)
            return null;

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            else{
                prev = prev.next;
            }
        }

        return head;
    }
}
// 实际提交的时候，可以不用删除，只需要移动指针，将要删除的节点断开就可以了。