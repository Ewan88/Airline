import java.util.ArrayList;

public class FlightManager {

    private FlightManager manager;
    private Flight flight;
    private int baggageWeight = 20; // assume one luggage weighs 20kg
    private int passengerWeight = 100; // assume one person weighs 100kg

    public FlightManager(Flight flight){
        this.flight = flight;
    }

    public int reservedBaggage() {
        return this.flight.getPlane().getTotalWeight() - ((baggageWeight + passengerWeight) * 2);
        // reserve two pilots and two baggage
    }

    public int bookedBaggage() {
        ArrayList<Passenger> passengers =  this.flight.getPassengers();
        int baggageCount = 0;
        for (Passenger passenger : passengers){
            baggageCount += passenger.getBags();
        }
        return baggageCount * baggageWeight;
    }

    public int remainingBaggage() {
        return this.reservedBaggage() - this.bookedBaggage();
    }
}
