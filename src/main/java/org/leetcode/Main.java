package org.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {
    int[] nums;
    int sum;
    
    Result(int[] nums, int sum) {
        this.nums = nums;
        this.sum = sum;
    }
}

public class Main {
    
    private Result traverse(int[] nums, int len) {
        if (nums.length < len) {
            return new Result(nums, 0);
        }
        
        int sum = 0;
        int i;
        for (i = 0; i < len; i++) {
            sum += nums[i];
        }
        
        int k = 0;
        int maximalVal = sum;
        int r = i;
        for (; i < nums.length; i++) {
            sum -= nums[k++];
            sum += nums[i];
            if (sum > maximalVal) {
                maximalVal = sum;
                r = i + 1;
            }
        }
        
        int l = r - len;
        return new Result(Arrays.copyOfRange(nums, l, r), maximalVal);
    }
    
    
    public static void main(String[] args) {
        Main main = new Main();
        Result traverse = main.traverse(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1);
        
        
    }
}

