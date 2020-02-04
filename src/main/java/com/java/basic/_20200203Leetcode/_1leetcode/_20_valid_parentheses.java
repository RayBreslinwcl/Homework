package com.java.basic._20200203Leetcode._1leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Administrator on 2020/2/3.
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:
 输入: "()"
 输出: true

 示例 2:
 输入: "()[]{}"
 输出: true

 示例 3:
 输入: "(]"
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _20_valid_parentheses {
    //括号匹配表
    private HashMap<Character,Character> mappings;

    //构造函数
    public _20_valid_parentheses(){
        this.mappings=new HashMap<>();
        mappings.put(')','(');
        mappings.put(']','[');
        mappings.put('}','{');
    }
    //解题
    /**
     * 参考：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();

        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);


            if(this.mappings.containsKey(c)){//（1）如果是闭括号

                //获取栈中对应的元素,如果栈为空，则返回#
                char topElement=stack.empty()?'#':stack.pop();
                //如果栈顶元素和这个闭括号不对应，则返回false
                if(topElement!=this.mappings.get(c)){
                    return false;
                }

            }else {//（2）如果是开括号
                stack.push(c);
            }
        }
        //如果为空，则证明刚好完成匹配，否则不能
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        new _20_valid_parentheses().isValid("()");
    }
}
