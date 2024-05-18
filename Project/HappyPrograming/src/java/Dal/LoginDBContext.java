package Dal;

import Entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data Access Object for Login functionality.
 */
public class LoginDBContext extends DBContext<Account> {

    /**
     * Checks login credentials against the database.
     *
     * @param user     the username
     * @param password the password
     * @return an Account object if credentials are valid, otherwise null
     * @throws SQLException if a database access error occurs
     */
    public Account checkLogin(String user, String password) throws SQLException {
        String sql = "SELECT [user], [pass], [id], [role] FROM [Account] WHERE [user] = ? AND [pass] =  ?";
        
        try (Connection conn = connection;
             PreparedStatement stm = conn.prepareStatement(sql)) {
             
            stm.setString(1, user);
            stm.setString(2, password);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Account acc = new Account();
                    acc.setUser(rs.getString("user"));
                    acc.setPass(rs.getString("pass"));
                    acc.setId(rs.getString("id"));
                    acc.setRole(rs.getString("role"));
                    return acc;
                }
            }
        }
        return null;
    }
}
