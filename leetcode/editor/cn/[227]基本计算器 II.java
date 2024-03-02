//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
//
// Related Topics 栈 数学 字符串 👍 741 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
     * 更低优先级去触发运算：
     * * / 由 + - # 触发
     * + - 由 # 触发
     *
     * $:最低优先级
     * #:最低优先级
     * 新的符号比栈顶符号要小则触发栈顶符号进行运算
     * */
    public int calculate(String s) {
        Map<Character, Integer> priorityMapping = new HashMap<>();
        priorityMapping.put('$', 0);
        priorityMapping.put('+', 1);
        priorityMapping.put('-', 1);
        priorityMapping.put('*', 2);
        priorityMapping.put('/', 2);
        priorityMapping.put('#', 0);
        s = "$" + s + "#";
        
        Stack<Integer> nums = new Stack<>();
        Stack<Character> operators = new Stack<>();
        operators.push('$');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                nums.push(Character.getNumericValue(c));
            } else {
                while (priorityMapping.get(c) < priorityMapping.get(operators.peek()) && operators.peek() != '$') {
                    char operator = operators.pop();
                    int x = nums.pop();
                    int y = nums.pop();
                    switch (operator) {// 使用switch语句的时候，一定要注意break
                        case '+':
                            nums.push(x + y);
                            break;
                        case '-':
                            nums.push(y - x);
                            break;
                        case '*':
                            nums.push(x * y);
                            break;
                        case '/':
                            nums.push(y / x);
                    }
                }
                operators.push(c);
            }
            
        }
        return nums.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
