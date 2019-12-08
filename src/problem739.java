import java.util.Stack;

/**
 * @Auther: Administrator
 * @Date: 2019/12/8 16:41
 * @Description:
 */
public class problem739 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                boolean flag = true;
                while (flag&&!stack.isEmpty()) {
                    int temp = stack.peek();
                    if (T[i] > T[temp]) {
                        res[temp] = i - temp;
                        stack.pop();
                    } else {
                        stack.push(i);
                        flag = false;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = new problem739().dailyTemperatures(temp);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
