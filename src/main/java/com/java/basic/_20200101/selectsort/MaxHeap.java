package com.java.basic._20200101.selectsort;

public class MaxHeap {
    int[] array;
    int size; //堆里有多少数据

    public MaxHeap(int capacity) {
        this.array = new int[capacity+1];
        this.size = 0;
    }

    //基本方法===============================================
    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
    //======================================================

    //添加新元素==========================================
    public void insert(int input){
        array[size+1]=input;
        size++;
        shiftUp(size);
    }

    private void shiftUp(int k) {
        while (array[k]>array[k/2]&&k>1){
            int temp=array[k];
            array[k]=array[k/2];
            array[k/2]=temp;

            k/=2;
        }
    }
    //抽取顶层最大元素==========================================
    public int extractMax(){
        int ret=array[1];

        swap(array,1,size);
        size--;

        shiftDown(1);

        return  ret;
    }

    private void shiftDown(int k) {

        while (k*2<=size){ //证明是有子节点的，2*k是左节点
            //j为将要下沉的索引，j为左右子节点的较大的那一个索引，暂时是2*k，即左节点
            int j=2*k;
            // 如果有右节点，而且右节点大于左节点，则下沉到右节点
            if(j+1<=size&&array[j]<array[j+1]){
                j++;
            }

            //如果大于两个子节点的最大值，则不需要交换
            if(array[k]>array[j]){
                break;
            }
            //剩下的可能就是需要交换的
            swap(array,k,j);
            //j的位置变成需要交换的
            k=j;

        }
    }

    // ===============================
    // 工具函数：
    // 交换data数组中i、j两个索引处的元素
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
