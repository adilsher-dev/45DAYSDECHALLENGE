package StackQueues;
import java.util.Stack;
import java.util.*;

public class E {
    public static boolean isValid(String s){

        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){

            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }

                char top = st.pop();

                if(ch == ')' && top != '(' || ch == '}' && top != '{' || ch == ']' && top != '['){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args){
        String s = "{[()]}";

        if (isValid(s)) {
            System.out.println("Valid Parentheses");
        } else {
            System.out.println("Invalid Parentheses");
        }
    }
}