package com.zhangpei.study.base.binarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 二分查找算法
 */
public class BinarySearchAlgorithm {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 14, 21, 24, 123);

        int key = 5;

        System.out.println(Collections.binarySearch(list, key));

        System.out.println(customerBinarySearch(list, key));
    }

    private static int customerBinarySearch(List<Integer> list, int key) {
        int min = 0;
        int max = list.size() - 1;

        while (min <= max) {
            // 取中间索引号
            int mid = (min + max) >>> 1;

            // 取之间值与key比较
            Integer num = list.get(mid);
            int result = num.compareTo(key);

            // 取值大于key,则说明大了,把中间值作为最大值进行下一步查找;    取值小于key,则说明小了,把中间值作为最小值进行下一步查找;   相等返回索引号.不相等返回负数.
            if (result > 0) {
                max = mid - 1;
            } else if (result < 0) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -(min + 1);
    }
}
