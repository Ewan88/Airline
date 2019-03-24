import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;
    Flight flight;
    Date departureTime = new Date(2019, 4, 20, 16, 20);

    @Before
    public void setup(){
        flight = new Flight(PlaneType.HONDA_HA_420, "CC420", "YVA", "GLA", departureTime);
        passenger = new Passenger(2, "Bob", flight);
    }

    @Test
    public void passengerHasBags(){
        assertEquals(2, passenger.getBags());
    }

    @Test
    public void passengerHasName(){
        assertEquals("Bob", passenger.getName());
    }

    @Test
    public void passengerHasFlight() {
        assert(passenger.getFlight() instanceof Flight);
    }

    @Test
    public void passengerHasSeatNumber() {
        passenger.setSeatNumber(1);
        assertEquals(1, passenger.getSeatNumber());
    }
}
