package com.java.basic._20200203Leetcode._1leetcode;

import java.util.Stack;

/**
 * Created by Administrator on 2020/2/5.
 * 根据逆波兰表示法，求表达式的值。

 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

 说明：

 整数除法只保留整数部分。
 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 示例 1：

 输入: ["2", "1", "+", "3", "*"]
 输出: 9
 解释: ((2 + 1) * 3) = 9
 示例 2：

 输入: ["4", "13", "5", "/", "+"]
 输出: 6
 解释: (4 + (13 / 5)) = 6
 示例 3：

 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 输出: 22
 解释:
 ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 = ((10 * (6 / (12 * -11))) + 17) + 5
 = ((10 * (6 / -132)) + 17) + 5
 = ((10 * 0) + 17) + 5
 = (0 + 17) + 5
 = 17 + 5
 = 22

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _150_evaluate_reverse_polish_notation {
    //纯数组模拟栈实现(推荐)   3 ms	36 MB

    /**
     * 方法1
     1.数组最大长度为tokens.length / 2 + 1
     2.switch代替if-else，效率优化
     3.Integer.parseInt代替Integer.valueOf,减少自动拆箱装箱操作

     作者：hteason
     链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/solution/javachun-shu-zu-he-zhan-liang-chong-shi-xian-jian-/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        int[] numStack=new int[tokens.length/2+1];
        int index=0;
        for (String token : tokens) {
            switch (token){
                case "+":
                    //如果有+，则index前两个数字index-1，index-2相加，并且赋给index-2
                    //然后index减1
                    numStack[index - 2] += numStack[--index];
                    break;
                case "-":
                    numStack[index - 2] -= numStack[--index];
                    break;
                case "*":
                    numStack[index - 2] *= numStack[--index];
                    break;
                case "/":
                    numStack[index - 2] /= numStack[--index];
                    break;
                default:
                    //将数字压numStack的对应位置
                    numStack[index++]=Integer.parseInt(token);
                    break;
            }
        }
        return numStack[0];
    }

    /**
     * 方法2：栈实现
     * 参考：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/solution/javachun-shu-zu-he-zhan-liang-chong-shi-xian-jian-/
     * @param tokens
     * @return
     */
    public static int evalRPN2(String[] tokens) {
        Stack<Integer> numStack=new Stack<>();
        int result=0;
        for (String token : tokens) {
            switch (token){
                case "+":
                    //如果有+，则index前两个数字index-1，index-2相加，并且赋给index-2
                    //然后index减1
                    numStack.push(numStack.pop()+numStack.pop());
                    break;
                case "-":
                    numStack.push(-numStack.pop()+numStack.pop());
                    break;
                case "*":
                    numStack.push(numStack.pop()*numStack.pop());
                    break;
                case "/":
                    int t1=numStack.pop();
                    int t2=numStack.pop();
                    numStack.push(t2/t1);
                    break;
                default:
                    //将数字压numStack的对应位置
                    numStack.push(Integer.parseInt(token));
                    break;
            }
        }
        return numStack.pop();
    }
}
