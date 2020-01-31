package com.java.basic._20200127_datastructure_algorithm._9heapSort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Administrator on 2020/1/31.
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        //进行升序排序
        int arr[]={4,6,8,3,5};

        heapSort(arr);
    }

    public static void heapSort(int arr[]){

        int temp=0;
        System.out.println("堆排序");
        /**
         * //1)将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
         */
        //这个相当于取arr.length的最后一个的父亲节点
        int last=(arr.length/2-1);
        for (int i=last;i>=0;i--){
            adjustHeap(arr,i,arr.length-1);
        }

        /**
         * 2）将堆原元素与未尾元素交换，将最大元素“沉”到数组末端；
         * 3）重新调整结构，使其满足堆定义，然后继续交换堆项元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
         */
        for (int j=arr.length-1;j>0;j--){
            //交换
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
        System.out.println("数组="+ Arrays.toString(arr));
    }

    /**
     * 功能：将总长length的arr，的第i个进行下沉操作。
     * //将一个数组（模拟二叉树），调整为一个最大堆
     * @param arr 待调整数组
     * @param i 非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整，length在逐渐减少
     */
    public static void adjustHeap(int arr[],int i,int length){
        //取出当前元素值，保存在临时变量
        int temp=arr[i];
        //开始调整
        //1. k=i*2+1，k是i的左子节点
        for (int k=i*2+1;k<length;k=2*k+1){

            //选择左右的最大值
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }

            if(arr[k]>temp){
                arr[i]=arr[k];
                i=k; //i指向k，循环比较
            }else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父结点的树的最大值，放在了最顶（局部）
        //把temp放到，最后的位置
        arr[i]=temp;
    }
}
