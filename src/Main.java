import Aviacompany.CompanyDataBase;

import java.sql.SQLException;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
public  static  void main(String[] args) throws SQLException, ClassNotFoundException {
    CompanyDataBase Qantas = new CompanyDataBase();
//    Plane plane = new Passenger(3575,320,20.3,25.5,39.5,25,"737 MAX8","Boeing",189);
//    System.out.println(plane.SQL_SPEC());
    Qantas.menu();
}
}