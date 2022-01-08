public class Solution3 {
    // 使用递归
    public ListNode removeElements(ListNode head, int val) {

        if(head == null)
            return null;

        ListNode res = removeElements(head.next, val);
        if(head.val == val)
            return res;
        else{
            head.next = res;
            return head;
        }

    }
}
