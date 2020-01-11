package com.java.basic._20200101.selectsort;

public class simpleSelectSortClass {
    /**
     * 【1】
     * 简单选择排序
     * @param array 需要排序的数组
     * @param n 数组需要排序的截止索引，范围时[0,array.length-1]
     */
    public static void simpleSelectSort(int[] array,int n){

        //开始n轮
        //第1轮：0-》array.length-1;
        //第2轮：1-》array.length-1;
        //第3轮：2-》array.length-1;
        //...
        for (int i=0;i<=n;i++){
            int min=i;
//            int minValue=array[i];
            for (int j=i;j<=n;j++){
                //获得当前轮次的最小值的索引
                if(array[j]<array[min]){
//                    minValue=array[j];
                    min=j;
                }
            }
            //交换最左侧和最小值
            int temp=array[i];
            array[i]=array[min];
            array[min]=temp;
        }

    }
    public static void main(String[] args) {

        int[] array=new int[]{1,76,32,98,67,89};

        simpleSelectSort(array,array.length-1);
        for (int i : array) {
            System.out.print(i+"\t");
        }
    }
}
