package facebook.ImplementCircularBuffer;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

/**
 * Created by ymyue on 2/4/16.
 */
public class CircularBuffer<T> {
    T[] buffer;
    int maxBufferSize;
    int bufferSize;
    int head;
    int tail;

    public CircularBuffer(int n) {
        this.maxBufferSize = n;
        this.buffer = (T[]) new Object[n];
        this.bufferSize = 0;
        this.head = 0;
        this.tail = 0;
    }

    public void add(T t) {
        if (!fullBuffer()) {
            bufferSize++;
            buffer[tail++] = t;
            tail %= maxBufferSize;
        } else
            throw new BufferOverflowException();
    }

    public T get() {
        T tmp = null;
        if (!emptyBuffer()) {
            bufferSize--;
            tmp = buffer[head++];
            head %= maxBufferSize;
        } else
            throw new BufferUnderflowException();
        return tmp;
    }

    public boolean fullBuffer() {
        return bufferSize == maxBufferSize;
    }

    public boolean emptyBuffer() {
        return bufferSize == 0;
    }
}
