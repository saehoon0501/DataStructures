package com.company.기말;

import java.util.ArrayList;

public class MyBinTree extends MyTree {
    MyNodeList list= new MyNodeList();
    ELGraph graph = new ELGraph();

    MyBinTree(){
        super();
    }

    MyBinTree(Object e){
        super(e);
    }

    public boolean isEmpty() {
        return super.size() == 0;
    }

    public boolean isRoot(MyBinNode v) {
        return v.parent() == null;
    }

    public boolean isInternal(MyBinNode v) {
        return !this.isExternal(v);
    }

    public boolean isExternal(MyBinNode v) {
        if(!this.hasLeft(v) && !this.hasRight(v))
            return true;
        else
            return false;
    }

    public MyBinNode root() {
        return (MyBinNode)super.root();
    }

    public MyBinNode parent (MyBinNode v) {
        return (MyBinNode)v.parent();
    }

    public MyBinNode left (MyBinNode v) {
        return (MyBinNode)v.children().get(0);
    }

    public MyBinNode right (MyBinNode v) {
        return (MyBinNode)v.children().get(1);
    }

    public boolean hasLeft (MyBinNode v) {
        return v.children().get(0) != null;
    }

    public boolean hasRight (MyBinNode v) {
        return v.children().get(1) != null;
    }

    @Override
    public MyBinNode addRoot (Object e) {
        Vertex k1 = new Vertex(e);
        graph.insertVertex(k1);
        return (MyBinNode)super.addRoot(e);
    }

    public MyBinNode inserLeft(MyBinNode v, Object e) { //추가시 Vertex와 Edge도 같이 추가 해준다.

        MyBinNode mbn = null;

        if(!this.hasLeft(v)) {
            mbn = (MyBinNode)super.setChild(v, 0, e);
            System.out.println(mbn.element());
            graph.insertVertex(new Vertex(mbn.element()));
            graph.insertEdge(new Edge(), new Vertex(v.element()), new Vertex(mbn.element()));
        }

        return mbn;
    }

    public MyBinNode inserRight(MyBinNode v, Object e) {

        MyBinNode mbn = null;

        if(!this.hasRight(v)) {
            mbn = (MyBinNode)super.setChild(v, 1, e);
            System.out.println(mbn.element());
            graph.insertVertex(new Vertex(mbn.element()));
            graph.insertEdge(new Edge(), new Vertex(v.element()), new Vertex(mbn.element()));
        }

        return mbn;
    }

    public MyBinNode addNode (Object e) {

        MyBinNode return_node = null;

        if(hasLeft((MyBinNode)super.root()) && hasRight((MyBinNode)super.root())) {
            // 2 children exist
            System.out.println("Can't add Node because Two Children exist !");
        }
        else if(hasLeft((MyBinNode)super.root())) {
            // left children exist - addNode to right
            return_node =  this.inserRight((MyBinNode)super.root(), e);
        }
        else if(hasRight((MyBinNode)super.root())){
            // right children exist - addNode to left
            return_node =  this.inserLeft((MyBinNode)super.root(), e);
        }
        else {
            // children is empty
            return_node =  this.inserLeft((MyBinNode)super.root(), e);
        }

        return return_node;
    }

    public Object replace(MyBinNode v, Object e) {
        Object temp = v.element();
        v.setElement(e);
        return temp;
    }

    public MyBinNode remove(MyBinNode v) throws TwoChildrenException {

        MyBinNode parent = (MyBinNode)v.parent();

        int idx = 0;

        if(this.left(parent) == v) {
            // v�? parent?�� leftNode
            idx = 0;
        }
        else {
            // v�? parent?�� rightNode
            idx = 1;
        }

        if(this.hasLeft(v) && this.hasRight(v)) {
            // two children
            throw new TwoChildrenException("TwochildException!!");
        }
        else if(this.hasLeft(v)) {
            // one children - left
            MyBinNode children = (MyBinNode)v.children().get(0);
            parent.children().set(idx, children);
            children.setParent(parent);
        }
        else if(this.hasRight(v)) {
            // one children - right
            MyBinNode children = (MyBinNode)v.children().get(1);
            parent.children().set(idx, children);
            children.setParent(parent);
        }
        else {
            // no children
            parent.children().set(idx, null);
        }

        return v;
    }

    public void attach (MyBinNode v, MyBinNode t1, MyBinNode t2) throws NotExternalException{

        if(this.isExternal(v)) {
            this.inserLeft(v, t1.element());
            this.inserRight(v, t2.element());
        }
        else {
            throw new NotExternalException("NotExternalException !!");
        }

    }

    public void preOrder(MyBinNode v) {

        System.out.print(v.element()+" ");

        if(this.hasLeft(v))
            preOrder(this.left(v));

        if(this.hasRight(v))
            preOrder(this.right(v));


    }

    public void inOrder(MyBinNode v) {

        if(this.hasLeft(v)) {
            System.out.print("(");
            inOrder(this.left(v));
        }

        System.out.print(v.element()+"");

        if(this.hasRight(v)) {
            inOrder(this.right(v));
            System.out.print(")");
        }
    }

    public void postOrder(MyBinNode v) {

        if(this.hasLeft(v)) {
            System.out.print("(");
            inOrder(this.left(v));
        }

        if(this.hasRight(v)) {
            inOrder(this.right(v));
            System.out.print(")");
        }

        System.out.print(v.element()+"");
    }


    class TwoChildrenException extends Exception {

        TwoChildrenException(String msg){
            super(msg);
        }

    }

    class NotExternalException extends Exception {

        NotExternalException(String msg){
            super(msg);
        }
    }

}