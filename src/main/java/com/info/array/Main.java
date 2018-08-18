package com.info.array;

import com.info.stack.ArrayStack;
import com.info.stack.Stack;

/**
 * Created by M on 2018/7/26.
 */
public class Main {
    public static void main(String[] args) {

//        Array a = new Array(5);
//
//        for (int i = 0; i < 5; i++)
//            a.addLast(i);
//        System.out.println(a);
//
//        a.addLast(100);
//        System.out.println(a);
//        a.addFirst(-1);
//        System.out.println(a);
//        System.out.println(a.size());
//        a.set(2,20000);
//        System.out.println(a);
//        a.delete(0);
//        System.out.println(a);
//        a.removeElement(20000);
//        System.out.println(a);
//        a.addLast(500000);
//        a.addLast(100000);
//        a.addLast(100000);
//        a.addLast(500000);
//        a.addLast(100000);
//        System.out.println("----------------");
//        System.out.println(a);
//        a.removeElement(100000);
//        System.out.println(a);
//        System.out.println("----------------");
//        a.removeAllElement(500000);
//        System.out.println(a);
//        a.removeAllElement(2);
//        System.out.println(a);

        ArrayStack stack = new ArrayStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.peek();
        System.out.println(stack);
    }

    // 括号是否匹配问题
    public boolean isValid(String str){
        java.util.Stack<Character> stack = new java.util.Stack();
        for(int i = 0; i < str.length(); i ++){
            char c = str.charAt(i);
            if( c == '[' || c == '(' || c == '{'){
                stack.push(c);
            }else if(c == ']' || c == ')' || c == '}'){
                // 获取当前栈顶元素
                char topChar = stack.pop();
                if(c == ')' && topChar != '(' ){
                    return false;
                }
                if(c == '}' && topChar != '{' ){
                    return false;
                }
                if(c == ']' && topChar != '[' ){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
