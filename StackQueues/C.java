package StackQueues;
import java.util.Queue;
import java.util.LinkedList;


class Stack {
    Queue<Integer> q = new LinkedList<>();



    public void push(int x){
        q.offer(x);

        int size = q.size();

        //move other elements backward 
        for(int i = 0; i < size - 1;i++){
            q.offer(q.poll());//remember
        }
    }

    public int pop(){
        return q.poll();
    }

    public int top(){
        return q.peek();
    }

    public boolean isEmpty(){
        return q.isEmpty();
    }

}

public class C {
    public static void main(String [] args){
        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Top: " + s.top());   

        System.out.println("Pop: " + s.pop());   
        System.out.println("Pop: " + s.pop());   

        System.out.println("Top: " + s.top()); 
    }
    
}
