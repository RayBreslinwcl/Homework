package com.java.basic._20200127_datastructure_algorithm._2linkedlist;

import java.util.Stack;

/**
 * Created by Administrator on 2020/1/28.
 * 单向链表
 */
public class SingleLinkedList {
    //初始化头节点
    HeroNode head=new HeroNode(0,"",""); //不存储数据，表示单链表头


    //1.添加
    public void add(HeroNode node){
        HeroNode pre=head;
        while (true){
            if(pre.next==null){
                break;
            }
            //向后一定一位
            pre=pre.next;
        }
        //此时，指向最后一个
        pre.next=node;
    }
    //2.遍历
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode node=head.next;
        while (true){
            //到最后停止
            if(node==null){
                break;
            }
            System.out.println(node);
            node=node.next;
        }
    }
    //3.顺序添加
    public void addByOrder(HeroNode node){

        HeroNode pre=head;
        boolean flag=false;//判断是添加元素是否存在，存在则不插入
        //由小到大
        while (true){
            if(pre.next==null){
                break;//已经在最后，直接插入最后
            }
            if(pre.next.no>node.no){
                break;
            }else if(pre.next.no==node.no){
                flag=true;
                break;
            }
            pre=pre.next;
        }
        if(flag==true){
            //编号存在
            System.out.printf("准备插入的编号%d 已经存在，不能加入",node.no);
        }else {
            //插入到链表中
            node.next=pre.next;
            pre.next=node;
        }
    }
    //4.修改

    public void update(HeroNode node){
        //判断是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode pre=head.next;
        boolean flag=false;//找到则为true
        while (true){
            if(pre.next==null){
                System.out.println("没有找到");
                break;
            }

            if(pre.next.no==node.no){
                flag=true;
                break;
            }
            pre=pre .next;
        }

        //更新
        if(flag==true){
            pre.name=node.name;
            pre.nickname=node.nickname;
        }else {
            System.out.printf("没有找到编号 %d 的节点，不能修改",node.no);
        }
    }
    //5.删除
    public HeroNode delete(int no){
        HeroNode pre=head;
        boolean flag=false;//如果找到，则为true
        while (true){
            if(pre.next==null){
//                System.out.println("没有找到");
                break;
//                return null;
            }
            if(pre.next.no==no){
                flag=true;
                break;
            }
            pre=pre.next;
        }
        //依据结果删除
        if(flag==true){
            pre.next=pre.next.next;
        }else{
            pre=null;
            System.out.printf("要删除的%d节点不存在\n",no);
        }
        return pre;
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        HeroNode hero1=new HeroNode(1,"宋江","及时雨");
        HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3=new HeroNode(3,"吴用","智多星");
//        HeroNode hero4=new HeroNode(1,"宋江","及时雨");

        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        //显示
        singleLinkedList.list();
        //结果：HeroNode{no=1, name='宋江', nickname='及时雨', next=HeroNode{no=2, name='卢俊义', nickname='玉麒麟', next=HeroNode{no=3, name='吴用', nickname='智多星', next=null}}}
        //HeroNode{no=2, name='卢俊义', nickname='玉麒麟', next=HeroNode{no=3, name='吴用', nickname='智多星', next=null}}
        //HeroNode{no=3, name='吴用', nickname='智多星', next=null}

        //面试题目1
        HeroNode res1=findLaskKNode(singleLinkedList.head,1);
        System.out.println(res1);
        //结果：HeroNode{no=3, name='吴用', nickname='智多星', next=null}


    }
    //面试题目
    //1.查找单链表中倒数第k个节点
    //返回链表节点个数
    public static int getLength(HeroNode head){
        if(head.next==null){
            return 0;
        }
        int length=0;
        HeroNode cur=head.next;
        while (cur!=null){
            length++;
            cur=cur.next;
        }
        return length;
    }
    //返回倒数第k个节点
    //1.先遍历，获得链表总长度size
    //2.得到size，重新遍历到(size-index),就可以得到
    public static HeroNode findLaskKNode(HeroNode head,int index){

        if(head.next==null){
            return null;//没有找到
        }
        int size=getLength(head);
        //停止条件
        if(index>size || index<=0){
            return null;
        }
        //辅助遍历
        HeroNode cur=head.next;
        for (int i=0;i<(size-index);i++){
            cur=cur.next;
        }
        return cur;
    }

    //2.单链表反转
    //递归和迭代
    //参考
    //https://github.com/RayBreslinwcl/algorithm/tree/master/src/main/java/com/algorithm/learn/Leetcode/_206reverse_linked_list

    //3.逆序打印单链表
    //思路1：先将链表反转，然后遍历。但是会破坏原理链表结构
    //思路2：可以利用栈这个数据结构，将各个节点压入到核中，然后利用栈的先进后出的特点，就实现了逆序打印的效果。
    /**
     * 使用栈后进先出进行打印
     * @param head
     */
    public static void reversePrint(HeroNode head){
        if(head.next==null){
            return;//空链表，不能打印
        }

        Stack<HeroNode> stack=new Stack<>();
        HeroNode cur=head.next;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        //打印
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }


}



class HeroNode{
    public int no;
    public String name;
    public String nickname;//绰号
    public HeroNode next; //下一个节点

    //构造函数
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}