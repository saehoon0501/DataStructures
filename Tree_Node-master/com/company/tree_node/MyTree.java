package com.company.tree_node;

import java.util.ArrayList;

public class MyTree {
    private MyNode root;
    private int size;

    public MyTree() {
        this.root = null;
        this.size = 1;
    }

    public MyTree(Object e) {
        this.root = new MyNode(e);
        this.root.setChildren(new ArrayList());
        this.size = 1;
    }

    public int degree(){    // Tree의 degree 반환
        return degree(this.root);
    }

    private int degree(MyNode v){
        int h = 0;
        if(isExternal(v)) {
            return 0;
        }
        for(MyNode e : v.children()){
            h = Math.max(v.degree(), degree(e));
            }
        return h;
    }

    public  int size(){ // Tree에 저장된 총 element의 수 return
        return this.size;
    }


    public MyNode root(){ //Tree의 root Node 반환
        return this.root;
    }

    public MyNode addRoot(Object e){ //Root에 Object e element 저장
        this.root.setElement(e);
        return this.root;
    }

    public ArrayList children(MyNode v){ // Node v의 child Node들의 List 반환
        return v.children();
    }

    public boolean isExternal(MyNode v){ // Leaf Node면 true
            if(v.children().isEmpty()){
                    return true;
            }
            return false;
    }

    public MyNode addChild(Object e){ // root의 Arraylist에 child Node 추가
        MyNode v = new MyNode(e);
        v.setChildren(new ArrayList());
        v.setParent(this.root);
        v.setElement(e);
        this.root.children().add(v);
        size += 1;
            return v;
    }

    public MyNode addChild(MyNode v, Object e){ //Node v에 object e 추가
        v.children().add((MyNode) e);
        size += 1;
        return v;
    }

    public MyNode addChild(MyNode v, int i, Object e){ // Node v의 Arraylist index i에 child Node 추가
        MyNode o = new MyNode(e);
        o.setChildren(new ArrayList());
            o.setParent(v);
            v.children().add(i,o);
        size += 1;
            return o;
    }

    public MyNode setChild(MyNode v, int i , Object e){ //Arraylist index i에 있는 child Node 대체
            v.setElement(e);
            this.root.children().set(i,v);
            return v;
    }

    public MyNode removeChild(MyNode v, int i){ // Node v의 child node에서 index i에 해당하는 Node 제거 및 return
        v.children().set(i, null);
        size -= 1;
        return v;
    }

}
