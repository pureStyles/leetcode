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
}
