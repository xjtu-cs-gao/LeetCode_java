package leetcode.editor.cn;

//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 280 👎 0

public class 平方数之和{
	public static void main(String[] args) {
		Solution solution = new 平方数之和().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {
		int left = 0;
		int right = (int)Math.sqrt(c);
		while(left<=right){
			int sum = left * left + right * right;
			if(sum == c){
				return true;
			}
			else if(sum > c){
				right --;
			}
			else{
				left++;
			}
		}
		return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}