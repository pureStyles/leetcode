package Link;

import java.util.List;
import java.util.Stack;

public class Solution_0826 {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode vNode = new ListNode(1000);
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode vNode = new ListNode(1000);
        vNode.next = head;
        ListNode pre = vNode, cur, next;
        while (pre != null) {
            cur = pre.next;
            next = cur.next;
            while (next.val == cur.val) {
                next = next.next;
            }
            pre.next = next;
            pre = pre.next;
        }
        return vNode.next;
    }

    public ListNode removeDuplicates(ListNode head) {
        ListNode vNode = new ListNode(1000);
        vNode.next = head;
        ListNode cur = vNode;
        int x = 10000;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == x || cur.next.val == cur.next.next.val) {
                // 遇到重复的节点值，需要作删除操作
                x = cur.next.val; // 重复的值记为x
                cur.next = cur.next.next;

            } else {
                cur = cur.next;
            }
        }
        if (cur.next != null && cur.next.next == null && cur.next.val == x) {
            cur.next = null;
        }
        return vNode.next;
    }

}
