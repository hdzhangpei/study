package com.zhangpei.study.base.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * N级台阶，一次上1级或2级或3级，总共有多少种走法
 */
public class N级台阶几种走法 {
    public static void main(String[] args) {
        System.out.println(calculate(5, new HashMap<Integer, Integer>()));
    }

    private static int calculate(int stair, Map<Integer, Integer> map) {
        if(stair == 1){
            return 1;
        }else if(stair == 2){
            return 2;
        }else if(stair == 3){
            return 4;
        }else if(map.containsKey(stair)){
            return map.get(stair);
        }else{
            int temp = calculate(stair - 1,map)+calculate(stair - 2,map)+calculate(stair - 3,map);
            map.put(stair, temp);
            return temp;
        }
    }

}
