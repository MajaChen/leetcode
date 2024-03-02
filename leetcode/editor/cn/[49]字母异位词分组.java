//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1744 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapping = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[(int)str.charAt(i) - 97]++;
            }
            String k = StringUtils.join(arr, "-");
            if (mapping.containsKey(k)) {
                mapping.get(k).add(str);
            } else {
                mapping.put(k, new ArrayList<>(Arrays.asList(str)));
            }
        }
        return new ArrayList<>(mapping.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
