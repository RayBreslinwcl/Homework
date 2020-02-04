package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/4.
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _24_swap_nodes_in_pairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 1.迭代求解
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //prevNode为要交换两节点的前一个节点
        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {
            //交换的两个节点
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            //交换
            //pre指向second
            //first指向second后一个
            //second指向first
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            //移动pre和head到下一个位置
            prevNode = firstNode;
            head = firstNode.next;
        }

        return dummy.next;
    }

}
