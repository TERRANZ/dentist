package ru.terra.dentist.report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author terranz
 */
public abstract class Report
{
    protected Connection conn;

    public Report()
    {
	try
	{
	    String driverName = "com.mysql.jdbc.Driver";
	    Class.forName(driverName);
	    String serverName = "127.0.0.1";
	    String mydatabase = "dentist";
	    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
	    String username = "scan";
	    String password = "scan";
	    conn = DriverManager.getConnection(url, username, password);
	} catch (SQLException ex)
	{
	    Logger.getLogger(PatientReports.class.getName()).log(Level.SEVERE, null, ex);
	} catch (ClassNotFoundException ex)
	{
	    Logger.getLogger(PatientReports.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
