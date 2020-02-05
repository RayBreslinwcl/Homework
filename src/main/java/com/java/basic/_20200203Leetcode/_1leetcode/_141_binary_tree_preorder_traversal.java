package com.java.basic._20200203Leetcode._1leetcode;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2020/2/5.
 */
public class _141_binary_tree_preorder_traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 思路1.迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
//        if(root.left!=null){
//            helper(root.left,res);
//        }
        if (root.left != null) {
            helper(root.left, res);
        }
        if (root.right != null) {
            helper(root.right, res);
        }
    }

    /**
     * 思路2：迭代解决
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new LinkedList<>();
        //当树为空时，直接返回一个空list
        if(root==null) {
            return list;
        }
        //1.将根节点压入栈
        stack.push(root);
        //2.当栈不为空，yi把最上面的出栈，并且压入list
        //3.当节点孩子不为空，将孩子压入栈，一定是先压有孩子再压左孩子
        while (!stack.isEmpty()){
            //返回栈顶元素
            root=stack.pop();
            list.add(root.val);
            if(root.right!=null) stack.push(root.right);
            if(root.left!=null) stack.push(root.left);
        }
        return list;

    }
}
