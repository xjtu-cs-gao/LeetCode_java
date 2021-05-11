package leetcode.editor.cn;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1311 👎 0

public class 组合总和{
	public static void main(String[] args) {
		Solution solution = new 组合总和().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<Integer> t = new ArrayList<>();
    	subcombination(candidates, target, t, 0);
    	return ans;
    }
    public void subcombination(int[] num, int target, List<Integer> t, int start){
    	if(target==0){
    		ans.add(new ArrayList<Integer>(t));
    		return;
		}
    	if(target<num[start]){
    		return;
		}
    	for(int i=start; i<num.length && num[i]<=target; i++){
    		t.add(num[i]);
    		subcombination(num, target-num[i], t, i);
    		t.remove(t.size()-1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}