package com.company.tree_node;

public class Main {

    public static void main(String[] args) {
	// 1번
        MyTree mytree = new MyTree("Make money fast");
        mytree.addChild(" 1.Motivations");
        mytree.addChild(" 2.Methods");
        mytree.addChild(" References");

        MyNode a = mytree.root().children().get(0);
        MyNode b = mytree.root().children().get(1);

        mytree.addChild(a,0,"  1.1 Greed");
        mytree.addChild(a, 1, "  1.2 Avidity");

        mytree.addChild(b,0,"  2.1 Stock Fraud");
        mytree.addChild(b,1,"  2.2 Ponzi Scheme");
        mytree.addChild(b,2,"  2.3 Bank Robbery");

        preOrder(mytree.root());
        System.out.println("----------------------------------------------------------------------------");
    // 2번
        MyTree mytree2 = new MyTree("cs16/");
        mytree2.addChild("homeworks/");
        mytree2.addChild("programs/");
        mytree2.addChild("todo.txt 1 KB");

        a = mytree2.root().children().get(0);
        b = mytree2.root().children().get(1);

        mytree2.addChild(a,0,"h1c.doc 3 KB");
        mytree2.addChild(a, 1, "h1nc.doc 2 KB");

        mytree2.addChild(b,0,"DDR.java 10 KB");
        mytree2.addChild(b,0,"Stocks.java 25 KB");
        mytree2.addChild(b,0,"Robot.java 20 KB");
        postOrder(mytree2.root());
    }

    public static void preOrder(MyNode v){
        System.out.println(v);
        for(MyNode e : v.children()){
            preOrder(e);
        }
    }

    public static int postOrder(MyNode v){
        int num = 0;
        if(!v.children().isEmpty()){
            for(MyNode e : v.children()){
              num += postOrder(e);
            }
            System.out.println(v + " = " + num + "KB");
                return num;
        }else{
            String o = (String) v.element();
            String[] ab = o.split(" ");
            num += Integer.parseInt(ab[1]);
        }
        return num;
    }
}
