package database.DAO;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import database.backend.DatabaseConnection;
import database.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public static User authenticate(String username, String password) {
        User user = new User();
        try {
//        String query = "SELECT * FROM Authenticate.T_User Inner join Authenticate.T_User_Info on Authenticate.T_User.userID = Authenticate.T_User_Info.userID where username=? and password=?";

        Connection conn = DatabaseConnection.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * " +
                    "FROM T_User " +
                    "INNER JOIN T_User_Info " +
                    "ON T_User.userID = T_User_Info.userID " +
                    "WHERE username=? and password=? ");

            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet resultSet = ps.executeQuery();

            if (((ResultSetImpl) resultSet).getRows().size() != 0) {
                while (resultSet.next()) {
                    user.setUserID(resultSet.getInt("userID"));
                    user.setFirstName(resultSet.getString("username"));
                    user.setLastName(resultSet.getString("lastName"));
                    user.setEmail(resultSet.getString("email"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setPhoneNumber(resultSet.getInt("phoneNumber"));

                }

            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return user;
    }
}
