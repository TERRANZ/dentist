package ru.terra.dentist;

/**
 *
 * @author terranz
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.terra.dentist.gui.MainWindow;

public class StarterThread implements Runnable
{

    public void run()
    {
	try
	{
	    String driverName = "com.mysql.jdbc.Driver";

	    Class.forName(driverName);

	    // Create a connection to the database
	    String serverName = "127.0.0.1";
	    String mydatabase = "terraobjects";
	    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
	    String username = "scan";
	    String password = "scan";

	    Connection connection = DriverManager.getConnection(url, username, password);
	    if (connection != null)
	    {
		MainWindow mw = new MainWindow(connection);
		mw.setVisible(true);
	    } else
	    {
		System.out.println("Can't connect to db!");
	    }
	} catch (SQLException ex)
	{
	    Logger.getLogger(StarterThread.class.getName()).log(Level.SEVERE, null, ex);
	} catch (ClassNotFoundException ex)
	{
	    Logger.getLogger(StarterThread.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
