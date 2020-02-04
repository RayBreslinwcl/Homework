package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/4.
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:
 输入: [2,2,1]
 输出: 1

 示例 2:
 输入: [4,1,2,1,2]
 输出: 4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/single-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class _136_single_number {
    /**
     * 思路：采用异或操作符
     * 1.理解异或操作符：^是异或运算符，异或的规则是转换成二进制比较，相同为0，不同为1.
     * 2.因为条件为其他只出现两次，所以采用异或结果就是只出现1次的数字
     * 参考：https://leetcode-cn.com/problems/single-number/submissions/
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

//        if(nums.length==0){
//            return 0;
//        }
        int res=nums[0];
        for (int i=1;i<nums.length;i++){
            res=res^nums[i];
        }
        return res;
    }

}
