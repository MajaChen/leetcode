package org.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node implements Comparable<Node>{
    int x;
    int y;
    int v;
    
    Node(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }
    
    public int compare(Node n1, Node n2) {
        return n1.y != n2.y ? n1.y - n2.y : n1.x != n2.x ? n1.x - n2.x : n1.v - n2.v;
    }
    
    @Override
    public int compareTo(Node o) {
        return y != o.y ? y - o.y : x != o.x ? x - o.x : v - o.v;
    }
}


public class Main {
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int counter = 0;
        for (int i = 0; i < weights.length; ) {
            int j = i;
            int sum = 0;
            while(j < weights.length && sum+weights[j] <= capacity) {
                sum += weights[j];
                j++;
            }
            counter += 1;
            i = j;
        }
        
        return counter <= days;
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        m.canShip(new int[]{1,2,3,4,5,6,7,8,9,10}, 5, 15);
       
       
    }
}