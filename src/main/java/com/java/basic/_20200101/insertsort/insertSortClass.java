package com.java.basic._20200101.insertsort;

/**
 * 插入排序
 * 参考：https://www.cnblogs.com/morethink/p/8419151.html
 */
public class insertSortClass {
    /**
     * 【1】
     *
     * 插入排序算法
     * @param array 需要排序的数组
     */
    public static void insertsort(int[] array){
        for (int i=0;i<array.length-1;i++){
            for (int j=i+1;j>0;j--){
                if (array[j]<array[j-1]){
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,76,32,98,67,89};

        insertsort(array);
        for (int i : array) {
            System.out.print(i+"\t");
        }

    }

}
