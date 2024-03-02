//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2694 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> mappings = new HashMap<>();
        mappings.put('2', Arrays.asList("a", "b", "c"));
        mappings.put('3', Arrays.asList("d", "e", "f"));
        mappings.put('4', Arrays.asList("g", "h", "i"));
        mappings.put('5', Arrays.asList("j", "k", "l"));
        mappings.put('6', Arrays.asList("m", "n", "o"));
        mappings.put('7', Arrays.asList("p", "q", "r", "s"));
        mappings.put('8', Arrays.asList("t", "u", "v"));
        mappings.put('9', Arrays.asList("w", "x", "y", "z"));
        
        List<String> finalList = new ArrayList<>();
        finalList.add("");
        for (int i = digits.length()-1; i >= 0; i--) {
            List<String> subList = mappings.get(digits.charAt(i));
            List<String> newList = new ArrayList<>();
            for(String suffix : finalList) {
                for (String s : subList) {
                    newList.add(s + suffix);
                }
            }
            finalList = newList;
        }
        return finalList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
