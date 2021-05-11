package leetcode.editor.cn;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 234 👎 0

public class 滑动窗口的最大值{
	public static void main(String[] args) {
		Solution solution = new 滑动窗口的最大值().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 0 || k == 0) return new int[0];
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		// 未形成窗口
		for(int i = 0; i < k; i++) {
			while(!deque.isEmpty() && deque.peekLast() < nums[i])
				deque.removeLast();
			deque.addLast(nums[i]);
		}
		res[0] = deque.peekFirst();
		// 形成窗口后
		for(int i = k; i < nums.length; i++) {
			if(deque.peekFirst() == nums[i - k])
				deque.removeFirst();
			while(!deque.isEmpty() && deque.peekLast() < nums[i])
				deque.removeLast();
			deque.addLast(nums[i]);
			res[i - k + 1] = deque.peekFirst();
		}
		return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
class Solution1 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		if(len<k || k==0){
			return new int[0];
		}
		int[] ret = new int[len - k + 1];
		int index = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<> ((x, y) -> y - x);
		for(int i = 0; i < k; i++){
			heap.add(nums[i]);
		}
		ret[index++] = heap.peek();
		for(int i = k; i < len; i++){
			heap.add(nums[i]);
			heap.remove(nums[i-k]);
			ret[index++] = heap.peek();
		}
		return ret;
	}
}
}