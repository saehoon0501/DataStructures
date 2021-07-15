
import java.awt.*;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class PointComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        double distance1 = Math.sqrt(((Point) o1).getX()* ((Point) o1).getX()
                                            + ( ((Point) o1).getY()* ((Point) o1).getY()));
        double distance2 = Math.sqrt((((Point) o2).getX()*((Point) o2).getX())
                                            + (((Point) o2).getY()*((Point) o2).getY()));
        if (distance1 < distance2){
            return -1;
        }else if(distance1 == distance2){
            return 0;
        }
        return 1;
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator thenComparing(Comparator other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public Comparator thenComparing(Function keyExtractor, Comparator keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public Comparator thenComparing(Function keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator thenComparingInt(ToIntFunction keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator thenComparingLong(ToLongFunction keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator thenComparingDouble(ToDoubleFunction keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}
