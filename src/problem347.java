import java.util.*;

/**
 * @Auther: Administrator
 * @Date: 2019/12/24 21:42
 * @Description:
 */
public class problem347 {
        public List<Integer> topKFrequent(int[] nums, int k) {
            // 先计算出每个元素出现的次数
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], (null == map.get(nums[i]) ? 0 : map.get(nums[i])) + 1);
            }
            // 构建最小堆,通过比较器保证出现频率小的元素在最后
            // 堆中存放出现的元素,通过map获取其值
            PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return map.get(o1) - map.get(o2);
                }
            });
            // 把元素值加入最小堆
            for (Integer key : map.keySet()) {
                heap.add(key);
                // 题目要求为高频的k个元素,所以排名k之后的元素直接丢弃
                if (heap.size() > k) {
                    heap.remove();
                }
            }
            // 把结果转换为list
            List<Integer> res = new LinkedList<>();
            while (!heap.isEmpty()) {
                res.add(heap.remove());
            }
            // 因为PriorityQueue是最小堆,所以结果要反转
            // 为什么不用最大堆?因为PriorityQueue的peek和poll函数是返回队列中的最小值.所以只能这样了
            Collections.reverse(res);
            return res;
        }

    public static void main(String[] args) {
        new problem347().topKFrequent(new int[]{1, 2, 3, 4, 5, 3, 2, 2, 1}, 3);
    }
}
