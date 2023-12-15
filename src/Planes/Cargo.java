package Planes;

public class Cargo extends Plane{
private int  doors;
    public Cargo(){
        super();
        doors = 0;
    }
    public  Cargo(double range, int max_speed ,double max_payload , double ENG_power,double length ,double fuel_cons,String model ,String brand , int doors)
    {
        super(range,max_speed,max_payload,ENG_power,length,fuel_cons,model,brand );
        this.doors = doors;
    }
    @Override
    public  String SQL_SPEC(){
        return  super.SQL_SPEC() ;
    }
    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
