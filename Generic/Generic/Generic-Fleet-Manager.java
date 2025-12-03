import java.util.*;
public class GenericFleetManagerDemo {
    static class Vehicle {
        private String id;
        Vehicle(String id){ this.id = id; }
        public String toString(){ return getClass().getSimpleName() + ":" + id; }
    }
    static class Truck extends Vehicle { Truck(String id){ super(id); } }
    static class Bike extends Vehicle { Bike(String id){ super(id); } }
    static class FleetManager<T extends Vehicle> {
        private List<T> fleet = new ArrayList<>();
        public void addVehicle(T v){ fleet.add(v); }
        public void showFleet(){ for(T v : fleet) System.out.println(v); }
    }
    public static void main(String[] args){
        FleetManager<Truck> truckManager = new FleetManager<>();
        truckManager.addVehicle(new Truck("T-100"));
        truckManager.addVehicle(new Truck("T-101"));
        truckManager.showFleet();
        FleetManager<Bike> bikeManager = new FleetManager<>();
        bikeManager.addVehicle(new Bike("B-10"));
        bikeManager.showFleet();
    }
}

