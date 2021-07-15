package com.company.stack_queue;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ArrayStack
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write expression without space: ");
        String string = scanner.nextLine();
        char[] stackArray = new char[string.length()]; //입력받은 문자열 저장과 object 생성

        for (int i = 0; i < string.length(); i++) {
            stackArray[i] = string.charAt(i);
        }                                           // String -> char []에 저장

        ArrayStack stack = new ArrayStack(string.length());

        stack.reverse(stackArray);

        //Queue
        String A = "abcde";
        char [] B1 = A.toCharArray();
        StackQueue stackqueue = new StackQueue(15);
        for(char c : B1){
            stackqueue.enqueue(c);
        }

        System.out.println(stackqueue.dequeue());
        System.out.println(stackqueue.dequeue());
        System.out.println(stackqueue.dequeue());

        A = "fghij";
        char [] B2 = A.toCharArray();
        for(char c : B2){
            stackqueue.enqueue(c);
        }

        System.out.println(stackqueue.dequeue());
        System.out.println(stackqueue.dequeue());
        System.out.println(stackqueue.dequeue());

        A = "klmno";
        char [] B3 = A.toCharArray();
        for(char c : B3){
            stackqueue.enqueue(c);
        }

        System.out.println(stackqueue.dequeue());
        System.out.println(stackqueue.dequeue());
        System.out.println(stackqueue.dequeue());
    }
}
