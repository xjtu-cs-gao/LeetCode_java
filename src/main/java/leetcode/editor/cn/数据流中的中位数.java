package leetcode.editor.cn;

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/ 
// Related Topics 堆 设计 
// 👍 123 👎 0

public class 数据流中的中位数{
	public static void main(String[] args) {
		Solution solution = new 数据流中的中位数().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
	PriorityQueue<Integer> qmax;
	PriorityQueue<Integer> qmin;
    /** initialize your data structure here. */
    public MedianFinder() {
        qmax = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        qmin = new PriorityQueue<Integer> ();
    }
    
    public void addNum(int num) {
        if(qmax.size()==0 && qmin.size()==0){
            qmax.add(num);
        }else{
            if(num>qmax.peek()){
                qmin.add(num);
                if(qmax.size()<qmin.size()){
                    qmax.add(qmin.poll());
                }
            }else{
                qmax.add(num);
                if(qmax.size()-qmin.size()==2){
                    qmin.add(qmax.poll());
                }
            }
        }
    }
    
    public double findMedian() {
        if(qmax.size()==0 && qmin.size()==0){
            return 0;
        }
        if(qmin.size() < qmax.size()){
            return qmax.peek();
        }else{
            double sum = qmax.peek() + qmin.peek();
            return sum/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}