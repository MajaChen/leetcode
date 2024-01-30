//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // 返回 False
//wordDictionary.search("bad"); // 返回 True
//wordDictionary.search(".ad"); // 返回 True
//wordDictionary.search("b.."); // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 25 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 10⁴ 次 addWord 和 search 
// 
//
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 533 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class TrieTreeNode {
    char c;
    Map<Character, TrieTreeNode> childern;
    boolean isLeaf;
    
    public TrieTreeNode(char c) {
        this.c = c;
        this.childern = new HashMap<>();
        this.isLeaf = false;
    }
}


class WordDictionary {
    TrieTreeNode root;

    public WordDictionary() {
        this.root = new TrieTreeNode('#');
    }
    
    public void addWord(String word) {
        TrieTreeNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char cc = word.charAt(i);
            TrieTreeNode q = p.childern.get(cc);
            if (q == null) {
                q = new TrieTreeNode(cc);
                p.childern.put(cc, q);
            }
            p = q;
        }
        
        p.isLeaf = true;
    }
    
    public boolean search(String word) {
        // 多加个字符兼容首字符
        return match("#" + word, 0, root);
    }
    
    // start位置的字符正好跟root节点对应
    private boolean match(String word, int start, TrieTreeNode root) {
        if (start == word.length() - 1) {
            if (root != null && root.isLeaf) {
                return true;
            } else {
                return false;
            }
        }
        
        if (root == null) {
            return false;
        }
        
        // 处理下一个节点
        char cc = word.charAt(start+1);
        if (cc == '.') {
            boolean isMatch = false;
            for (TrieTreeNode child : root.childern.values()) {
                isMatch |= match(word, start+1, child);
                if (isMatch) {
                    break;
                }
            }
            return isMatch;
        } else {
            return match(word, start+1, root.childern.get(cc));
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
