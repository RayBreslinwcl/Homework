package com.java.basic._20200127_datastructure_algorithm._2linkedlist;

/**
 * Created by Administrator on 2020/1/28.
 * 循环链表：约瑟夫问题
 */
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //测试出圈
        circleSingleLinkedList.countBoy(1,2,5);
    }
}
//环形链表
class CircleSingleLinkedList{
    //创建first节点
    Boy first=null;

    //1.添加小孩
    public void addBoy(int num){
        if(num<1){
            System.out.println("输入不合理");
        }
        Boy curBoy=null;//辅助构建节点，默认指向最后一个
        for (int i=1;i<=num;i++){
            //依据编号创建boy
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                boy.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=curBoy.getNext();//当前节点curBoy向后一个节点
            }
        }

    }

    //2.遍历环形链表
    public void showBoy(){
        if(first==null){
            System.out.println("每有boy");
            return;
        }
        //辅助，因为first不能动
        Boy cur=first;
        while (true){
            System.out.printf("小孩编号%d \n",cur.getNo());
            //遍历结束条件
            if(cur.getNext()==first){
                break;
            }
            cur=cur.getNext();
        }
    }

    //3.出圈
    /**
     *
     1.需求创建一个辅助指针（变量）helper，事先应该指向环影随表的最后这个节点。
     2.当小孩报数时，让frt和helper指针同时的移动m-1次
     3.这时载可以精frt指向的小孩节点出圈first = first.nexthelper.next =first原来rst指问的
     */
    public void countBoy(int startNo,int countNum,int nums){
        if(startNo<1||first==null||startNo>nums){
            System.out.println("参数输入有误，请重新输入！");
            return;
        }
        //创建辅助指针，初始位置为first前一个位置
        Boy helper=first;
        //获取helper初始位置
        while (true){
            if(helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }

        //小孩报数前，先让first和helper移动k-1
        for(int i=0;i<startNo-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }

        //报数
        //两个指针分别移动m-1次，然后出圈
        //当最后有一个人的时候停止
        while (true){
            if(helper==first){
                break;
            }
            //两个指针同时移动
            for (int i=0;i<countNum-1;i++){
                first=first.getNext();
                helper=helper.getNext();
            }

            //剔除该节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在的小孩是：%d",first.getNo());

    }
}


//节点类
class Boy{
    private int no;//编号
    private  Boy next;//指向下一个节点，默认为null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}