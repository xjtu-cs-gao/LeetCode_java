package leetcode.editor.cn;

//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 128 👎 0

public class 扑克牌中的顺子{
	public static void main(String[] args) {
		Solution solution = new 扑克牌中的顺子().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
		if (nums.length < 5)
			return false;

		Arrays.sort(nums);

		// 统计癞子数量
		int cnt = 0;
		for (int num : nums)
			if (num == 0)
				cnt++;

		// 使用癞子去补全不连续的顺子
		for (int i = cnt; i < nums.length - 1; i++) {
			if (nums[i + 1] == nums[i])
				return false;
			cnt -= nums[i + 1] - nums[i] - 1;
		}

		return cnt >= 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}