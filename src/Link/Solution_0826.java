package Link;

public class Solution_0826 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vNode = new ListNode(100);
        vNode.next = head;
        ListNode pre = vNode, next, cur;
        while (true) {
            cur = pre.next;
            next = cur;
            for (int i = 1; i <= n; i++) {
                next = next.next;
            }
            if (next == null) {
                break;
            }
            pre = pre.next;
        }
        // 此时的cur指着当前需要删除的节点
        pre.next = cur.next;
        return vNode.next;
    }
}
