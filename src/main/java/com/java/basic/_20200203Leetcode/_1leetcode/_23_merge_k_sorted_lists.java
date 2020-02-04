package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/4.
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

 示例:
 输入:
 [
   1->4->5,
   1->3->4,
   2->6
 ]
 输出: 1->1->2->3->4->4->5->6

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _23_merge_k_sorted_lists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 整体时间复杂度为O(N*log(k)), k为链表个数，N为链表平均长度。
     整体思路为
     1.合并数组中第k个链表到第1个链表，合并数组中第k-1个链表到第2个链表，依次这样操作...
     2.一轮合并之后，新链表分布在数组的 第1 到 第(k+1)/2个链表中，继续1这样的合并直到新链表只在数组第一个位置。
     3.返回数组第一个元素，即合并之后的链表。
     作者：lin-jian-you-xue
     链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/luo-ji-fei-chang-jian-dan-de-javati-jie-shi-jian-j/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int length=lists.length;
        if(length==0){
            return null;
        }

        while (length > 1) {
            for (int i=0;i<length/2;i++){
                lists[i]=mergeTwoLists(lists[i],lists[length-1-i]);
            }
            length=(length+1)/2;
        }

        return lists[0];
    }

    //合并两个链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //合并
        ListNode prehead=new ListNode(-1);
        ListNode head=prehead;


        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                head.next=l1;
                l1=l1.next;
            }else {
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }

        //把l1或l2长的那一个黏贴到后面
        head.next=(l1==null?l2:l1);
        return prehead.next;
    }
}
