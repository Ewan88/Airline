import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void setup(){
        plane = new Plane(PlaneType.HONDA_HA_420);
    }

    @Test
    public void planeHasType(){
        assertEquals(PlaneType.HONDA_HA_420, plane.getType());
    }

    @Test
    public void planeHasCapacity(){
        assertEquals(6, plane.getCapacity());
    }

    @Test
    public void planeHasWeight(){
        assertEquals(1541, plane.getTotalWeight());
    }

}
