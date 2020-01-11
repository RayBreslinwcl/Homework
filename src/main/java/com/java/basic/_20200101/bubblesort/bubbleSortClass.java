package com.java.basic._20200101.bubblesort;

/**
 * Created by Administrator on 2020/1/1.
 * 总结：冒泡排序
 */
public class bubbleSortClass {
    /**
     * 【1】
     * 冒泡排序
     * @param array 需要排序的数组
     * @param n 排序截止索引，范围为[0,array.length-1]
     */
    public static void BubleSort(int[] array,int n){

        //当指定排序是，第0个之前时，直接返回
        if(n<=0) return;
        //排序从[0,j]总共排序n次
        for (int i=0;i<n;i++){
            boolean flag=false; //flag为提前结束标识，false提前结束；true则依旧有需要排序的，不能结束

            for (int j=0;j<n-i;j++){
                if (array[j]>=array[j+1]){ //如果array[j]大于array[j+1]，则交换位置，冒泡
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag=true; //true为有交换发生
                }
            }

            if (!flag) break; //如果没有交换，则提前结束
        }
    }


    public static void main(String[] args) {
        int[] array=new int[]{1,76,32,98,67,89};

        BubleSort(array,array.length-1);
        for (int i : array) {
            System.out.print(i+"\t");
        }

    }
}
