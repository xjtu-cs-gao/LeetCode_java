package leetcode.editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 219 👎 0

public class 最小的k个数{
	public static void main(String[] args) {
		Solution solution = new 最小的k个数().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
    	if(k==0){
    		return new int[0];
		}else if(arr.length <= k){
    		return arr;
		}
    	partitionArray(arr, 0, arr.length-1, k);

    	int[] res = new int[k];
    	for(int i =0; i < k; i++){
    		res[i] = arr[i];
		}
    	return res;
    }
    public void partitionArray(int[] arr, int l, int h, int k){
    	int m = partition(arr, l, h);
    	if(k==m){
    		return;
		}else if(k<m){
    		partitionArray(arr, l, m-1, k);
		}else{
    		partitionArray(arr, m+1, h, k);
		}
	}
	public int partition(int[] arr, int l, int r){
    	int i = l;
    	int j = r;
    	int v = arr[l];
    	while(i < j){
    		while(j > i && arr[j] > v){
    			j--;
			}
    		if(i < j){
    			arr[i++] = arr[j];
			}
    		while(i < j && arr[i] < v){
    			i++;
			}
    		if(i < j){
    			arr[j--] = arr[i];
			}
		}
    	arr[i] = v;
    	return i;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}