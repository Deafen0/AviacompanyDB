package Aviacompany;

import Planes.Cargo;
import Planes.Fighter;
import Planes.Passenger;
import Planes.Plane;

import java.sql.*;
import java.util.Scanner;

public class CompanyDataBase  {
    private final String url = "jdbc:postgresql://localhost:5432/QantasDataBase";
    private final String password = "admin";
    private final String user = "postgres";
    Scanner input = new Scanner(System.in);
    Statement stat;
    Connection conn;
    public CompanyDataBase() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        boolean a = false;
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            System.out.println("Connection to Store DB succesfull!");
            stat = conn.createStatement();
            this.conn = conn;
            String sql = """
                           CREATE TABLE IF NOT EXISTS Planes(
                           id SERIAL PRIMARY KEY,
                           brand VARCHAR(35),
                           model VARCHAR(35),
                           type_ VARCHAR(40),
                           length_ float,
                           fuel_consumption float,
                           seats int,
                           max_range float,
                           ENG_power float,
                           max_payload float,
                           max_speed int
                           );""";
            stat.executeUpdate(sql);
            System.out.println("DB created succesfully!");
        }
    }
    public void DataBaseOutput() throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery("select * from Planes");
        System.out.println("Output");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        System.out.println(Space(rsmd.getColumnName(1), (rsmd.getColumnName(1).length() + 12)) + " | " + Space(rsmd.getColumnName(2), rsmd.getColumnName(2).length() + 12) + Space(rsmd.getColumnName(3), rsmd.getColumnName(3).length() + 20) + " | " + Space(rsmd.getColumnName(4), rsmd.getColumnName(4).length() + 12) + "|");
        while (resultSet.next()) {
            System.out.println(Space(resultSet.getString(1), (rsmd.getColumnName(1).length() + 12)) + " | " + Space(resultSet.getString(2), rsmd.getColumnName(2).length() + 12) + Space(resultSet.getString(3), rsmd.getColumnName(3).length() + 20) + " | " + Space(resultSet.getString(4), rsmd.getColumnName(4).length() + 12) + "|");
        }
    }
    public void DataBaseOutputAllInfo() throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery("select * from Planes");
        System.out.println("Output");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        StringBuilder text = new StringBuilder();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            text.append(Space(rsmd.getColumnName(i), rsmd.getColumnName(i).length() + 6)).append(" | ");
        }
        System.out.println(text);
        while (resultSet.next()) {
            text = new StringBuilder();
            String temp;
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                int textSize = rsmd.getColumnName(i).length() + 6;
                if(resultSet.getString(i) == null){
                    temp = Space("", textSize);
                }else {
                    temp = Space(resultSet.getString(i), textSize);
                }
                text.append(Space(temp, textSize)).append(" | ");
            }
            System.out.println(text);
        }
    }
    public void SortedDataBaseOutput() throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        stat = conn.createStatement();
        System.out.print("Print plane park sorted by ...\n 1.Brand \n 2. Max speed\n 3. MAX Range\n 4. Seats\n 4. Fuel consumption \n" );
        int choice = input.nextInt();
        ResultSet resultSet = stat.executeQuery("select " + "*" + " from Planes");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int m = 0;
        switch (choice) {
            case (1): {
                resultSet = stat.executeQuery("select * from Planes order by brand DESC");
                break;
            }
            case (2) : {
                resultSet = stat.executeQuery("select " + "*" + " from Planes order by max_speed DESC");
                m = 11;
                break;
            }
            case (3): {
                resultSet = stat.executeQuery("select " + "*" + " from Planes order by max_range DESC");
                m = 8;
                break;
            }
            case (4): {
                resultSet = stat.executeQuery("select " + "*" + " from Planes order by seats DESC");
                m =7;
                break;
            }
            case (5): {
                resultSet = stat.executeQuery("select " + "*" + " from Planes order by fuel_consumption DESC");
                m = 6;
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        };
        System.out.println(Space(rsmd.getColumnName(1), (rsmd.getColumnName(1).length() + 20)) + " | " + Space(rsmd.getColumnName(2), rsmd.getColumnName(2).length() + 20) + Space(rsmd.getColumnName(3), rsmd.getColumnName(3).length() + 20) + " | " + Space(rsmd.getColumnName(4), rsmd.getColumnName(4).length() + 20) + "|" +  Space(rsmd.getColumnName(m) + "↓", rsmd.getColumnName(m).length() + 20)+ "|");
        while (resultSet.next()){
            System.out.println(Space(resultSet.getString(1), (rsmd.getColumnName(1).length() + 20)) + " | " + Space(resultSet.getString(2), rsmd.getColumnName(2).length() + 20) + Space(resultSet.getString(3), rsmd.getColumnName(3).length() + 20) + " | " + Space(resultSet.getString(4), rsmd.getColumnName(4).length() + 20) + "|" + Space(resultSet.getString(m), rsmd.getColumnName(m).length() + 20) + "|");
        }
    }
    public void PlaneWithFuelCons() throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery("select " + "*" + " from Planes");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        System.out.println("\nEnter minimal acceptable fuel consumption ...");
        double min_ = input.nextInt();
        System.out.println("\nEnter maximum acceptable fuel consumption ...");
        double max_ = input.nextInt();
        System.out.println(Space(rsmd.getColumnName(1), (rsmd.getColumnName(1).length() + 6)) + " | " + Space(rsmd.getColumnName(2), rsmd.getColumnName(2).length() + 6) + Space(rsmd.getColumnName(3), rsmd.getColumnName(3).length() + 6) + " | " + Space(rsmd.getColumnName(4), rsmd.getColumnName(4).length() + 6) + "|" +  Space(rsmd.getColumnName(6) + "↓", rsmd.getColumnName(6).length() + 6)+ "|");
        while (resultSet.next()) {
            if(resultSet.getDouble(6) >= min_ && resultSet.getDouble(6) <= max_) {
                System.out.println(Space(resultSet.getString(1), (rsmd.getColumnName(1).length() + 6)) + " | " + Space(resultSet.getString(2), rsmd.getColumnName(2).length() + 6) + Space(resultSet.getString(3), rsmd.getColumnName(3).length() + 6) + " | " + Space(resultSet.getString(4), rsmd.getColumnName(4).length() + 6) + "|" + Space(resultSet.getString(6), rsmd.getColumnName(6).length() + 6) + "|");
            }
        }
    }
    public void AddPlaneToPark() throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        stat = conn.createStatement();
        System.out.print("Chose type of the plane:\n 1. Passenger \n 2. Cargo\n 3. Fighter\n ");
        int type = input.nextInt();
        Plane plane;
        String sql;
        switch (type){
            case 1:
                plane = new Passenger();
                sql = "insert into Planes(brand, model, max_range, fuel_consumption, length_, ENG_power, max_payload,max_speed,type_, seats ) " +
                        " values( " + plane.SQL_SPEC() + ")";
                //System.out.println(sql);
                stat.executeUpdate(sql);
                return;
            case 2:
                plane = new Cargo();
                sql = "insert into Planes(brand, model, max_range, fuel_consumption, length_, ENG_power, max_payload,max_speed,type_)" +
                        " values( " + plane.SQL_SPEC() + ")";
               // System.out.println(sql);
                stat.executeUpdate(sql);
                return;
            case 3:
                plane = new Fighter();
                sql = "insert into Planes(brand, model, max_range, fuel_consumption, length_, ENG_power, max_payload,max_speed,type_ )" +
                        " values( " + plane.SQL_SPEC() + ")";
                //System.out.println(sql);
                stat.executeUpdate(sql);
                return;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    public void DeletePlane() throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        stat = conn.createStatement();
        this.DataBaseOutputAllInfo();
        int rowNumber;
        rowNumber = input.nextInt();
        stat.executeUpdate("delete from Planes where id = " + rowNumber + ";");
    }

    public static String Space(String text, int l){
        StringBuilder s = new StringBuilder();
        for(int i = 1; i <= l-text.length(); i++){
            if( i == (l-text.length())/2+1){
                s.append(text);
            }else{
                s.append(" ");
            }
        }
        return s.toString();
    }

    public  void menu() throws SQLException {
        String command;
        System.out.println("Menu options:\n /add \n /delete_id\n /show \n /showall \n /exit \n /find_by_fuel\n /sorted");
        command = input.nextLine();
        while(!command.equals("/exit")) {
            switch (command) {
                case ("/help"):
                    System.out.println("Menu options:\n /add \n /delete_id\n /show \n /showall \n /exit \n /find_by_fuel\n /sorted");
                    break;
                case ("/show"):
                    DataBaseOutput();
                    break;
                case ("/add"):
                    AddPlaneToPark();
                    break;
                case ("/delete_id"):
                    DeletePlane();
                    break;
                case ("/showall"):
                    DataBaseOutputAllInfo();
                    break;
                case ("/find_by_fuel"):
                    PlaneWithFuelCons();
                    break;
                case ("/sorted"):
                    SortedDataBaseOutput();
                    break;
                default:
                    System.out.println("Re-enter command");

            }
            command = input.nextLine();
        }
    }
}