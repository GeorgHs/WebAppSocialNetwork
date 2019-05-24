package controller;

import org.apache.catalina.connector.Response;

import javax.script.ScriptContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

@WebListener
public class DatabaseController implements ServletContextListener {

    private static Connection con;
    private Response response;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // This function runs on server startup. Connect to database here
        try {
            String dbDriver = "com.mysql.jdbc.Driver";
            String dbURL = "jdbc:mysql://wsn.hburger.space:3306/";
            // Database name to access
            String dbName = "social_network?serverTimezone=UTC";
            String dbUsername = "root";
            String dbPassword = "webengineering";


            Class driver = com.mysql.jdbc.Driver.class;
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
     * Execute SQL Command
     *
     * @param sql command to run
     */
    public static ResultSet executeSQL(String sql) {
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet resultSet = st.executeQuery();
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
