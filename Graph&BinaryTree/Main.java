package com.company.기말;

public class Main {

    public static void main(String[] args) {
	//BST 설정
        Integer a = 23;
        Integer b = 10;
        Integer c = 33;
        Integer d = 7;
        Integer e = 17;
        Integer f = 27;
        Integer i = 33;
        Integer j = 10;
        Integer k = 13;
        Integer l = 30;
        Integer m = 25;
        Integer n = 30;

        MyBinTree binTree = new MyBinTree();
        binTree.addRoot(a);
        //Level 1
        binTree.inserLeft(binTree.root(),new MyBinNode(b));
        binTree.inserRight(binTree.root(),new MyBinNode(c));
        //Level 2
        binTree.inserLeft(binTree.root().left(),new MyBinNode(d));
        binTree.inserRight(binTree.root().left(),new MyBinNode(e));
        binTree.inserLeft(binTree.root().right(),new MyBinNode(f));
        binTree.inserRight(binTree.root().right(),new MyBinNode(i));
        //Level 3
        binTree.inserRight(binTree.root().left().left(),new MyBinNode(j));
        binTree.inserLeft(binTree.root().left().right(),new MyBinNode(k));
        binTree.inserRight(binTree.root().left().right(),new MyBinNode(l));
        binTree.inserLeft(binTree.root().right().left(),new MyBinNode(m));
        binTree.inserRight(binTree.root().right().left(),new MyBinNode(n));

        //Subgraph 생성
        MyBinTree subGraph = new MyBinTree();
        subGraph.addRoot(i);
        subGraph.inserLeft(subGraph.root(),new MyBinNode(f));
        subGraph.inserLeft(subGraph.root().left(), new MyBinNode(m));
        subGraph.inserRight(subGraph.root().left(), new MyBinNode(n));

        //Graph에 추가된 Vertice들과 Edge들 확인
        System.out.println("binTree 확인");
        for (int o = 0; o<binTree.graph.vertice.size; o++){
            System.out.println(binTree.graph.vertice.NodeAt(o).element);
        }
        for (int o = 0; o<binTree.graph.vertice.size; o++){
            System.out.println(binTree.graph.edges.NodeAt(o).element);
        }

        System.out.println("subGraph 확인");
        for (int o = 0; o<subGraph.graph.vertice.size; o++){
            System.out.println(subGraph.graph.vertice.NodeAt(o).element);
        }

        for (int o = 0; o<subGraph.graph.edges.size; o++){
            System.out.println(subGraph.graph.edges.NodeAt(o).element);
        }

        SubFinder subFinder = new SubFinder(binTree,subGraph);
        subFinder.findSub(binTree,subGraph);
    }
}
