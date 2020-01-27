package com.java.basic._20200127_datastructure_algorithm._1queue;

/**
 * Created by Administrator on 2020/1/27.
 */
public class ArrayLoopQueueTest {

}

/**
 * 思路如下：
 1.front变量的含义：front指向队列的第一个元素，也就是说array[front]就是队列的第一个元素
 front的初始值=0
 2.rear变量的含义：rear指向队列的最后一个元素的后一个位置。数组默认空出一个空间。
 rear的初始值=0
 3.当队列满时，条件是(rear +1)%maxsize=front【满】
 4.对队列为空的条件，rear == front空
 5.当我们这样分析，队列中有效的数据的个数(rear+maxsize-front)%maxsize //rear =1 front=0
 */
class ArrayLoopQueueSGG{
    private int maxSize;//数组最大容量
    //front变量的含义：front指向队列的第一个元素，也就是说array[front]就是队列的第一个元素
//    front的初始值=0
    private int front;
    //rear变量的含义：rear指向队列的最后一个元素的后一个位置。数组默认空出一个空间。
//    rear的初始值=0
    private int rear;

    private int[] array;//存放数据，模拟队列

    public ArrayLoopQueueSGG(int size){
        array=new int[size];
        front=0;//指向第一个；
        rear=0;//指向最后一个元素，后面的一个位置
        maxSize=size;
    }

    //辅助
    /**
     * 判断是否满了
     * @return
     */
    private boolean isFull(){
//        return front==maxSize-1;
        return  (rear+1)%maxSize==front;
    }
    /**
     * 判断是否为空
     * @return
     */
    private boolean isEmpty(){
        return front==rear;
    }

    /**
     * 获取包含元素个数
     * @return
     */
    private int size(){
        //因为rear指向最后一个元素的后一个位置，所以不用加1
        return (rear-front+maxSize)%maxSize;
    }
    //辅助

    //1.入队
    public void enqueue(int a){
        if(isFull()){
            System.out.println("队列已经满了，不能再添加");
        }

        array[rear]=a;
        //将rear后移，因为循环队列，所以取模
        rear=(rear+1)%maxSize;
//        rear++;
//        array[rear]=a;
    }
    //2.出队
    public int dequeue(){
        if(isEmpty()){
//            System.out.println("队列为空，已经没有元素了");
            throw new RuntimeException("队列空，不能取数据！");
        }
        int res=array[front];
        //front后移
        front=(front+1)%maxSize;
        return res;
    }

    //3.查看第一个队列
    public int first(){
        if(isEmpty()){
//            System.out.println("队列为空，已经没有元素了");
            throw new RuntimeException("队列空，没有元素！");
        }
        return array[front];
    }

}
