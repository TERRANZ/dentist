package ru.terra.dentist.gui;

import ru.terra.dentist.report.AppointmentsReport;
import ru.terra.dentist.report.PatientReports;
import ru.terra.dentist.report.PatientsReport;


/**
 *
 * @author terranz
 */
public class MainWindow extends javax.swing.JFrame
{
    /** Creates new form MainWindow */
    public MainWindow()
    {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        mrPatients = new javax.swing.JMenu();
        miPatList = new javax.swing.JMenuItem();
        mrAppointments = new javax.swing.JMenu();
        miAppList = new javax.swing.JMenuItem();
        mrDIagnosis = new javax.swing.JMenu();
        miDiagList = new javax.swing.JMenuItem();
        mrReports = new javax.swing.JMenu();
        miParientsReport = new javax.swing.JMenuItem();
        miAllAppointmentsReport = new javax.swing.JMenuItem();

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dentist");

        mrPatients.setText("Пациенты");
        mrPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrPatientsActionPerformed(evt);
            }
        });

        miPatList.setText("Список");
        miPatList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPatListActionPerformed(evt);
            }
        });
        mrPatients.add(miPatList);

        jMenuBar1.add(mrPatients);

        mrAppointments.setText("Приёмы");

        miAppList.setText("Список");
        miAppList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAppListActionPerformed(evt);
            }
        });
        mrAppointments.add(miAppList);

        jMenuBar1.add(mrAppointments);

        mrDIagnosis.setText("Диагнозы");

        miDiagList.setText("Список");
        miDiagList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDiagListActionPerformed(evt);
            }
        });
        mrDIagnosis.add(miDiagList);

        jMenuBar1.add(mrDIagnosis);

        mrReports.setText("Отчёты");

        miParientsReport.setText("Отчёт по пациентам");
        miParientsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miParientsReportActionPerformed(evt);
            }
        });
        mrReports.add(miParientsReport);

        miAllAppointmentsReport.setText("Отчёт по приёмам");
        miAllAppointmentsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAllAppointmentsReportActionPerformed(evt);
            }
        });
        mrReports.add(miAllAppointmentsReport);

        jMenuBar1.add(mrReports);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mrPatientsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mrPatientsActionPerformed
    {//GEN-HEADEREND:event_mrPatientsActionPerformed
    }//GEN-LAST:event_mrPatientsActionPerformed
    
    private void miPatListActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miPatListActionPerformed
    {//GEN-HEADEREND:event_miPatListActionPerformed
        PatientsWindow pw = new PatientsWindow();
        pw.setVisible(true);
    }//GEN-LAST:event_miPatListActionPerformed
    
    private void miDiagListActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miDiagListActionPerformed
    {//GEN-HEADEREND:event_miDiagListActionPerformed
        DiagnosisWindow dw = new DiagnosisWindow();
        dw.setVisible(true);
    }//GEN-LAST:event_miDiagListActionPerformed
    
    private void miAppListActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miAppListActionPerformed
    {//GEN-HEADEREND:event_miAppListActionPerformed
        AppointmentsWindow aw = new AppointmentsWindow();
        aw.setVisible(true);
    }//GEN-LAST:event_miAppListActionPerformed

    private void miParientsReportActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miParientsReportActionPerformed
    {//GEN-HEADEREND:event_miParientsReportActionPerformed

	// TODO add your handling code here:
	PatientReports rep = new PatientReports();
	rep.allPatientsReport();
    }//GEN-LAST:event_miParientsReportActionPerformed

    private void miAllAppointmentsReportActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miAllAppointmentsReportActionPerformed
    {//GEN-HEADEREND:event_miAllAppointmentsReportActionPerformed
	// TODO add your handling code here:
	AppointmentsReport report = new AppointmentsReport();
	report.allAppointmentsReport();
    }//GEN-LAST:event_miAllAppointmentsReportActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem miAllAppointmentsReport;
    private javax.swing.JMenuItem miAppList;
    private javax.swing.JMenuItem miDiagList;
    private javax.swing.JMenuItem miParientsReport;
    private javax.swing.JMenuItem miPatList;
    private javax.swing.JMenu mrAppointments;
    private javax.swing.JMenu mrDIagnosis;
    private javax.swing.JMenu mrPatients;
    private javax.swing.JMenu mrReports;
    // End of variables declaration//GEN-END:variables
}
