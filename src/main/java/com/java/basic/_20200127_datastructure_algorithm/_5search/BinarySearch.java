package com.java.basic._20200127_datastructure_algorithm._5search;

/**
 * Created by Administrator on 2020/1/29.
 * 二分搜索
 *
 */
public class BinarySearch {


    /**
     * 二分查找的思路分析
     1.首先确定该数组的中间的下标
     mid=（left+right）
     2.然后让需要查找的数fmdval和arr[mid]比较
        2.1 findVal>arr[mid]，说明你要查找的数在mid的右边，因此需要递归的向右查找
        2.2 findVal<arr[mid]，说明你要查找的数在mid的左边，因此需要递归的向左查找
        2.3findVal == arr[mid]说明找到，就返回
     3.结束递归结束条件
         1）找到就结束递归
         2）适归完整个数组，仍然没有找到ndval，也需委结束递归当left>right就需要退出
     * @param array 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 要查找的值
     * @return 如果没有找到，就返回-1
     */
    public int binarySearch(int[] array,int left,int right,int findVal){

        //停止
        if(left>right){
            return -1;
        }

        int mid=(left+right)/2;

        int midVal=array[mid];
        if(findVal>midVal){//向右递归
            return binarySearch(array,mid+1,right,findVal);
        }else if(findVal<midVal){//向左递归
            return binarySearch(array,left,mid-1,findVal);
        }else {
            return mid;
        }

    }
}
