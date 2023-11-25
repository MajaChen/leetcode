package org.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    Map<Character, Integer> mapping = new HashMap<>() {
        {
            put('{', 1);
            put('[', 2);
            put('(', 3);
            put('}', -1);
            put(']', -2);
            put(')', -3);
        }
    };

    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int x = mapping.get(s.charAt(i));
            if (x > 0) {
                stack.push(x);
            } else {
                Integer y = stack.peek();
                if (y != null && y + x == 0) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
