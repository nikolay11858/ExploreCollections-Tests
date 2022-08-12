import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCollectionTest {
    private  CarCollection carCollection;

    @BeforeEach
    public void setUp() {
        carCollection = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carCollection.add(new Car("Brand" + i, i));
        }
    }
    @Test
    public void searchCar() {
        assertTrue(carCollection.contains(new Car("Brand31",31)));
        assertFalse(carCollection.contains(new Car("Brand311",311)));

    }

    @Test
    public void testForEach() {
        int index = 0;
        for (Car car : carCollection) {
            System.out.println(car.getBrand() + " " + car.getNumber());
            index++;
        }
        assertEquals(99, index);
    }


}