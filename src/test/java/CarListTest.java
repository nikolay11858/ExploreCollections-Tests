import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarListTest {
    private CarList carList;

    @BeforeEach
    public void setUp() {
        carList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }
    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
      assertEquals(100,carList.size());
    }
    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        carList.removeAt(3);
        assertEquals(99, carList.size());
    }
    @Test
    public void whenElementRemovedByNameThenSizeMustBeDecreased() {
        Car car = new Car("Toyota", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());

    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Toyota", 15);
        assertFalse(carList.remove(car));
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }
    @Test
    public void whenIndexOutOfBoundsThenThrowsException(){
        Boolean isError = false;
        try {
            carList.get(100);
        } catch (IndexOutOfBoundsException e) {
            isError = true;
        }
        assertTrue(isError);
    }
    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("BMW", 1);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("BMW", 1);
        carList.add(car, 3);
        Car carFromList = carList.get(3);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("BMW", 1);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void searchCar() {
        assertTrue(carList.contains(new Car("Brand31",31)));
        assertFalse(carList.contains(new Car("Brand311",311)));

    }
}