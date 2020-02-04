package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/4.
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:
 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。

 示例 2:
 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/plus-one
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _66_plus_one {
    /**
     * 思路：参考https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
     * 难点：全部为9的自己不会处理，参考写出处理思路
     * （1）除 9 之外的数字加一；
       （2）数字 9。
       （3)999999的特殊情况
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        for(int i=digits.length-1;i>=0;i--){
            digits[i]=(digits[i]+1)%10;
            if(digits[i]!=0){
                return digits;
            }
        }
        //当最高位为9的时候，进行手动处理情况
        int[] newdigits=new int[digits.length+1];
        newdigits[0]=1;
        return newdigits;
    }
}
