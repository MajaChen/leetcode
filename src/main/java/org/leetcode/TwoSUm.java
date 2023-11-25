package org.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TwoSUm {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapping = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mapping.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (mapping.containsKey(target-nums[i])) {
                return new int[]{i, mapping.get(target-nums[i])};
            }
        }

        return null;
    }
}
