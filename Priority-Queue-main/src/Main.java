
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	//실습 1.
        IntComparator comp = new IntComparator();
        MyPQ pq = new MyPQ(comp);

        pq.insert(new Integer(30), null);
        pq.insert(new Integer(10), null);
        pq.insert(new Integer(20), null);

        System.out.println((Integer)pq.removeMin().getKey());
        System.out.println((Integer)pq.removeMin().getKey());
        System.out.println((Integer)pq.removeMin().getKey());

    //실습 2.
        PointComparator comp2 = new PointComparator();
        MyPQ pq2 = new MyPQ(comp2);

        Point a = new Point(5,4);
        Point b = new Point(2,7);
        Point c = new Point(9,5);
        Point d = new Point(3,1);
        Point e = new Point(7,2);
        Point f = new Point(9,7);
        Point g = new Point(1,4);
        Point h = new Point(4,3);
        Point i = new Point(8,2);
        Point j = new Point(4,8);

        pq2.insert(a,null);
        pq2.insert(b,null);
        pq2.insert(c,null);
        pq2.insert(d,null);
        pq2.insert(e,null);
        pq2.insert(f,null);
        pq2.insert(g,null);
        pq2.insert(h,null);
        pq2.insert(i,null);
        pq2.insert(j,null);

        System.out.println("----------------------------------------------------------------------------------\n");


        System.out.println("[가까이 있는 순서]");
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());

        System.out.println("----------------------------------------------------------------------------------\n");

        PointComparator2 comp3 = new PointComparator2();
        pq2.setComp(comp3);

        pq2.insert(a,null);
        pq2.insert(b,null);
        pq2.insert(c,null);
        pq2.insert(d,null);
        pq2.insert(e,null);
        pq2.insert(f,null);
        pq2.insert(g,null);
        pq2.insert(h,null);
        pq2.insert(i,null);
        pq2.insert(j,null);

        System.out.println("[멀리 있는 순서]");
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
        System.out.println((Point)pq2.removeMin().getKey());
    }
}
