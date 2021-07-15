package com.company.tree_node;

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

    public MyNode(Object element) {
        this.element = element;
        this.parent = null;
        this.children = null;
    }

    public int degree(){ // Node의 degree
        return this.children.size();
    }

    public Object element() {
        return this.element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public MyNode parent() {
        return this.parent;
    }

    public void setParent(MyNode parent) {
        this.parent = parent;
    }

    public ArrayList<MyNode> children() {
        return children;
    }

    public void setChildren(ArrayList children) {
        this.children = (children);
    }

    @Override
    public String toString() {
        return  element + "";
    }
}
