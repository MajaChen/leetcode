//给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。 
//
// 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和 bi的人归入同一组。当可以用
//这种方法将所有人分进两组时，返回 true；否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
//输出：true
//解释：group1 [1,4], group2 [2,3]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2000 
// 0 <= dislikes.length <= 10⁴ 
// dislikes[i].length == 2 
// 1 <= dislikes[i][j] <= n 
// ai < bi 
// dislikes 中每一组都 不同 
// 
//
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 393 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    private Map<Integer, Set<Integer>> dislikeMapping = new HashMap<>();
    
    private boolean containsAny(Set<Integer> set, Set<Integer> another) {
        if (set == null || another == null) {
            return false;
        }
        
        for (int i : another) {
            if (set.contains(i)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isCompatible(Set<Integer> set, Map<Integer, Set<Integer>> dislikeMapping) {
        for (int i : set) {
            if (containsAny(dislikeMapping.get(i), set)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        for (int[] dislike : dislikes) {
            if (dislikeMapping.containsKey(dislike[0])) {
                dislikeMapping.get(dislike[0]).add(dislike[1]);
            } else {
                dislikeMapping.put(dislike[0], new HashSet<>(List.of(dislike[1])));
            }
            dislikeMapping.computeIfAbsent(dislike[0], HashSet::new).add(dislike[1]);
        }
        
        Iterator<Map.Entry<Integer, Set<Integer>>> iterator = dislikeMapping.entrySet().iterator();
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Set<Integer>> next = iterator.next();
            if (left.contains(next.getKey()) || right .contains(next.getKey())) {
                continue;
            }
            if (!containsAny(left, next.getValue()) && isCompatible(next.getValue(), dislikeMapping)) {
                left.add(next.getKey());
                right.addAll(next.getValue());
            } else if (!containsAny(right, next.getValue()) && isCompatible(next.getValue(), dislikeMapping)) {
                right.add(next.getKey());
                left.addAll(next.getValue());
            } else {
                return false;
            }
        }
        
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
