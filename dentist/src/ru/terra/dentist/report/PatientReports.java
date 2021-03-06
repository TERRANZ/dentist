package ru.terra.dentist.report;

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
public class PatientReports extends Report
{
    public void allPatientsReport()
    {
	try
	{
	    JasperReport jasperReport = JasperCompileManager.compileReport("reports/allPatients.jrxml");
	    Map parameters = new HashMap();
	    parameters.put("REPORT_CONNECTION", conn);
	    JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
	    JasperViewer.viewReport(print, false);
	} catch (JRException ex)
	{
	    Logger.getLogger(PatientReports.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
