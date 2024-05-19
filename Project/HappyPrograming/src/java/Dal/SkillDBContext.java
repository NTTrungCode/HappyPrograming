package Dal;

import Entity.Skill;
import java.sql.*;
import java.util.ArrayList;

/**
 * Data access class for Skill entities.
 */
public class SkillDBContext extends DBContext<Skill> {

    /**
     * Retrieves a list of all skills from the database.
     *
     * @return a list of Skill objects
     * @throws SQLException if a database access error occurs
     */
    public ArrayList<Skill> list() throws SQLException {
        ArrayList<Skill> list = new ArrayList<>();
        String sql = "SELECT id, [name], [status] FROM Skill";

        try (PreparedStatement stm = connection.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Skill s = new Skill();
                s.setId(rs.getString("id"));
                s.setName(rs.getString("name"));
                s.setStatus(rs.getInt("status"));
                list.add(s);
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching skills from the database", e);
        }

        return list;
    }
}
