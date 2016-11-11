package leetcode.ReconstructItinerary;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/12/16.
 */
public class TestSolution {
    SolutionSort solution = new SolutionSort();
//    Solution solution = new Solution();

    @Test
    public void test0() {
        String[][]  tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        Assert.assertArrayEquals(new String[] {"JFK","ATL","JFK","SFO","ATL","SFO"}, solution.findItinerary(tickets).toArray());
    }

    @Test
    public void test1() {
        String[][] tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        Assert.assertArrayEquals(new String[] {"JFK", "MUC", "LHR", "SFO", "SJC"}, solution.findItinerary(tickets).toArray());
    }

    @Test
    public void test2() {
        String[][] tickets = {{"JFK", "ATL"}, {"JFK", "SFO"}, {"JFK", "SJC"}, {"SFO", "JFK"}, {"SFO", "SJC"}, {"SJC", "SFO"}, {"SJC", "JFK"}};
        Assert.assertArrayEquals(new String[] {"JFK", "SFO", "JFK", "SJC", "SFO", "SJC", "JFK", "ATL"}, solution.findItinerary(tickets).toArray());
    }
}
