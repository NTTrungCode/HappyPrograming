/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Entity.MentorAccount;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.SQLException;
import java.util.List;

public class GetInforMentorDBContext extends DBContext<MentorAccount> {

    public MentorAccount getmentorById(int id) throws SQLException {
        String query = "SELECT mentor.id, mentor.ava,mentor.job, account.fullname, account.dob, mentor.intro , mentor.achivement\n"
                + "FROM account\n"
                + "JOIN mentor ON mentor.accId = account.id\n"
                + "WHERE mentor.id = ?";
        try (java.sql.Connection conn = connection; PreparedStatement stm = conn.prepareStatement(query)) {
            stm.setInt(1, id);
              try (ResultSet rs = stm.executeQuery()) {
            if (rs.next()) {
                return new MentorAccount(
                    rs.getInt("id"),           
                    rs.getString("ava"),  
                    rs.getString("job"),
                    rs.getString("fullname"),   
                    rs.getString("dob"),          
                    rs.getString("intro"),      
                    rs.getString("achivement"));
            }

        }
        return null;
        }   
        }
    public List<MentorAccount> getAllMentor() throws SQLException{
        ArrayList<MentorAccount> list = new ArrayList<>();
         String query = "SELECT mentor.id, mentor.ava,mentor.job, account.fullname, account.dob, mentor.intro , mentor.achivement\n"
                + "FROM account\n"
                + "JOIN mentor ON mentor.accId = account.id\n";
          try (PreparedStatement stm = connection.prepareStatement(query); ResultSet rs = stm.executeQuery()){
          while (rs.next()) {
                MentorAccount s = new MentorAccount();
                s.setId(rs.getInt("id"));
                s.setAva(rs.getString("ava"));
                s.setJob(rs.getString("job"));
                s.setFullName(rs.getString("fullName"));
                s.setDob(rs.getString("dob"));
                s.setIntro(rs.getString("intro"));
                s.setAchivement(rs.getString("achivement"));
                list.add(s);
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching skills from the database", e);
        }
        return list;
}

    public static void main(String[] args) throws SQLException {
        GetInforMentorDBContext db = new GetInforMentorDBContext();
        //MentorAccount x=  db.getmentorById(24);
        List<MentorAccount> x = db.getAllMentor();
        System.out.println(x.get(1).getId());
        
    }

}
