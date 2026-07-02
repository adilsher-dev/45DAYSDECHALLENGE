package StackQueues;

class Queues{
    int [] arr;
    int front;
    int rear;
    int size;

    Queues(int size){
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }
    public void queue(int data){
        if(front == -1){
            front = 0;
        }
        arr[++rear] = data;
    }
    public int dequeue(){
        return arr[front--];
    }
    public int peek(){
        return arr[front];
    }
    public boolean isEmpty(){
        return front == -1 || front > rear;
    }
    public void display(){
        for(int i = front ; i <= rear;i++){
            System.out.println(arr[i]+ " ");
        }
    }
}

public class B {
    public static void main(String[] args){
        Queues q = new Queues(5);
    }
    
}
