import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber, destination, departureAirport;
    private Date departureTime;
    private int[] seats;

    public Flight(PlaneType plane, String flightNumber, String destination, String departureAirport, Date departureTime){
        this.passengers = new ArrayList<Passenger>();
        this.plane = new Plane(plane);
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.seats = new int[this.plane.getCapacity()];
        for (int i = 0; i < this.seats.length; i++) {
            this.seats[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(this.seats));
    }

    public int countPassengers() {
        return this.passengers.size();
    }

    public PlaneType getPlane() {
        return this.plane.getType();
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDepartureAirport() {
        return this.departureAirport;
    }

    public Date getDepartureTime() {
        return this.departureTime;
    }

    public int checkSeats() {
        return this.plane.getCapacity() - this.countPassengers();
    }

    public void book(Passenger passenger) {
        if (this.countPassengers() < this.plane.getCapacity()){
            this.passengers.add(passenger);
            this.assignSeat(passenger);
        }
    }

    private void assignSeat(Passenger passenger) {
        int seatIndex = this.passengers.size() - 1;
        passenger.setSeatNumber(this.seats[seatIndex]);
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }
}
