package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/9.
 */
public class _342_power_of_four {
    /**
     * 方法1.最基本方法
     * @param num
     * @return
     */
    public boolean isPowerOfFour1(int num) {
//        if(num<=3&&num>1) return false;
        if(num==0) return false;
        while (num%4==0){
            num/=4;
        }
        return num==1;

    }


    /**
     * 方法2.算法：数学运算
     如果数字为 4 的幂 x = 4^ax=4
     x 是否为偶数就能判断 x 是否为 4 的幂。

     a=log4x=1/2log2x 应为整数，

     作者：LeetCode
     链接：https://leetcode-cn.com/problems/power-of-four/solution/4de-mi-by-leetcode/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public boolean isPowerOfFour2(int num) {
        return (num > 0) && (Math.log(num) / Math.log(2) % 2 == 0);

    }

    /**
     * 方法四：位运算 + 数学运算
     * 1.判断是否位2的次方
     * 2.判断mod3是否为1
     *
     */
    public boolean isPowerOfFour3(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }

}
