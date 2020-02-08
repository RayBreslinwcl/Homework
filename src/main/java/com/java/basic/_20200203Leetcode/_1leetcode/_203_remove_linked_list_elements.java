package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/8.
 * 删除链表中等于给定值 val 的所有节点。

 示例:
 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 在真实的面试中遇到过这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class _203_remove_linked_list_elements {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 自己思路
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummynode=new ListNode(0);
        dummynode.next=head;
        ListNode pre=dummynode; //待删除节点的，前置节点
//        ListNode cur=head;

        while (pre.next!=null){
            if(pre.next.val==val){
                ListNode cur=pre.next;
                pre.next=cur.next;
                cur.next=null;
            }else {
                pre=pre.next;
            }
//            if(pre==null){
//                break;
//            }

        }

        return dummynode.next;


    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(6);
        l1.next.next.next=new ListNode(3);
        l1.next.next.next.next=new ListNode(4);
        l1.next.next.next.next.next=new ListNode(5);
        l1.next.next.next.next.next.next=new ListNode(6);

        removeElements(l1,6);
    }

}
