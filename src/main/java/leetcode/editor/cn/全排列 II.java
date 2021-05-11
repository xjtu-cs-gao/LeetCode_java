package leetcode.editor.cn;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 681 👎 0

public class 全排列 II{
	public static void main(String[] args) {
		Solution solution = new 全排列 II().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
    	Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		Arrays.fill(visited, false);
		List<Integer> t = new ArrayList<>();
		backtrace(nums, t, visited);
		return ans;
    }
    public void backtrace(int[] nums, List<Integer> t, boolean[] visited){
    	if(t.size() == nums.length){
    		ans.add(new ArrayList<Integer>(t));
		}
    	for(int i=0; i<nums.length; i++){
    		if(visited[i]==true){
    			continue;
			}else if(i>0 && nums[i] == nums[i-1] && visited[i-1]==false){
    			continue;
			}
    		t.add(nums[i]);
    		visited[i] = true;
    		backtrace(nums, t, visited);
    		t.remove(t.size()-1);
    		visited[i]=false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}