import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarQueueTest {
    private CarQueue queue;

    @BeforeEach
    void setUp() {
        queue = new CarLinkedList();
        for (int i = 0; i < 10; i++) {
            queue.add(new Car("Brand" + i, i));
        }
        assertEquals(10, queue.size());
    }

    @Test
    void add() {
        queue.add(new Car("Brand11", 11));
        assertEquals(11, queue.size());
    }

    @Test
    void peek() {
        Car car = queue.peek();
        assertEquals("Brand0", car.getBrand());
        assertEquals(10, queue.size());
    }

    @Test
    void poll() {
        Car car = queue.poll();
        assertEquals("Brand0", car.getBrand());
        assertEquals(9, queue.size());

    }
}