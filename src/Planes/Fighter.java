package Planes;

import java.util.Scanner;

public class Fighter extends Plane {
    private String type;
    public Fighter(){
        super();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter type of fighter: ");
        type = input.nextLine();
    }
    @Override
    public  String SQL_SPEC(){
        return  super.SQL_SPEC();
    }
    public  Fighter(double range, int max_speed ,int max_payload , double ENG_power,double length ,double wingspan,String model ,String brand , String type)
    {
        super(range,max_speed,max_payload,ENG_power,length,wingspan,model,brand);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
