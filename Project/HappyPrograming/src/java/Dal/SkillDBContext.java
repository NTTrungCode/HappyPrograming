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
                s.setId(rs.getString("id").trim());
                s.setName(rs.getString("name"));
                s.setStatus(rs.getInt("status"));
                list.add(s);
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching skills from the database", e);
        }

        return list;
    }

    /**
     *
     * @param id
     * @param name
     * @param status
     * @throws SQLException
     */
    public void createSkill(String id, String name, int status) throws SQLException {
        String sql = "INSERT INTO [dbo].[Skill] VALUES (?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, id);
        stm.setString(2, name);
        stm.setInt(3, status);
        stm.executeUpdate();
    }
    
    /**
     *
     * @param id
     * @param name
     * @param status
     * @throws SQLException
     */
    public void updateSkill(String id, String name, int status) throws SQLException {
        String sql = "UPDATE [dbo].[Skill] SET [name] = ?,[status] = ? WHERE id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(3, id);
        stm.setString(1, name);
        stm.setInt(2, status);
        stm.executeUpdate();
    }
    
    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Skill getSkillById(String id) throws SQLException {
        String sql = "SELECT [id], [name], [status] FROM [dbo].[Skill] WHERE [id] = ?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int status = rs.getInt("status");
                return new Skill(id, name, status);
            } else {
                throw new SQLException("Skill not found with ID: " + id);
            }
        }
    }

    /**
     *
     * @param id
     * @throws SQLException
     */
    public void deleteSkill(String id) throws SQLException {
        String sql = "DELETE FROM [dbo].[Skill] WHERE id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, id);
        stm.executeUpdate();
    }
}