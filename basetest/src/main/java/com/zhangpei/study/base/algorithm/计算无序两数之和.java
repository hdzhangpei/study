package com.zhangpei.study.base.algorithm;

import java.util.HashMap;
import java.util.Map;

public class 计算无序两数之和 {

    public static void main(String[] args) {

        int[] nums = {10, 25, 19, 89, 75, 56, 34, 54, 16, 9, -5};
        int[] results = twoSum(nums, 28);

        for (int result : results) {
            System.out.println(nums[result]);
        }
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            Integer current = nums[i];
            Integer newNum = target - current;
            if(null == map.get(newNum)) {
                map.put(current, i);
            } else {
                return new int[]{i, map.get(newNum)};
            }

        }

        return null;
    }
}
