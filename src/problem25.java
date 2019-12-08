import java.util.Stack;

/**
 * @Auther: Administrator
 * @Date: 2019/12/8 13:01
 * @Description:
 */
public class problem25 {
//    public ListNode reverseKGroup(ListNode head, int k) {
//        Stack<ListNode> stack = new Stack<>();
//        ListNode nodeStart = null;
//        ListNode temp = null;
//        ListNode res = new ListNode(-1);
//        ListNode node = null;
//        for (int i = 0; i < k && head != null; i++) {
//            if (i == k - 1) {
//                i = -1;
//                node = new ListNode(head.val);
//                nodeStart = node;
//                while (!stack.isEmpty()) {
//                    temp = stack.pop();
//                    node.next = temp;
//                    node = node.next;
//                    node.next = null;
//                }
//                while (res.next != null) {
//                    res = res.next;
//                }
//                node.next = head.next;
//                res.next = nodeStart;
//            } else {
//                stack.push(head);
//            }
//            head = head.next;
//
//        }
//        return nodeStart;
//    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(-1);
        ListNode start=res  ;
        boolean flag = true;
        ListNode temp = head;
        while (head != null && flag) {
            int i = 0;
            for (i = 0; i < k; i++) {
                if (i == 0) {
                    temp = head;
                }
                if (head == null) {
                    flag = false;
                    break;
                } else {
                    head = head.next;
                }
            }
            while (res.next != null) {
                res = res.next;
            }
            if (i == k) {
                res.next = reverse(temp, k);
                if(start==null){
                    start=res;
                }
            } else {
                while (temp != null) {
                    res.next = temp;
                    res = res.next;
                    temp = temp.next;
                }
            }
        }
        return start.next;
    }

    private ListNode reverse(ListNode param, int k) {
        ListNode temp;
        if (k == 1) {
            param.next = null;
            return param;
        } else {
            ListNode res = reverse(param.next, k - 1);
            temp = res;
            while (res.next != null) {
                res = res.next;
            }
            res.next = param;
            res.next.next = null;
            return temp;
        }
    }

    public static void main(String[] args) {
        ListNode res = new problem25().reverseKGroup(null, 1);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println();
    }
}
