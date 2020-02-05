package com.java.basic._20200203Leetcode._1leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2020/2/5.
 */
public class _142_binary_tree_postorder_traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 1.递归
     * @param root
     * @return
     */
//    public List<Integer> postorderTraversal1(TreeNode root) {
//
//    }

    /**
     * 2.迭代
     * ### 题目解析

     用**栈(Stack)**的思路来处理问题。
     后序遍历的顺序为**左-右-根**，具体算法为：

     - 先将根结点压入栈，然后定义一个辅助结点 head
     - while 循环的条件是栈不为空
     - 在循环中，首先将栈顶结点t取出来
     - 如果栈顶结点没有左右子结点，或者其左子结点是 head，
        或者其右子结点是 head 的情况下。我们将栈顶结点值加入结果 res 中，并将栈顶元素移出栈，
        然后将 head 指向栈顶元素
     - 否则的话就看如果右子结点不为空，将其加入栈
     - 再看左子结点不为空的话，就加入栈

     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {

        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list =new LinkedList<>();
        //指示：当前节点
        TreeNode curr=root;
        if(root==null) return list;

        //先将根节点压入栈
        stack.push(curr);

        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.left!=null){
                stack.push(node.left); //和传统先序遍历不一样，先将左结点入栈
            }
            if(node.right!=null){
                stack.push(node.right); //后将右结点入栈
            }
            list.add(0,node.val); //逆序添加结点值

        }
        return list;

    }

}
