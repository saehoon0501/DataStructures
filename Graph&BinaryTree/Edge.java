package com.company.기말;

public class Edge { //Graph의 Edge 선언
    public Object element;
    public MyNode2 backlink;
    public Vertex origin;
    public Vertex destin;
    public String label;
    public Object originBackLink; //Adjacency의 경우
    public Object destinBackLink; //Adjacency의 경우

    public Edge() {
    }

    public Edge(Object e) {
        this.element = e;
        this.label = "UNEXPLORED";
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public MyNode2 getBacklink() {
        return backlink;
    }

    public void setBacklink(MyNode2 backlink) {
        this.backlink = backlink;
    }

    public Vertex getOrigin() {
        return origin;
    }

    public void setOrigin(Vertex origin) {
        this.origin = origin;
    }

    public Vertex getDestin() {
        return destin;
    }

    public void setDestin(Vertex destin) {
        this.destin = destin;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "element='" + element + '\'' +
                '}';
    }
}
