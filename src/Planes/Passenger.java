package Planes;

import java.util.Scanner;

public class Passenger extends Plane {
    private int seats;
    public Passenger(){
        super();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of seats: ");
        seats = input.nextInt();
    }
    @Override
    public  String SQL_SPEC(){
        return  super.SQL_SPEC() + ", " +seats;
    }
    public  Passenger(double range, int max_speed ,double max_payload , double ENG_power,double length ,double fuel_cons,String model ,String brand , int seats)
    {
        super(range,max_speed,max_payload,ENG_power,length,fuel_cons,model,brand );
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
