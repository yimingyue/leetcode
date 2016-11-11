package leetcode.MiniParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 9/18/16.
 */

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public class NestedInteger {
    Integer val;
    List<NestedInteger> list;

    public NestedInteger() {
        list = new ArrayList<>();
    }

    public NestedInteger(int val) {
        this.val = val;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return val != null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return val;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        this.val = value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }
}