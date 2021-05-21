package leetcode.editor.cn;

//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 499 👎 0

public class 划分字母区间{
	public static void main(String[] args) {
		Solution solution = new 划分字母区间().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
    	Map<Character, Integer> right = new HashMap<Character, Integer>();
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		right.put(c, i);
		}
    	List<Integer> res = new ArrayList<Integer>();
    	int l = 0, r = -1;
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		r = Math.max(r, right.get(c));
    		if(i == r) {
    			res.add(r - l + 1);
    			l = i + 1;
			}
		}
    	return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}