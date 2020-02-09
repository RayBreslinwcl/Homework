package com.java.basic._20200203Leetcode._1leetcode;

import java.util.Stack;

/**
 * Created by Administrator on 2020/2/9.
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 进阶:
 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

 示例:
 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出: 7 -> 8 -> 0 -> 7

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _445_add_two_numbers_ii {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 由于计算时要保证最右边的数对齐，那么很自然的想到先用**栈**存放链表中的每个值，然后依次计算。由于相加时可能产生进位，所以使用一个flag表示是否有进位。
     提示：若栈中元素相加结束之后仍有进位，则需要新加入一个头结点。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();

        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }

        int flag=0;//表示两个数相加和
        ListNode head=null;//最终返回头节点
        while (!stack1.isEmpty()|| !stack2.isEmpty()||flag!=0){ //flag!=0保证最高位进位
            if(!stack1.isEmpty()){
                flag+=stack1.pop();
            }
            if(!stack2.isEmpty()){
                flag+=stack2.pop();
            }
            ListNode node=new ListNode(flag%10);
            //head<-head<-head<-head
            //1-->2-->4-->5
            node.next=head;
            head=node;
            flag/=10;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(5);
        ListNode l2=new ListNode(5);
        addTwoNumbers(l1,l2);
    }
}
