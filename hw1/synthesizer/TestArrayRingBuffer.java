package synthesizer;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {

    @Test
    public void someTest() {
        ArrayRingBuffer<Double> array = new ArrayRingBuffer<>(5);
        array.enqueue(1.0);
        array.enqueue(2.0);
        array.enqueue(3.0);
        array.enqueue(4.0);
        array.enqueue(5.0);
        assertEquals((Double) 1.0, array.peek());
        Double i = 1.0;
        for (Double x : array) {
            assertEquals(i,x);
            i += 1.0;
        }

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
