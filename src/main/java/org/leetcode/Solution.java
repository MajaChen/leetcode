package org.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private static class Pair {
        String x;
        String y;
        
        public Pair(String i, String j) {
            this.x = i;
            this.y = j;
        }
        
        @Override
        public String toString() {
            return x + ", " + y;
        }
    }
    
    public int subset(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        
        int counter = 0;
        // 在 i 指示的字符后面插入小数点
        // (0.0 1.0 1.20) (01.1)
        for (int i = 0; i < n - 1; i++) {
            if(s.charAt(n-1) == '0') {
                continue;
            }
            if (s.charAt(0) == '0' && i != 0) {
                continue;
            }
            counter++;
        }
        
        // 不加小数点的情况
        // (00, 01, 0001)
        if (s.charAt(0) != '0') {
            counter++;
        }
        
        return counter;
    }
    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        // 在 i 指示的字符后面插入空格进行分割
        for (int i = 0; i < s.length() - 1; i++) {
            int x = subset(s.substring(0, i+1));
            int y = subset(s.substring(i+1, s.length()));
            if (x * y > 0) {
                Pair pair = new Pair(s.substring(0, i+1), s.substring(i + 1, s.length()));
                ans.add(pair.toString());
            }
        }
        
        return ans;
    }
}

