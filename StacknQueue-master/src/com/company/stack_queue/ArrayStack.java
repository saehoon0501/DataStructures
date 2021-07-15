package com.company.stack_queue;

import java.util.EmptyStackException;

public class ArrayStack implements Stack{
    public char [] stack;
    public int t;
    public int size;

    public ArrayStack(int n) {
        this.size = n;
        this.stack = new char[size];
        this.t = -1;
    }

    @Override
    public int size() {
        return t+1;
    }

    @Override
    public boolean isEmpty() {
        if(t < 0){
            return true;
        }
        return false;
    }

    @Override
    public char top() {
        return this.stack[t];
    }

    @Override
    public void push(char o) {
        if(t+1 == size){
            throw new StackOverflowError("Stackoverflow");
        }
        t = t + 1;
        stack[t] = o;
    }

    @Override
    public char pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        char temp = stack[t];
        t = t -1;
        return temp;
    }

    public boolean ParenMatch(char[] X) {
        for (int i = 0; i < X.length; i++) {
            if (X[i] == '(' || X[i] == '{' || X[i] == '[') {
                this.push(X[i]);
            } else if (X[i] == ')' || X[i] == '}' || X[i] == ']') {
                if(this.isEmpty()){
                    return false;
                }
                switch (X[i]) {
                    case ')':
                        if (this.pop() != '(') {
                            return false;
                        }break;
                    case '}':
                        if (this.pop() != '{') {
                            return false;
                        }break;
                    case ']':
                        if (this.pop() != '[') {
                            return false;
                        }break;
                }
            }
        }
        if (this.isEmpty()) {
            return true;
        }
        return false;
    }

    public void reverse(char [] stackArray) {
            if(this.ParenMatch(stackArray)){
                for (char c : stackArray) {
                    switch(c){
                      case'(':
                        c = ')';
                        break;
                        case'{':
                            c = '}';
                            break;
                        case'[':
                            c = ']';
                            break;
                        case')':
                            c = '(';
                            break;
                        case'}':
                            c = '{';
                            break;
                        case']':
                            c = '[';
                            break;
                    }
                    this.push(c);
                }

                System.out.println("결과: ");
                String result = "";

                for (int i = 0; i < size; i++) {
                    result += this.pop();
                }
                System.out.println(result);

            }else{
                System.out.println("invalid parentheses syntax");
            }
        }



}
