package com.java.basic._20200203Leetcode._1leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2020/2/4.
 * 二叉树的中序遍历
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _94_binary_tree_inorder_traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 方法1.递归求解
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        helper(root,res);
        return res;
    }

    public void helper(TreeNode root,List<Integer> res){
        if(root==null) return;

        if(root.left!=null){
            helper(root.left,res);
        }
        res.add(root.val);
        if(root.right!=null){
            helper(root.right,res);
        }
    }

    /**
     * 2.迭代
     * 方法二：基于栈的遍历
     本方法的策略与上衣方法很相似，区别是使用了栈。
     https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;

        while (curr!=null || stack.isEmpty()){
            //当curr有右节点的时候，curr是非空的；
            //当curr没有右节点的时候，curr为null
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            //非常巧妙，没有想明白
            curr=stack.pop();
            res.add(curr.val);
            curr=curr.right;
        }
        return res;

    }
}
