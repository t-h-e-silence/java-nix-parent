package level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void area() {
        Triangle t= new Triangle();
        double area= t.area(15,15,23,30,50,25);
        assertEquals(area, 222.5);
        area= t.area(15,15,23,15,50,15);
        area= t.area(0,0,3,2, 7, 5);
        assertEquals(area, 0.5);
    }
}