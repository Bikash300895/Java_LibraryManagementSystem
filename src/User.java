
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class User {
    String username;
    String name;
    String password;
    String securityQuestion;
    String answer;
    
    public static User getUserInfo(String username){
        // Get the connection
        Connection conn = JavaConnect.ConnectDb();
        ResultSet rs;
        PreparedStatement pst;
        
        String sql = "select * from account where Username='"+username+"'";
        User user = new User();
        
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                user.username = rs.getString(1);
                user.name = rs.getString(2);
                user.password = rs.getString(3);
                user.securityQuestion = rs.getString(4);
                user.answer = rs.getString(5);

                rs.close();
                pst.close();
                
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Username");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        return user;
    }
}
