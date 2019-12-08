/**
 * @Auther: Administrator
 * @Date: 2019/12/8 10:58
 * @Description:
 */
public class problem242 {
    public boolean isAnagram(String s, String t) {
        // 由于题目中指出只存在小写字母,因此只需要大小为26的数组来存储字符出现的次数
        int[] count = new int[26];
        // 游标,用于遍历字符串和数组时使用
        int i = 0;
        // 遍历字符串1,统计各字母出现次数,对应下标的值加1
        for (i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // 遍历字符串2,统计各字母出现次数,对应下标的值减1
        for (i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        // 遍历数组,判断字母出现次数是否相等
        for (i = 0; i < count.length; i++) {
            // 当数组值不为0,必然有无法抵消次数的字母出现,返回false
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new problem242().isAnagram("a", "b"));
    }
}
