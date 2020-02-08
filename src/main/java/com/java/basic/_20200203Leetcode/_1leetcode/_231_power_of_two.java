package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/8.
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

 示例 1:
 输入: 1
 输出: true
 解释: 20 = 1

 示例 2:
 输入: 16
 输出: true
 解释: 24 = 16

 示例 3:
 输入: 218
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/power-of-two
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _231_power_of_two {
    /**
     * 解题思路：
     1.若 n = 2^x 且 x 为自然数（即 n 为 2 的幂），则一定满足以下条件：
        （1）恒有 n & (n - 1) == 0，这是因为：
                n 二进制最高位为 1，其余所有位为 0；
                n−1 二进制最高位为 0，其余所有位为 1；
     2.一定满足 n > 0。

     2^x	n	n - 1	n & (n - 1)
     2^0    0001	0000	(0001) & (0000) == 0
     2^1    0010	0001	(0010) & (0001) == 0
     2^2    0100	0011	(0100) & (0011) == 0
     2^3    1000	0111	(1000) & (0111) == 0
     ...	...	...	...

     作者：jyd
     链接：https://leetcode-cn.com/problems/power-of-two/solution/power-of-two-er-jin-zhi-ji-jian-by-jyd/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     因此，通过 n > 0 且 n & (n - 1) == 0 即可判定是否满足 n = 2^x
     作者：jyd
     链接：https://leetcode-cn.com/problems/power-of-two/solution/power-of-two-er-jin-zhi-ji-jian-by-jyd/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
}
