package StackQueues;

class Stack {
    int [] arr;
    int size;
    int top;

    Stack(int size){
        this.size = size;
        arr = new int [size];
        top = -1;
    }

    public void push(int data){

        arr[++top] = data;
    }
    public int pop(){
        return arr[top--];
    }
    public int peek(){
        return arr[top];
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public void display(){

        for(int i = top ; i >= 0; i--){
            System.out.println(arr[i]+" ");
        }
    }

}

public class A{
    public static void main(String[] args){
        Stack st = new Stack(5);
        st.push(3);

    }
}