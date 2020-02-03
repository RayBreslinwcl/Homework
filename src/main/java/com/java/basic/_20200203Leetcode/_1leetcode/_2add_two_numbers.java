package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/3.
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _2add_two_numbers {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 参考解法：
     * https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
     * 就像你在纸上计算两个数字的和那样，
     * 我们首先从最低有效位也就是列表 l1l1 和 l2l2 的表头开始相加。
     * 由于每位数字都应当处于 0 \ldots 90…9 的范围内，我们计算两个数字的和时可能会出现 “溢出”。
     * 例如，5 + 7 = 12.在这种情况下，我们会将当前位的数值设置为 2，并将进位 carry = 1 带入下一次迭代。
     * 进位 carry 必定是 0 或 1，这是因为两个数字相加（考虑到进位）可能出现的最大和为 9 + 9 + 1 = 19

     作者：LeetCode
     链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummynode=new ListNode(0);
        //第一个链表p1和第二个链表p2
        ListNode p1=l1,p2=l2,curr=dummynode;
        //是否进位
        int carry=0;
        while (p1!=null||p2!=null){
            int x= p1!=null?p1.val:0;
            int y= p2!=null?p2.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            //下一个节点，从0开始
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            //后移
            if(p1!=null){
                p1=p1.next;
            }
            if(p2!=null){
                p2=p2.next;
            }
        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        //返回第一个节点即可
        return dummynode.next;
    }


}
