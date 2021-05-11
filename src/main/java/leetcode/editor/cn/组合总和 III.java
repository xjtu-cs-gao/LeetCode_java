package leetcode.editor.cn;

//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 295 👎 0

public class 组合总和 III{
	public static void main(String[] args) {
		Solution solution = new 组合总和 III().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
    	List<Integer> t = new ArrayList<>();
    	backtrace(k, n, t, 1);
    	return ans;
    }
    public void backtrace(int k, int n, List<Integer> t, int start){
    	if(k==0 && n==0){
    		ans.add(new ArrayList<Integer>(t));
    		return;
		}
    	if(k==0 || n<0 || start>9){
    		return;
		}
    	t.add(start);
    	backtrace(k-1, n-start, t, start+1);
    	t.remove(t.size()-1);
    	backtrace(k, n, t, start+1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}