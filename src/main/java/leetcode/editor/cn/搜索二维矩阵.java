package leetcode.editor.cn;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 374 👎 0

public class 搜索二维矩阵{
	public static void main(String[] args) {
		Solution solution = new 搜索二维矩阵().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int rows = matrix.length;
    	int columns = matrix[0].length;
    	int low = 0, high = rows * columns - 1;
    	while(low<=high){
    		int mid = (high + low) / 2;
    		int x = matrix[mid/columns][mid%columns];
    		if(x < target){
    			low = mid + 1;
			}else if(x > target){
    			high = mid - 1;
			}else{
    			return true;
			}
		}
    	return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}