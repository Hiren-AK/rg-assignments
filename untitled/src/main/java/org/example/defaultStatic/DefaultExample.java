package org.example.defaultStatic;

interface Vehicle{
    String getBrand();
    String speedUp();
    String slowDown();

    default String turnAlarmOn(){
        return "Turn vehicle alarm on";
    }

    static String getCompany(){
        return "Car";
    }
}
class Car implements Vehicle{
    @Override
    public String getBrand() {
        return "brand";
    }

    @Override
    public String speedUp() {
        return "speed up";
    }

    @Override
    public String slowDown() {
        return "slow down";
    }
}
public class DefaultExample {
    public static void main(String[] args){
        Vehicle vehicle = new Car();
        System.out.println(vehicle.turnAlarmOn());
        System.out.println(Vehicle.getCompany());
    }
}
