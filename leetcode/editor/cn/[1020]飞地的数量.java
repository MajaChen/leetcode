//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
// 
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 258 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class Result {
    boolean canExit;
    int count;
    
    Result(boolean canExit, int count) {
        this.canExit = canExit;
        this.count = count;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Result result = traverse(grid, i, j, m, n);
                    if (!result.canExit) {
                        counter += result.count;
                    }
                }
            }
        }
        
        return counter;
    }
    
    // dfs 函数
    // 输入：（i,j）
    // 输出： canExit 是否能走出去；count 表示岛的数量，canExit 为 true 返回 -1，0 表示海洋，正数表示陆地数量
    // 过程：0 返回 false，2 返回 true； 然后从上下左右四个方向展开遍历；最后设置一下结果，走的出去设2，走不出去设0
    
    private Result traverse(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j > n) {
            return new Result(true, -1);
        }
        if (grid[i][j] == 0 || grid[i][j] == -1) {
            return new Result(false, 0);
        }
        
        grid[i][j] = -1;// 表示正在进行遍历
        Result r1 = traverse(grid, i+1, j, m, n);
        Result r2 = traverse(grid, i-1, j, m, n);
        Result r3 = traverse(grid, i, j+1, m, n);
        Result r4 = traverse(grid, i, j-1, m, n);
        grid[i][j] = 0; // 无需再遍历
        if (r1.canExit || r2.canExit || r3.canExit || r4.canExit) {
            return new Result(true, -1);
        } else {
            return new Result(false, 1 + r1.count + r2.count + r3.count + r4.count);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
