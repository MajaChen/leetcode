//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2188 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    private int[] combine(int[] x, int[] y) {
        if (y[0] <= x[1]) {
            return new int[]{x[0], Math.max(x[1], y[1])};
        }
        return null;
    }
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        int[][] ints = new int[intervals.length][2];
        int k = 0;
        int[] target = intervals[0];
        int i = 1;
        for (; i < intervals.length; i++) {
            int[] combiendInterval = combine(target, intervals[i]);
            if (combiendInterval != null) {
                target = combiendInterval;
            } else {
                ints[k++] = target;
                target = intervals[i];
            }
        }
        ints[k++] = target;
        
        return Arrays.copyOf(ints, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
