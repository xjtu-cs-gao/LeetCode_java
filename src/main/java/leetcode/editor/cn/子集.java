package leetcode.editor.cn;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1109 👎 0

public class 子集{
	public static void main(String[] args) {
		Solution solution = new 子集().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<Integer> t = new ArrayList<> ();
	List<List<Integer>> ans = new ArrayList<List<Integer>> ();

    public List<List<Integer>> subsets(int[] nums) {
    	backtrace(0, nums);
    	return ans;
    }
    public void backtrace(int i, int[] nums){
    	if(i == nums.length){
    		ans.add(new ArrayList<Integer>(t));
    		return;
		}
    	t.add(nums[i]);
    	backtrace(i+1, nums);
    	t.remove(t.size()-1);
    	backtrace(i+1, nums);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
