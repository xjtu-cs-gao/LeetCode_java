package leetcode.editor.cn;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 动态规划 
// 👍 792 👎 0

public class 分割等和子集{
	public static void main(String[] args) {
		Solution solution = new 分割等和子集().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean canPartition(int[] nums) {
		int sum = computeArraySum(nums);
		if (sum % 2 != 0) {
			return false;
		}
		int W = sum / 2;
		boolean[] dp = new boolean[W + 1];
		dp[0] = true;
		for (int num : nums) {                 // 0-1 背包一个物品只能用一次
			for (int i = W; i >= num; i--) {   // 从后往前，先计算 dp[i] 再计算 dp[i-num]
				dp[i] = dp[i] || dp[i - num];
			}
		}
		return dp[W];
	}

	private int computeArraySum(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}