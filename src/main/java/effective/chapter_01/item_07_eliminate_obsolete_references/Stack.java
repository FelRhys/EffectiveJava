package effective.chapter_01.item_07_eliminate_obsolete_references;

import java.util.Arrays;

// Can you spot the "memory leak"?  (Pages 26-27)
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    //Popped elements are still kept in the elements[] even though they are obsolete
    public Object pop_bad() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    //Corrected version of pop method (Page 27)
    public Object pop_good() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
