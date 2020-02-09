package com.java.basic._20200203Leetcode._1leetcode;

import java.util.HashSet;

/**
 * Created by Administrator on 2020/2/9.
 * 给定两个数组，编写一个函数来计算它们的交集。

 示例 1:
 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2]

 示例 2:
 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出: [9,4]

 说明:
 输出结果中的每个元素一定是唯一的。
 我们可以不考虑输出结果的顺序。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _349_intersection_of_two_arrays {
    /**
     * 方法二：内置函数
     内置的函数在一般情况下的时间复杂度是 O(n+m)O(n+m) 且时间复杂度最坏的情况是 O(n \times m)O(n×m) 。

     在 Python 中提供了交集的操作，在 Java 提供了 retainAll() 函数.

     作者：LeetCode
     链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/liang-ge-shu-zu-de-jiao-ji-by-leetcode/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=new HashSet<>();
        for (Integer n:nums1) set1.add(n);
        HashSet<Integer> set2=new HashSet<>();
        for (Integer n:nums2) set2.add(n);
        //求交集
        set1.retainAll(set2);
        int[] output=new int[set1.size()];
        int index=0;
        for (int s:set1) output[index++]=s;
        return output;

    }
}
