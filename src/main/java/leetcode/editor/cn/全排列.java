package leetcode.editor.cn;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1312 👎 0

public class 全排列{
	public static void main(String[] args) {
		Solution solution = new 全排列().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
    	List<Integer> output = new ArrayList<>();
    	for(int num : nums){
    		output.add(num);
		}
    	backtrace(output, 0);
    	return ans;
    }
    public void backtrace(List<Integer> output, int start){
    	if(start == output.size()){
    		ans.add(new ArrayList<Integer>(output));
    		return;
		}
    	for(int i = start; i<output.size(); i++){
    		Collections.swap(output, start, i);
    		backtrace(output, start+1);
    		Collections.swap(output, start, i);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}