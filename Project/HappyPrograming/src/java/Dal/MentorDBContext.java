/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Entity.Mentor;
import Entity.Skill;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class MentorDBContext extends DBContext<Mentor> {

    public void insertCvMentor1(String id, String ava, String job, String intro, String achivement, String userid) throws SQLException {
        String query = "INSERT INTO [dbo].[Mentor] VALUES (?,?,?,?,?,?)";
        try (java.sql.Connection conn = connection; PreparedStatement stm = conn.prepareStatement(query)) {

            stm.setString(1, id);
            stm.setString(2, ava);
            stm.setString(3, job);
            stm.setString(4, intro);
            stm.setString(5, achivement);
            stm.setString(6, userid);
            stm.executeUpdate();
        }
    }

    public void insertCvMentor(String ava, String job, String intro, String achivement, String userid) throws SQLException {  
        String id = getLatestMentorId();
        String query = "INSERT INTO [dbo].[Mentor] VALUES (?,?,?,?,?,?)";
        try (java.sql.Connection conn = connection; PreparedStatement stm = conn.prepareStatement(query)) {
            stm.setString(1, id);
            stm.setString(2, ava);
            stm.setString(3, job);
            stm.setString(4, intro);
            stm.setString(5, achivement);
            stm.setString(6, userid);
            stm.executeUpdate();
        }
    }

    public String getLatestMentorId() throws SQLException {
        int latestId = 0; // Giả sử không có Mentor nào, ID bắt đầu từ 1
        String query = "SELECT ID FROM [dbo].[Mentor] ORDER BY id DESC"; // Giả sử bạn có cột MentorID là khoá chính auto-increment
        try (java.sql.Connection conn = connection; PreparedStatement stm = conn.prepareStatement(query)) {
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("ID");
                latestId = Integer.parseInt(id.replace("Mentor", "").trim());
            }
        }
        int newIdNumber = latestId + 1;
        String id = "Mentor" + newIdNumber;
        return id;
    }

    public static void main(String[] args) throws SQLException {
        MentorDBContext db = new MentorDBContext();
        db.insertCvMentor1("11","đă", "đắ", "ădawdw", "ădawda", "user1");
    }
}
