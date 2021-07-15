package com.company.기말;

public class MyNodeList {
    public MyNode2 head;
    public MyNode2 tail;
    int size;

    public MyNodeList() {
        head = new MyNode2();
        tail = new MyNode2();
    }

    public MyNode2 addFirst(Object e){
        MyNode2 item = new MyNode2(e);
        if (size == 0){
            this.head.prev = item;
            item.next = head;
            tail.next = item;
            item.prev = tail;
            return item;
        }

        item.next = this.head;
        this.head.getPrev().next = item;
        this.head.prev = item;
        item.prev = this.head.getPrev();

        size++;
        return item;
    }

    public MyNode2 addLast(Object e){
        MyNode2 item = new MyNode2(e);
        if (getSize() == 0){
            head.prev = item;
            tail.next = item;
            item.next = head;
            item.prev = tail;
        }else{
            item.prev = this.tail;
            item.next = this.tail.getNext();
            this.tail.next.prev = item;
            this.tail.next = item;
        }
        size++;
        return item;
    }

    public MyNode2 addAfter(Object e, MyNode2 n){
        if (n == null){
            return null;
        }else if (n == tail){
            MyNode2 item = new MyNode2(e);
            MyNode2 temp = tail;
            item.next = temp;
            temp.prev = item;
            item = tail;
            size++;
            return item;
        }else {
            MyNode2 item = new MyNode2(e);
            n.getPrev().next = item;
            item.prev = n.getPrev();
            n.prev = item;
            item.next = n;
            size++;
            return item;
        }
    }

    public void remove(MyNode2 e) {
        if (head == e || tail == e)
            return;
        MyNode2 node = head;
        while(node.getPrev() != null){
            if (node.getPrev() == e){
                MyNode2 termit = node.getPrev();
                termit.getPrev().next = termit.getNext();
                termit.getNext().prev = termit.getPrev();
                size--;
                return;
            }
            node = node.getPrev();
        }
    }

    public MyNode2 NodeAt(int index){
        if (index > size){
            return null;
        }
        int i = 0;
        MyNode2 n = head.getPrev();
        while (i < index){
            n = n.getPrev();
            i++;
        }
        return n;
    }

    public int getSize() {return  this.size;}

    public MyNode2 getHead() {
        return head;
    }

    public MyNode2 getTail() {
        return tail;
    }
}
