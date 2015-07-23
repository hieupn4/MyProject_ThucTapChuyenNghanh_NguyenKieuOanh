/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TienIch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoang Dong Tien
 */
public class EmpConnection {

    public void chen(String x1,String x2,String x3,int x4,int x5,int x6,int x7,int x8) throws SQLException, ClassNotFoundException
    {
       
        String sql="use QLNS_JAVA2 INSERT INTO Employees(EmployeeName,Username,Password,IsSystemAdmin,RoleID,ProjectID,DepartmentID,LocationID) VALUES('"+x1+"','"+x2+"','"+x3+"',"+x4+","+x5+","+x6+","+x7+","+x8+")";
        Connection conn = EmpConnection.getConnection();
        Statement sttm = conn.createStatement();
        // String sql="use EmployeeTransferManagement2010 INSERT INTO Employees(EmployeeName,Username,Password,IsSystemAdmin,RoleID,ProjectID,DepartmentID,LocationID) VALUES('oooooo','iiii','123',1,1,2,1,1)";
        System.out.println(sql);
        sttm.execute(sql);
        
    }
    private static String readConnectionString() {
        String str = "";
        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader("connection.data"));
            String server = reader.readLine();
            String port = reader.readLine();
            String user = reader.readLine();
              reader.close();

            StringBuilder connStr = new StringBuilder();
            connStr.append("jdbc:sqlserver://");
            connStr.append(server);
            connStr.append(":");
            connStr.append(port);
            connStr.append(";databaseName=QLNS_JAVA2;user=sa");
           
            connStr.append(";password=123456");
           
            str = connStr.toString();
        } catch (IOException ex) {
            Logger.getLogger(EmpConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return str;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection oConn = null;
       try {  
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            oConn = DriverManager.getConnection("jdbc:odbc:driver={sql server};server=ACER-PC\\SQLEXPRESS;databaseName=QLNS_JAVA2;");
            System.out.println("thanh cong");
       } catch (ClassNotFoundException ex) {
           System.out.println("that bai");
           
       }
       return oConn;
    }

    public static void closeConnection(Connection oConn) throws SQLException {
        if (oConn != null) {
            oConn.close();
        }
    }

    public static boolean testConnection() {
        Connection oConn = null;
        try {
            oConn = EmpConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EmpConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (oConn != null) {
            try {
                EmpConnection.closeConnection(oConn);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(EmpConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    public static void closeCallableStatement(CallableStatement callableStatement) throws SQLException {
        if (callableStatement != null) {
            callableStatement.close();
        }
    }

    public static void main(String[] args) {
//        try {
//            Connection oConn = getConnection();
//            if(oConn != null)
//            {
//                System.out.println("Connected");
//            }
//            closeConnection(oConn);
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        } catch (ClassNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
        System.out.println(readConnectionString());
        System.out.println(testConnection());
    }
}
