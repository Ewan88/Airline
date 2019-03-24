import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightTest {

    Flight flight;
    Passenger passenger1, passenger2, passenger3, passenger4, passenger5, passenger6, passenger7;
    Passenger[] passengers;
    Date departureTime = new Date(2019, 4, 20, 16, 20);

    @Before
    public void setup(){
        flight = new Flight(PlaneType.HONDA_HA_420, "CC420", "YVA", "GLA", departureTime);
        passenger1 = new Passenger(2, "Mike", flight);
        passenger2 = new Passenger(2, "Bob", flight);
        passenger3 = new Passenger(2, "Alice", flight);
        passenger4 = new Passenger(2, "Wendy", flight);
        passenger5 = new Passenger(2, "Nigel", flight);
        passenger6 = new Passenger(2, "Camilla", flight);
        passenger7 = new Passenger(2, "Abdul", flight);
        passengers = new Passenger[7];
        passengers[0] = passenger1;
        passengers[1] = passenger2;
        passengers[2] = passenger3;
        passengers[3] = passenger4;
        passengers[4] = passenger5;
        passengers[5] = passenger6;
        passengers[6] = passenger7;
    }

    @Test
    public void startsWithNoPassengers(){
        assertEquals(0, flight.countPassengers());
    }

    @Test
    public void hasAPlane(){
        assert(flight.getPlane() instanceof PlaneType);
    }

    @Test
    public void hasANumber(){
        assertEquals("CC420", flight.getFlightNumber());
    }

    @Test
    public void hasADestination(){
        assertEquals("YVA", flight.getDestination());
    }

    @Test
    public void hasADeparturePoint(){
        assertEquals("GLA", flight.getDepartureAirport());
    }

    @Test
    public void hasADepartureTime(){
        Date expected = new Date(2019, 04, 20, 16, 20);
        assertEquals(expected, flight.getDepartureTime());
    }

    @Test
    public void canCheckAvailableSeats(){
        assertEquals(6, flight.checkSeats());
    }


    @Test
    public void canBookPassengers(){
        flight.book(passenger1);
        assertEquals(1, flight.countPassengers());
        assertEquals(5, flight.checkSeats());
    }

    @Test
    public void cannotBookTooManyPassengers(){
        for (Passenger passenger : passengers){
            flight.book(passenger);
        }
        assertEquals(6, flight.countPassengers());
        assertEquals(0, flight.checkSeats());
    }

    @Test
    public void canAssignSeats(){
        for (Passenger passenger : passengers){
            flight.book(passenger);
        }
        for (int i = 0; i < flight.getPassengers().size(); i++){
            assertTrue(flight.getPassengers().get(i).getSeatNumber() <= flight.getPlane().getCapacity());
            assertTrue(flight.getPassengers().get(i).getSeatNumber() > 0);
        }
    }

}
