public class Passenger {

    private int nBags, seatNumber;
    private String name;
    private Flight flight;

    public Passenger(int nBags, String name, Flight flight) {
        this.nBags = nBags;
        this.name = name;
        this.flight = flight;
        this.seatNumber = 0;
    }

    public int getBags() {
        return this.nBags;
    }

    public String getName() {
        return this.name;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
