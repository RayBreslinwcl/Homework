package com.java.basic._20200101.selectsort;

/**
 *  堆排序
 *  方法二：最大堆排序，基于二叉树数据结构实现
 */
public class heapSortClass_2BTree {

    //堆排序，基于堆数据结构实现的堆排序
    public static void heapSort2(int[] array){
        MaxHeap maxHeap=new MaxHeap(array.length+100);
        for (int i=0;i<array.length;i++){
            maxHeap.insert(array[i]);
        }

        for (int i=array.length-1;i>=0;i--){
            array[i]=maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {

        int[] data = { 9, -16, 21, 23, -30, -49, 21, 30, 30 };
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        heapSort2(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
