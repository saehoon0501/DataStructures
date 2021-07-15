package com.company.기말;

import java.util.ArrayList;

public class ELGraph {// findsub에서 사용하고자 하는 Graph 구조 -> spanning Tree 찾기
    public MyNodeList vertice;
    public MyNodeList edges;

    public ELGraph() {
        this.vertice = new MyNodeList();
        this.edges = new MyNodeList();
    }

    public MyNodeList vertices(){
        return this.vertice;
    }
    public MyNodeList edges(){
        return this.edges;
    }
    public ArrayList incidentEdges(Vertex v){
        ArrayList result = new ArrayList();
        for (int i =0; i<this.edges.size; i++){
            Vertex origin = (((Edge) edges.NodeAt(i).getElement()).getOrigin());
            Vertex destin = (((Edge) edges.NodeAt(i).getElement()).getDestin());
            if (origin == v || destin == v){
                result.add(edges.NodeAt(i).getElement());
            }
        }
        return result;
    }
    public Vertex opposite(Vertex v, Edge e){
        Vertex origin = (e.getOrigin());
        Vertex destin = (e.getDestin());
        if (origin == v){
            return destin;
        }else if (destin == v){
            return origin;
        }
        return null;
    }

    public ArrayList endVertices(Edge e){
        ArrayList result = new ArrayList();
        for (int i =0; i<this.edges.size; i++){
            Vertex origin = (((Edge) edges.NodeAt(i).getElement()).getOrigin());
            Vertex destin = (((Edge) edges.NodeAt(i).getElement()).getDestin());
            if (e == (Edge) edges.NodeAt(i).getElement()){
                result.add(origin);
                result.add(destin);
            }
        }
        return result;
    }

    public boolean areAdjacent(Vertex v, Vertex w){
        for (int i =0; i<this.edges.size; i++){
            Vertex origin = (((Edge) edges.NodeAt(i).getElement()).getOrigin());
            Vertex destin = (((Edge) edges.NodeAt(i).getElement()).getDestin());
            if ((origin == v && destin == w) || (origin == w && destin == v)){
                return true;
            }
        }
        return false;
    }

    public void replace(Vertex v, Object x){
        v.element = x;
    }

    public void replace(Edge e, Object x){
        e.element = x;
    }

    public Vertex insertVertex(Vertex x){
        this.vertice.addLast(x);
        x.backlink = this.vertice.NodeAt(this.vertice.size-1);
        return (Vertex) x.backlink.getElement();
    }

    public Edge insertEdge(Edge e, Vertex origin, Vertex destin){
        this.edges.addLast(e);
        e.backlink = this.edges.NodeAt(this.edges.size-1);
        e.origin = origin;
        e.destin = destin;
        e.element = origin +"" + destin;
        return (Edge) e.backlink.getElement();
    }

    public void removeVertex(Vertex v){
        vertice.remove(v.backlink);
        for (int i =0; i<this.edges.size; i++){
            Vertex origin = (((Edge) edges.NodeAt(i).getElement()).getOrigin());
            Vertex destin = (((Edge) edges.NodeAt(i).getElement()).getDestin());
            if ((origin == v) || (destin == v)){
                edges.remove(edges.NodeAt(i));
            }
        }
    }

    public void removeEdge(Edge e){
        for (int i =0; i<this.edges.size; i++){
            if ((((Edge) edges.NodeAt(i).getElement())) == e){
                edges.remove(edges.NodeAt(i));
            }
        }
    }
}
