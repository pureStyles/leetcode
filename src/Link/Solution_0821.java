package Link;

import java.util.HashSet;
import java.util.Set;

public class Solution_0821 {
    public boolean hasCycle(ListNode head) {
        int valCount = 0;
        Set set = new HashSet<ListNode>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
