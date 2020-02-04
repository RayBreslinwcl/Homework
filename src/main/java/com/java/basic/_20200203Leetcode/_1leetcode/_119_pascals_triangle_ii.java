package com.java.basic._20200203Leetcode._1leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/2/4.
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:
 输入: 3
 输出: [1,3,3,1]

 进阶：
 你可以优化你的算法到 O(k) 空间复杂度吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _119_pascals_triangle_ii {
    /**
     * 参考：https://leetcode-cn.com/problems/pascals-triangle-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--28/
     * @param rowIndex
     * @return
     */
    public List<Integer> generate(int rowIndex) {

        List<Integer> pre=new ArrayList<>();
        List<Integer> cur=null;
        /**
         * i是第几行，公有i个
         * j是上一行的计数
         */
        for (int i=1;i<=rowIndex+1;i++){
            cur=new ArrayList<>();
            for (int j=1;j<=i;j++){
                if(j==1||j==i){//第一个以及最后一个，分别为1
                    cur.add(1);
                }else {//其他都是上面错位之和
                    cur.add(pre.get(j-1)+pre.get(j-2));
                }
            }
            pre=cur;
        }
        return cur;
    }

}
