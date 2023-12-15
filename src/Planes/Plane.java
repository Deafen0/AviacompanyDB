package Planes;

import java.util.Scanner;

public abstract class Plane {
    private int max_speed;
    private double max_payload;
    private double ENG_power;
    private double length;
    private double fuel_cons;
    private String model;
    private String brand;
    private double range;


    public Plane(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Brand: ");
        brand = input.nextLine();
        System.out.println("Enter model: ");
        model = input.nextLine();
        System.out.println("Enter max payload: ");
        max_payload = input.nextDouble();
        System.out.println("Enter max speed: ");
        max_speed = input.nextInt();
        System.out.println("Enter length: ");
        length=  input.nextDouble();
        System.out.println("Enter fuel consumption: ");
        fuel_cons = input.nextDouble();
        System.out.println("Enter engine power: ");
        ENG_power = input.nextDouble();
        System.out.println("Enter max flight range: ");
        range = input.nextDouble();
    }
    public Plane(double range,int max_speed ,double max_payload , double ENG_power,double lenght ,double wingspan,String model ,String brand){
        this.max_speed =max_speed;
        this.max_payload =max_payload;
        this.ENG_power =ENG_power;
        this.length =lenght;
        this.fuel_cons =wingspan;
        this.model = model;
        this.brand = brand;
        this.range = range;
    }
    public  String SQL_SPEC() //Order: brand -> model ->max flight range -> fuel consumption -> length ->  ENG_power -> max_payload -> max_speed-> type
    {
        return "'" + brand + "', '" + model + "', '" + range + "', '" + fuel_cons + "', '" + length + "', '" + ENG_power + "', '" + max_payload + "', '" + max_speed + "', '" + getClass().getName() + "'";
    }
    public double getENG_power() {
        return ENG_power;
    }

    public double getFuel_cons() {
        return fuel_cons;
    }

    public double getMax_payload() {
        return max_payload;
    }

    public int getMax_speed() {
        return max_speed;
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setENG_power(double ENG_power) {
        this.ENG_power = ENG_power;
    }

    public void setMax_payload(double max_payload) {
        this.max_payload = max_payload;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    public void setFuel_cons(double fuel_cons) {
        this.fuel_cons = fuel_cons;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getLength() {
        return length;
    }

    public double getRange() {
        return range;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setRange(double range) {
        this.range = range;
    }
}
