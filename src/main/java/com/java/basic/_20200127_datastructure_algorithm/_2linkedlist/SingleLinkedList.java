package com.java.basic._20200127_datastructure_algorithm._2linkedlist;

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