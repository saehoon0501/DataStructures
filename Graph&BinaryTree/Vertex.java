package com.company.기말;

import java.util.ArrayList;

public class Vertex { //Graph의 Vertex 선언
    public Object element;
    public MyNode2 backlink;
    public String label;
    public ArrayList incidenceList; // Adjacency의 경우

    public Vertex(Object e) {
        element =e;
        incidenceList = new ArrayList();
        this.label = "UNDISCOVERED";
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

    @Override
    public String toString() {
        return element.toString();
    }
}
