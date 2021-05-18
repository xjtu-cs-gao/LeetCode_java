package leetcode.editor.cn;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1075 👎 0

public class 数组中的第K个最大元素{
	public static void main(String[] args) {
		Solution solution = new 数组中的第K个最大元素().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	for(int num : nums) {
    		pq.add(num);
    		if(pq.size()>k){
    			pq.remove();
			}
		}
    	return pq.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 快速选择
class Solution1 {
	Random random = new Random();

	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, nums.length - k);
	}

	public int quickSelect(int[] a, int l, int r, int index) {
		int q = randomPartition(a, l, r);
		if (q == index) {
			return a[q];
		} else {
			return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
		}
	}

	public int randomPartition(int[] a, int l, int r) {
		int i = random.nextInt(r - l + 1) + l;
		swap(a, i, r);
		return partition(a, l, r);
	}

	public int partition(int[] a, int l, int r) {
		int x = a[r], i = l - 1;
		for (int j = l; j < r; ++j) {
			if (a[j] <= x) {
				swap(a, ++i, j);
			}
		}
		swap(a, i + 1, r);
		return i + 1;
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
}