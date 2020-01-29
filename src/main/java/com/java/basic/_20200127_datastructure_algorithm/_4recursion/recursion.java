package com.java.basic._20200127_datastructure_algorithm._4recursion;

/**
 * Created by Administrator on 2020/1/29.
 * 递归
 * 针对问题
 1）各种数学问题如：8皇后问题，汉诺塔，阶乘问题，迷宫问题，球和篮子的问题（google编程大赛）
 2）各种算法中也会使用到递归，比如快排，归并排序，二分查找，分治算法等.
 3）将用栈解决的问题->第归代码比较简洁

 递归思路：
 1）执行一个方法时，就创建一个新的受保护的独立空间（栈空间）
 2）方法的局部变量是独立的，不会相互影
 3）递归必须向退出递归的条件逼近，否则就是无限递归，导致stackoverflow
 4）当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果中返回给谁，
    同时当方法执行完毕或者返回时，该方法也就执行完毕。
 */
public class recursion {

    /**
     * 1.阶乘问题
     * @param n
     * @return
     */
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

}
