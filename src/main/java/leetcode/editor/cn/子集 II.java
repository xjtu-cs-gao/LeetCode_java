package leetcode.editor.cn;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 550 👎 0

public class 子集 II{
	public static void main(String[] args) {
		Solution solution = new 子集 II().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	List<List<Integer>> ans = new ArrayList<List<Integer>> ();
	List<Integer> t = new ArrayList<> ();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		backtrace(true, 0, nums);
		return ans;
    }

    public void backtrace(boolean flag, int i, int[] nums){
    	if(i == nums.length){
    		ans.add(new ArrayList<Integer>(t));
    		return;
		}
		backtrace(false, i+1, nums);
    	if(!flag && i > 0 && nums[i]==nums[i-1]){
    		return;
		}
    	t.add(nums[i]);
    	backtrace(true, i+1, nums);
    	t.remove(t.size() - 1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
