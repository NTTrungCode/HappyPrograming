
package Dal;

import Entity.MentorSkill;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MentorSkillDBContext extends DBContext<MentorSkill>{
     public void insertSkillToMentorSkill(String skillId,int id) throws SQLException {
        String query = "INSERT INTO MentorSkill VALUES(?, ?)";
        try ( PreparedStatement stm = connection.prepareStatement(query)) {
            stm.setString(2, skillId.trim());
            stm.setInt(1, id);          
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } 
    }
  public MentorSkill getMentorSkillById(String id){
      //String query = ""
      
         return null;   
  }   

    public static void main(String[] args) throws SQLException {
        MentorSkillDBContext db = new MentorSkillDBContext();
        try {
            db.insertSkillToMentorSkill("S04", 1);
            db.insertSkillToMentorSkill("S03", 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }   
}
    
