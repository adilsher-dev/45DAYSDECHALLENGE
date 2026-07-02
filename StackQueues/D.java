package StackQueues;
import java.util.Stack;

class Queue{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int x){
        s1.push(x);
    }

    public int dequeue(){
        //base condition is that if both are empty
        //then return -1
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public int peek(){

        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    }

public class D {
    public static void main(String [] args){
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        
        q.dequeue();
        q.dequeue();
        System.out.println(q.peek());
    }
}
