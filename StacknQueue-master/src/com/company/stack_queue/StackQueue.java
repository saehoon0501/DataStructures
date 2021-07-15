package com.company.stack_queue;

public class StackQueue implements Queue{
    public ArrayStack inStack;
    public ArrayStack outStack;
    public char[] temp;
    public int size;

    public StackQueue(int n) {
        this.size = n;
        this.inStack = new ArrayStack(size);
        this.outStack = new ArrayStack(size);
        temp = new char[size];
    }

    @Override
    public int size() {
        return inStack.size();
    }

    @Override
    public boolean isEmpty(){
        return inStack.isEmpty();
    }

    @Override
    public char front() {
        return inStack.top();
    }

    @Override
    public void enqueue(char o) {
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        inStack.push(o);

        while(!outStack.isEmpty()){
            inStack.push(outStack.pop());
        }
    }

    @Override
    public char dequeue() {
        return inStack.pop();
    }
}
