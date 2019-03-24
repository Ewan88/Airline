import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    FlightManager manager;
    Flight flight1;
    Passenger passenger1, passenger2, passenger3, passenger4, passenger5, passenger6;
    Passenger[] passengers;
    Date departureTime = new Date(2019, 04, 20, 16, 20);

    @Before
    public void setup(){
        flight1 = new Flight(PlaneType.HONDA_HA_420, "CC420", "YCA", "GLA", departureTime);
        passenger1 = new Passenger(2, "Mike", flight1);
        passenger2 = new Passenger(2, "Bob", flight1);
        passenger3 = new Passenger(2, "Alice", flight1);
        passenger4 = new Passenger(2, "Wendy", flight1);
        passenger5 = new Passenger(2, "Nigel", flight1);
        passenger6 = new Passenger(2, "Camilla", flight1);
        passengers = new Passenger[6];
        passengers[0] = passenger1;
        passengers[1] = passenger2;
        passengers[2] = passenger3;
        passengers[3] = passenger4;
        passengers[4] = passenger5;
        passengers[5] = passenger6;
        manager = new FlightManager(flight1);
    }

    @Test
    public void canCalculateReservedBaggageWeight(){
        assertEquals(1301, manager.reservedBaggage());
    }

    @Test
    public void canCalculateBookedBaggageWeight(){
        flight1.book(passenger1);
        flight1.book(passenger2);
        assertEquals(80, manager.bookedBaggage());
    }

    @Test
    public void canCalculateRemainingBaggageWeight(){
        flight1.book(passenger1);
        flight1.book(passenger2);
        assertEquals(1221, manager.remainingBaggage());
    }

}
