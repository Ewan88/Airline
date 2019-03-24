public enum PlaneType {

    // https://en.wikipedia.org/wiki/Honda_HA-420_HondaJet#Specifications
    HONDA_HA_420(6, 4808 - 3267); // tWeight = 1541

    private final int capacity;
    private final int tWeight;

    PlaneType(int capacity, int tWeight){
        this.capacity = capacity;
        this.tWeight = tWeight;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getTotalWeight(){
        return this.tWeight;
    }

}
