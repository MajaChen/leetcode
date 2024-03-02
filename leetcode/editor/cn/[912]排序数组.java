//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 966 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length -1);
        return nums;
    }
    
    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivotIndex = findPivot(nums, l, r);
        quickSort(nums, l, pivotIndex-1);
        quickSort(nums, pivotIndex+1, r);
    }
    
    // [5,2,3,1]
    private int findPivot(int[] nums, int l, int r) {
        int pivotIndex = l;
        int pivot = nums[pivotIndex];
        while (l < r) {
            while (l < r && nums[r] >= pivot) { r--;}
            nums[pivotIndex] = nums[r];
            pivotIndex = r;
            while(l < r && nums[l] <= pivot) { l++; }
            nums[pivotIndex] = nums[l];
            pivotIndex = l;
        }
        nums[pivotIndex] = pivot;
        return pivotIndex;
    }
    
    
}
//leetcode submit region end(Prohibit modification and deletion)
