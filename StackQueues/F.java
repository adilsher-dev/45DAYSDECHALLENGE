package StackQueues;
import java.util.Stack;
//Sort a STACk

public class F {

    public static Stack<Integer> sortStack(Stack<Integer> stack){

        Stack<Integer> temp = new Stack<>();

        while(!stack.isEmpty()){

            int curr = stack.pop();

            while(!temp.isEmpty() && temp.peek() > curr){

                stack.push(temp.pop());
            }

            temp.push(curr);

        }
        return temp;

    }
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();

        stack.push(20);
        stack.push(30);
        stack.push(10);
        stack.push(40);
        stack.push(50);
        stack.push(35);
        stack.push(23);
        stack.push(17);
        stack.push(37);

        Stack<Integer> ans = sortStack(stack);

    }
}