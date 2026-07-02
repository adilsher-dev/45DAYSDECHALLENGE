package StackQueues;

import java.util.Stack;

class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {

        st.push(val);

        if(minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        }
    }

    public void pop() {
        if(st.peek().equals(minSt.peek())){
            minSt.pop();
        }
        st.pop();

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
        
        
    }

    public static void main(String[] args) {

        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(2);
        ms.push(8);
        ms.push(1);

        System.out.println(ms.getMin()); // 1

        ms.pop();

        System.out.println(ms.getMin()); // 2
    }
}


