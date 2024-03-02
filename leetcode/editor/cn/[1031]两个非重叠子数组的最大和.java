//给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 
//firstLen 和 secondLen 。 
//
// 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。 
//
// 子数组是数组的一个 连续 部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
//输出：20
//解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
//输出：29
//解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
//输出：31
//解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= firstLen, secondLen <= 1000 
// 2 <= firstLen + secondLen <= 1000 
// firstLen + secondLen <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 滑动窗口 👍 275 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class Result {
    int[] nums;
    int sum;
    
    Result(int[] nums, int sum) {
        this.nums = nums;
        this.sum = sum;
    }
}

class Solution {
    
    // 截去 nums 中 lr 之间的部分，r 包含
    private int[] trim(int[] nums, int l, int r) {
        for (int i = r; i < nums.length; i++) {
            nums[l++] = nums[i];
        }
        
        return Arrays.copyOf(nums, l);
    }
    
    // 滑动窗口求最大子数组的长度
    private Result traverse(int[] nums, int len) {
        if (nums.length < len) {
            return new Result(nums, 0);
        }
        
        int sum = 0;
        int i;
        for (i = 0; i < len; i++) {
            sum += nums[i];
        }
        
        int k = 0;
        int maximalVal = sum;
        int r = i;
        for (; i < nums.length; i++) {
            sum -= nums[k++];
            sum += nums[i];
            if (sum > maximalVal) {
                maximalVal = sum;
                r = i + 1;
            }
        }
        
        int l = r - len;
        return new Result(trim(nums, l, r), maximalVal);
    }
    
    
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        Result traverse1 = traverse(nums, firstLen);
        int sum1 = traverse1.sum;
        sum1 += traverse(traverse1.nums, secondLen).sum;
        
        Result traverse2 = traverse(nums, secondLen);
        int sum2 = traverse2.sum;
        sum2 += traverse(traverse2.nums, firstLen).sum;
        
        return Math.max(sum1, sum2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
