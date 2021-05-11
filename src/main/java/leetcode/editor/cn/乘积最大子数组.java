package leetcode.editor.cn;

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1023 👎 0

public class 乘积最大子数组{
	public static void main(String[] args) {
		Solution solution = new 乘积最大子数组().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
		int maxF = nums[0], minF = nums[0], ans = nums[0];
		int length = nums.length;
		for (int i = 1; i < length; ++i) {
			int mx = maxF, mn = minF;
			maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
			minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
			ans = Math.max(maxF, ans);
		}
		return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}