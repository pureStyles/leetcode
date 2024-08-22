package Link;

public class Solution_0822 {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 == null) {
                sum = 0 + l2.val;
            }
            if (l2 == null) {
                sum = l1.val + 0;
            }
            if (sum >= 10) {
                result.val = (sum % 10);
                if (l1.next != null) {
                    // 逢10进一
                    l1.next.val += 1;
                } else {
                    l2.next.val += 1;
                }
            } else {
                result.val = sum;
            }
            l1 = l1.next;
            l2 = l2.next;
            addNode(result, 0);
        }
        return result;
    }

    public void addNode(ListNode head, int value) {
        // 增加一个节点
        while (head.next != null) {
            head = head.next;
        }
        ListNode newNode = new ListNode(value);
        head.next = newNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(100);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int left = l1 == null ? 0 : l1.val;
            int right = l2 == null ? 0 : l2.val;
            int sum = carry + left + right;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
        }
        return head.next;
    }
}
