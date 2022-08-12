import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMapTest {
    private CarMap map;

    @BeforeEach
    void setUp() {
        map = new CarHashMap();
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i,"LastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
    }

    @Test
    void put() {
        CarOwner carOwner = new CarOwner(101, "Name" + 101,"LastName" + 101);
        Car car = new Car("Brand" + 101, 101);
        assertEquals(100, map.size());
    }

    @Test
    void get() {
      assertEquals("Brand1", map.get(new CarOwner(1, "Name1", "LastName1")).getBrand());
    }

    @Test
    void remove() {
        map.remove(new CarOwner(1, "Name1", "LastName1"));
        assertEquals(99, map.size());
    }

    @Test
    void size() {
        assertEquals(100, map.size());
        assertEquals(100, map.keySet().size());
        assertEquals(100, map.values().size());
    }

    @Test
    void clear() {
        map.clear();
        assertEquals(0, map.size());
    }
}