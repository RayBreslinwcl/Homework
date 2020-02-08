package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/8.
 */
public class _191_number_of_1_bits {
    /**
     * 方法 1：循环和位移动
     算法

     这个方法比较直接。我们遍历数字的 32 位。如果某一位是 11 ，将计数器加一。

     我们使用 位掩码 来检查数字的第 i 位。一开始，掩码 m=1m=1 因为 11 的二进制表示是
     0000 0000 0000 0000 0000 0000 0000 0001

     显然，任何数字跟掩码 11 进行逻辑与运算，都可以让我们获得这个数字的最低位。检查下一位时，我们将掩码左移一位。
     0000 0000 0000 0000 0000 0000 0000 0010

     并重复此过程。

     作者：LeetCode
     链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int hammingWeight(int n) {
        int bits=0;  //计数
        int mask=1; //掩码
        for (int i = 0; i < 32; i++) {
            if((n&mask)!=0){
                bits++;
            }
            mask<<=1; //向左移动1
        }
        return bits;
    }
}
