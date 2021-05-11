package leetcode.editor.cn;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 246 👎 0

public class 和为s的连续正数序列{
	public static void main(String[] args) {
		Solution solution = new 和为s的连续正数序列().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
    	int i = 1;
    	int j = 1;
    	int sum = 0;
    	List<int[]> res = new ArrayList<>();

    	while(i <= target/2){
    		if(sum<target){
    			sum += j;
    			j++;
			}else if(sum > target){
    			sum -= i;
    			i++;
			}else{
    			int[] array = new int[j-i];
    			for(int k=i; k<j; k++){
    				array[k-i] = k;
				}
    			res.add(array);
    			sum -= i;
    			i++;
			}
		}
    	return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}