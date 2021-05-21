package leetcode.editor.cn;

//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。 
// Related Topics 二分查找 
// 👍 236 👎 0

public class 有序数组中的单一元素{
	public static void main(String[] args) {
		Solution solution = new 有序数组中的单一元素().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {
		int l = 0, h = nums.length - 1;
		while (l < h) {
			int m = l + (h - l) / 2;
			if (m % 2 == 1) {
				m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
			}
			if (nums[m] == nums[m + 1]) {
				l = m + 2;
			} else {
				h = m;
			}
		}
		return nums[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}