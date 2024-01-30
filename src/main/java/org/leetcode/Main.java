package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class Main {
    
    Map<Integer, Integer> mappings = new HashMap<>();
    
    private int traverse(int num) {
        if (mappings.containsKey(num)) {
            return mappings.get(num);
        }
        
        int k = (int) Math.sqrt((double) num);
        int m = Integer.MAX_VALUE;
        for (int i = k; i >= 1; i--) {
            int j = num - (int)Math.pow((double)i, 2D);
            int n = traverse(j);
            if (n < m) {
                m = n;
            }
        }
        
        mappings.put(num, m+1);
        return mappings.get(num);
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.mappings.put(0, 0);
        int i = main.traverse(3);
        System.out.println(i);
    }
}