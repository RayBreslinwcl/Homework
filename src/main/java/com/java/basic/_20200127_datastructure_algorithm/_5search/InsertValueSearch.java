package com.java.basic._20200127_datastructure_algorithm._5search;

/**
 * Created by Administrator on 2020/1/29.
 * 插值查找
 */
public class InsertValueSearch {

    /**
     * 插值查找
     * @param array 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 查找值
     * @return
     */
    public int insertValueSearch(int[] array,int left,int right,int findVal){

        //停止
        if(left>right || findVal<array[0]||findVal>array[array.length-1]){
            return -1;
        }

        //插值搜索
//        int mid=(left+right)/2;
        int mid=left+(right-left)*(findVal-array[left])/(array[right]-array[left]);
        int midVal=array[mid];

        if(findVal>midVal){//向右递归
            return insertValueSearch(array,mid+1,right,findVal);
        }else if(findVal<midVal){//向左递归
            return insertValueSearch(array,left,mid-1,findVal);
        }else {
            return mid;
        }

    }
}
