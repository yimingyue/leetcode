package MinStack;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/23/14
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class TextMinStack {
    @Test
    public void testMinStack() {
        MinStack minStack = new MinStack();
        int [] inputSequence = {0, 2, 3, -1, 5, 3, -2, 1};
        int i = 0;
        minStack.push(inputSequence[i++]);
        assertEquals(minStack.top(), 0);
        assertEquals(minStack.getMin(), 0);

        minStack.push(inputSequence[i++]);
        assertEquals(minStack.top(), 2);
        assertEquals(minStack.getMin(), 0);

        minStack.push(inputSequence[i++]);
        minStack.push(inputSequence[i++]);
        minStack.push(inputSequence[i++]);
        assertEquals(minStack.top(), 5);
        assertEquals(minStack.getMin(), -1);

        minStack.pop();
        assertEquals(minStack.top(), -1);
        assertEquals(minStack.getMin(), -1);

        minStack.pop();
        assertEquals(minStack.top(), 3);
        assertEquals(minStack.getMin(), 0);

        minStack.push(inputSequence[i++]);
        minStack.push(inputSequence[i++]);

        assertEquals(minStack.top(), -2);
        assertEquals(minStack.getMin(), -2);

        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();

        assertEquals(minStack.top(), Integer.MIN_VALUE);
        minStack.push(inputSequence[i++]);
        assertEquals(minStack.top(), 1);
        assertEquals(minStack.getMin(), 1);
    }
}
