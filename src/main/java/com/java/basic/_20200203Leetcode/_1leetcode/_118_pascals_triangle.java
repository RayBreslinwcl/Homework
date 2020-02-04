package com.java.basic._20200203Leetcode._1leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/2/4.
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:
 输入: 5
 输出:
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/pascals-triangle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _118_pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        //1.第一种情况，0行
        if (numRows < 1) {
            return result;
        }
        //2.第二种情况，第一行总是1
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int rowNum=1;rowNum<numRows;rowNum++) {
            //当前行
            List<Integer> row=new ArrayList<>();
            //上一行
            List<Integer> preRow=result.get(rowNum-1);

            //当前行赋值
            //第n行，有n个元素；其中1和n是1，其他需要上一行相加
            row.add(1);
            for (int j=1;j<rowNum;j++){

                row.add(preRow.get(j-1)+preRow.get(j));
            }
            //最后一个元素
            row.add(1);

            result.add(row);
        }
        return result;
    }
}
