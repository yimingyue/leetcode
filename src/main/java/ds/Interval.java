package ds;

/**
 * Created by ymyue on 10/22/16.
 */
public class Interval {
    public int start;
    public int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Interval(Interval another) {
        this.start = another.start;
        this.end = another.end;
    }
}
