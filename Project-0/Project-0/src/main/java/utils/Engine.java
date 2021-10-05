package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Engine
{  public static void main (String[] args) {
    try
    {
        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT * FROM  savings_accounts sa   ";
        PreparedStatement prepareStmt = conn.prepareStatement(sql);
        ResultSet rs =prepareStmt.executeQuery();

        while(rs.next())
        {
            System.out.println(rs.getDouble("balance"));
        }

    } catch (SQLException | IOException e) {
        e.printStackTrace();
    }
}

}
