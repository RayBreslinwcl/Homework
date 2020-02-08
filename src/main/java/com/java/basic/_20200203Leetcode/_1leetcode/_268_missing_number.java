package com.java.basic._20200203Leetcode._1leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2020/2/8.
 */
public class _268_missing_number {
    /**
     * 方法二：哈希表
     分析

     我们可以直接查询每个数是否在数组中出现过来找出缺失的数字。如果使用哈希表，那么每一次查询操作都是常数时间的。

     算法
     我们将数组中的所有数插入到一个集合中，这样每次查询操作的时间复杂度都是 O(1)O(1) 的。

     作者：LeetCode
     链接：https://leetcode-cn.com/problems/missing-number/solution/que-shi-shu-zi-by-leetcode/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Set<Integer> numSet=new HashSet<>();
        for(int num:nums) numSet.add(num);

        int expectedNumCount=nums.length+1;
        for (int number = 0; number < expectedNumCount; number++) {
            if(!numSet.contains(number)){
                return number;
            }
        }
        return -1;
    }
}
