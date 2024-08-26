package Link;

import java.util.List;
import java.util.Stack;

public class Solution_0826 {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vNode = new ListNode(1000);
        vNode.next = head;
        ListNode cur = vNode;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 1; i <= n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return vNode.next;
    }
}
