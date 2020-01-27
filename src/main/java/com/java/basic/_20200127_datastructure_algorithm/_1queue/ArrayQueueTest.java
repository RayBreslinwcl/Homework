package com.java.basic._20200127_datastructure_algorithm._1queue;

/**
 * Created by Administrator on 2020/1/27.
 */
public class ArrayQueueTest {

}

class ArrayQueueSGG{
    private int maxSize;//数组最大容量
    private int front;//队列头，指向第一个的前面一个；
    private int rear;//队列尾，指向最后一个元素
    private int[] array;//存放数据，模拟队列

    public ArrayQueueSGG(int size){
        array=new int[size];
        front=-1;//指向第一个的前面一个；
        rear=-1;//指向最后一个元素
        maxSize=size;
    }

    //辅助
    /**
     * 判断是否满了
     * @return
     */
    private boolean isFull(){
        return front==maxSize-1;
    }
    /**
     * 判断是否为空
     * @return
     */
    private boolean isEmpty(){
        return front==rear;
    }
    //辅助

    //1.入队
    public void enqueue(int a){
        if(isFull()){
            System.out.println("队列已经满了，不能再添加");
        }

        rear++;
        array[rear]=a;
    }
    //2.出队
    public int dequeue(){
        if(isEmpty()){
//            System.out.println("队列为空，已经没有元素了");
            throw new RuntimeException("队列空，不能取数据！");
        }
        front++;
        return array[front];
    }

    //3.查看第一个队列
    public int first(){
        if(isEmpty()){
//            System.out.println("队列为空，已经没有元素了");
            throw new RuntimeException("队列空，没有元素！");
        }
        return array[front+1];
    }

}
