package hospital.managment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection connection;

    Statement statement;

    public conn(){
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_mangment_system","root","W7301@jqir#");   //the local host number will be default 3306
            statement=connection.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
