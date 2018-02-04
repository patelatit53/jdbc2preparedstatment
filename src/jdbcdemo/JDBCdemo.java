package jdbcdemo;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {

    public static void main(String[] args) {
        int c1 = 0 ;
        int c2 = 0;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/myd123", "root", "root");
            System.out.println("connection established");
            PreparedStatement stmt = conn.prepareStatement("insert into T1 values (? , ?)");
            
            int input[][] = new int[10][2];
            
            for(int i=0 ; i < input.length ; i++)
            {
                input[i][0] = i*10+i;
                input[i][1] = i*20+i;
            }
            
            for(int temp[] : input)
            {
                c1 = temp[0];
                stmt.setInt(1, c1);
                c2 = temp[1];
                stmt.setInt(2, c2);
                
                stmt.execute();
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException cnf) {
            System.out.println("Class not found");
        }
    }
}

