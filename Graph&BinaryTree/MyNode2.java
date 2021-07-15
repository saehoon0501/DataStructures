package com.company.기말;

public class MyNode2 {
    public MyNode2 next;
    public MyNode2 prev;
    public Object element;

    public MyNode2() {
    }

    public MyNode2(Object element) {
        this.element = element;
    }

    public MyNode2 getNext() {
        return next;
    }

    public void setNext(MyNode2 next) {
        this.next = next;
    }

    public MyNode2 getPrev() {
        return prev;
    }

    public void setPrev(MyNode2 prev) {
        this.prev = prev;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }
}
