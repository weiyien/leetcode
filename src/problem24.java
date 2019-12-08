/**
 * @Auther: Administrator
 * @Date: 2019/12/8 10:59
 * @Description:
 */
public class problem24 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = null, res = null, temp = null;
        res = new ListNode(-1);
        res.next = head;
        pre = res;
        while (pre.next != null && pre.next.next != null) {
            temp=pre.next.next;
            pre.next.next=temp.next;
            temp.next=pre.next;
            pre.next=temp;
            pre=temp.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode res = new problem24().swapPairs(head);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}