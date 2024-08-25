package Link;

import java.util.HashMap;
import java.util.Map;

public class Solution_0825 {
    public ListNode copyRandomList(ListNode head) {
        ListNode cur = head;
        Map<ListNode, ListNode> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) {
            return head;
        }
        if (left == right) {
            return head;
        }
        ListNode cur = head;
        int index = 1;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, new ListNode(1000));
        while (cur != null) {
            map.put(index, new ListNode(cur.val));
            index++;
            cur = cur.next;
        }
        map.get(left - 1).next = map.get(right);
        if (index > right + 1) {
            map.get(left).next = map.get(right + 1);
        }
        if (left > 1) {
            map.get(0).next = map.get(1);
        }
        for (int i = 1; i < left - 1; i++) {
            map.get(i).next = map.get(i + 1);
        }
        for (int i = right; i > left; i--) {
            map.get(i).next = map.get(i - 1);
        }
        for (int i = right + 1; i < index - 1; i++) {
            map.get(i).next = map.get(i + 1);
        }

        return map.get(0).next;
    }
}
