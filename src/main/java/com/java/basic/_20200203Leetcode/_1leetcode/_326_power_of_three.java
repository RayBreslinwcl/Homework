package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/8.
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。

 示例 1:
 输入: 27
 输出: true

 示例 2:
 输入: 0
 输出: false

 示例 3:
 输入: 9
 输出: true

 示例 4:
 输入: 45
 输出: false
 进阶：
 你能不使用循环或者递归来完成本题吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/power-of-three
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _326_power_of_three {
    /**
     * 找出数字 n 是否是数字 b 的幂的一个简单方法是，n%3 只要余数为 0，就一直将 n 除以 b。

     n=b×b×…×b
     ​因此，应该可以将 n 除以 b x 次，每次都有 0 的余数，最终结果是 1。


     作者：LeetCode
     链接：https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {

        if(n<1){
            return false;
        }
        while (n%3==0){
            n/=3;
        }
        return n==1;
    }
}
