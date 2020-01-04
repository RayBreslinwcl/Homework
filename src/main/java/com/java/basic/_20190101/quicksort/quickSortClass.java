package com.java.basic._20190101.quicksort;

/**
 * Created by Administrator on 2019/11/3.
 */
public class quickSortClass {

    /**
     * 总结：
     * 1.快速排序时间：10000个数字排序，array 排序耗时：7ms
     */

    /**
     * 【10】
     * 0.快速排序：
     * @param array 数组
     * @param left 起始排序位置
     * @param right 终止排序位置
     */
    public void quickSort(int[] array,int left,int right){
       if (left>=right)
           return;

        //获得分割位置
        int p=partition(array,left,right);
        quickSort(array,left,p-1);
        quickSort(array,p+1,right);
    }

    /**
     * 0.1 功能：把数组最左侧的元素，转移到恰当位置
     * @param array
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] array,int left,int right){

        //定义：array[left+1,j]<v;array[j+1,i)>v。分为两个部分
        int j=left,i;  //j=left+1，会导致可能和i同时到达最后一位，而且需要和array[left]交换的情况，array[j+1]报出界的错误
        int v=array[left]; //作为标准的元素，左侧第一个

        for (i=left+1;i<=right;i++){
            if (array[i]>v){
//                i++;不需要操作，因为i默认加1
            }else if(array[i]<v){
                int temp=array[i];
                array[i]=array[j+1];
                array[j+1]=temp;
                j++;
            }
        }

        int temp=array[left];
        array[left]=array[j];
        array[j]=temp;
        return j;

    }



    public static void main(String[] args) {
        //生成测试数组测试
        int numcount=10000;
        int maxValue=1000;
        int[] arr=new int[numcount];
        for (int i=0;i<numcount;i++){
            arr[i]=(int)(Math.random()*maxValue); //随机数的范围
        }

//        int[] arr=new int[]{1,50,81,64,3};
        System.out.println("array 排序前数组：");
        for (int i : arr) {
            System.out.print(i+"\t");
        }

        System.out.println();

        long startTime=System.currentTimeMillis();
        new quickSortClass().quickSort(arr,0,arr.length-1); //快速排序
        long stopTime=System.currentTimeMillis();
        System.out.println("array 排序耗时："+(stopTime-startTime)+"ms");


        System.out.println("array 排序后数组：");
        for (int i : arr) {
            System.out.print(i+"\t");
        }

    }

}
