//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1597 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int maxSquare = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    int x = dp[i-1][j];
                    int y = dp[i][j-1];
                    int z = dp[i-1][j-1];
                    dp[i][j] = x;
                    if (y < dp[i][j]) {
                        dp[i][j] = y;
                    }
                    if (z < dp[i][j]) {
                        dp[i][j] = z;
                    }
                    dp[i][j] += 1;
                    
                    if (dp[i][j] * dp[i][j] > maxSquare) {
                        maxSquare = dp[i][j] * dp[i][j];
                    }
                }
            }
        }
        
        return maxSquare;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
