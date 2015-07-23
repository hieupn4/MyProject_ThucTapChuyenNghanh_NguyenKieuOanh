/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package etm2010;

import Giaodien.PnlAdminEmployeeManage;
import TienIch.EmpConnection;
import XyLyDuLieu.Employee;
import XyLyDuLieu.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang Dong Tien
 */
public class Main {

    public static LoginFrame frmLogin;//static vaiable to call later
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    frmLogin = new LoginFrame();
    frmLogin.setVisible(true);
  /*  String x1 ="oooooo";
    String x2 ="iiii";
    String x3 ="123";
    int x4 = 1;
    int x5 =1;
    int x6 = 2;
    int x7 = 1;
    int x8 = 1;
          
    EmpConnection emc = new EmpConnection();
    emc.chen(x1,x2,x3,x4,x5,x6,x7,x8); */
     
    } 
    

}
