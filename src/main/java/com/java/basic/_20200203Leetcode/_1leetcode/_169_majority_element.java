package com.java.basic._20200203Leetcode._1leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/2/7.
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 示例 1:
 输入: [3,2,3]
 输出: 3

 示例 2:
 输入: [2,2,1,1,1,2,2]
 输出: 2

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/majority-element
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _169_majority_element {
    /**
     * 这个问题可以视为查找问题，对于查找问题往往可以使用时间复杂度为 O(1) 的
     * **哈希表**，通过以空间换时间的方式进行优化。
     * （1）直接遍历整个 **数组** ，将每一个数字（num）与它出现的次数（count）存放在
            哈希表中，
     * （2）同时判断该数字出现次数是否是最大的，动态更新 maxCount，最后输出 maxNum。

     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        Map<Integer,Integer>  map=new HashMap<>();
        //maxNum为众数，maxCount为众数出现的次数
        int maxNum=0,maxCount=0;
        for (int num : nums) {
            //如果没有，就是1；
            //如果有，则+1
            int count=map.getOrDefault(num,0)+1;
            map.put(num,count);
            if(count>maxCount){
                maxCount=count;
                maxNum=num;
            }
        }
        return maxNum;
    }
}
