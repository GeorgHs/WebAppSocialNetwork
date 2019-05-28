package controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.*;

@WebListener
public class DatabaseController implements ServletContextListener {

    private static Connection con;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // This function runs on server startup. Connect to database here
        try {
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            String dbURL = Env.dburl;
            // Database name to access
            String dbName = "social_network?serverTimezone=UTC";
            String dbUsername = Env.dbuser;
            String dbPassword = Env.dbpass;

            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbURL + dbName,
                    dbUsername,
                    dbPassword);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();

        }
    }

    /**
     * Execute SQL Query
     *
     * @param sql command to run
     */
    public static ResultSet executeQuery(String sql) {
        try {
            PreparedStatement st = con.prepareStatement(sql);
            return st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Execute SQL Command which modifies data
     *
     * @param sql command to run
     * @return String Key of created row
     */
    public static int executeUpdate(String sql) {
        int lastInsertId = -1;
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
            ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                lastInsertId = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastInsertId;
    }
}
