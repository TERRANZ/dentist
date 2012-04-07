package ru.terra.dentist.report;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author terranz
 */
public class AppointmentsReport extends Report
{
    public void allAppointmentsReport()
    {
	try
	{
	    JasperReport jasperReport = JasperCompileManager.compileReport("reports/allApp.jrxml");
	    Map parameters = new HashMap();
	    parameters.put("REPORT_CONNECTION", conn);
	    JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
	    JasperViewer.viewReport(print, false);
	} catch (JRException ex)
	{
	    Logger.getLogger(PatientReports.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void appsForPatient(Integer patId)
    {
	try
	{
	    JasperReport jasperReport = JasperCompileManager.compileReport("reports/appsForPatient.jrxml");
	    Map parameters = new HashMap();
	    parameters.put("REPORT_CONNECTION", conn);
	    parameters.put("patId", patId);
	    JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
	    JasperViewer.viewReport(print, false);
	} catch (JRException ex)
	{
	    Logger.getLogger(PatientReports.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void appsForDate(Date d)
    {
	try
	{
	    JasperReport jasperReport = JasperCompileManager.compileReport("reports/appsForDate.jrxml");
	    Map parameters = new HashMap();
	    parameters.put("REPORT_CONNECTION", conn);
	    parameters.put("date", d);
	    JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
	    JasperViewer.viewReport(print, false);
	} catch (JRException ex)
	{
	    Logger.getLogger(PatientReports.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
