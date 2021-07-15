package com.company.기말;

import java.util.ArrayList;

public class MyNode {

    private Object element;
    private MyNode parent;
    private ArrayList children;

    public MyNode() {
        this.element = null;
        this.parent = null;
        this.children = null;
    }

    public MyNode(Object e) {
        this.element = e;
        this.parent = null;
        this.children = new ArrayList();
        this.children.add(null);
        this.children.add(null);
    }

    public Object element() {
        return this.element;
    }

    public MyNode parent() {
        return this.parent;
    }

    public ArrayList children() {
        return this.children;
    }

    public int degree() {
        return this.children.size();
    }

    public void setElement(Object e) {
        this.element = e;
    }

    public void setParent(MyNode p) {
        this.parent = p;
    }

    public void setChildren(ArrayList c) {
        this.children = c;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "element=" + element +
                '}';
    }
}
