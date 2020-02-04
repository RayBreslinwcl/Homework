package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/4.
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

 你应当保留两个分区中每个节点的初始相对位置。

 示例:
 输入: head = 1->4->3->2->5->2, x = 3
 输出: 1->2->2->4->3->5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/partition-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _86_partition_list {
    // * Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {

        //1.设定两个头节点
        ListNode before_head=new ListNode(0);
        ListNode before=before_head;
        ListNode after_head=new ListNode(0);
        ListNode after=after_head;

        while (head!=null){
            if(head.val<x){
                before.next=head;
                before=before.next;
            }else {
                after.next=head;
                after=after.next;
            }
            //移动原始
            head=head.next;
        }
        //最后一个节点置为空
        after.next=null;

        before.next=after_head.next;
        return before_head.next;
    }
}
