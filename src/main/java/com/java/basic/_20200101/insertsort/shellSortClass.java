package com.java.basic._20200101.insertsort;

/**
 * 希尔排序
 */
public class shellSortClass {


    /**
     * 【1】
     * 希尔排序
     *
     * @param array 排序数组
     * @param step 初始步长
     */
    public static void shellSort(int[] array,int step){
        int length=array.length;
        int h=1;
        //计算出最大步长
        while(h<length/step){
            h=h*step+1;
        }

        //h每减一次，算一次循环排序
        while (h>0){
            System.out.println("=======h的值为： "+h+"======");
            //从索引h开始，到最后一个节点
            for (int i=h;i<array.length;i++){

                int temp=array[i];
                //如果当前值array[i]，小于往前推一个步长array[i-h]，则做插入排序；
                //否则，直接跳过，看下一个值
                if(array[i]-array[i-h]<0){
                    int j=i-h;
                    //将所有大于array[i]的，都往后移动一个步长
                    for (;j>=0&&array[j]>temp;j-=h){
                        array[j+h]=array[j];
                    }
                    array[j+h]=temp;
                }
            }
            h=(h-1)/step;
        }
    }


    public static void main(String[] args) {
        int[] array=new int[]{1,76,32,98,67,89};

        shellSort(array,3);
        for (int i : array) {
            System.out.print(i+"\t");
        }

    }


}
