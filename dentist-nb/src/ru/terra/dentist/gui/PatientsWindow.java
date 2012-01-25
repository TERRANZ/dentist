/*
 * PatientsWindow.java
 *
 * Created on 01.01.2012, 11:41:09
 */
package ru.terra.dentist.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import ru.terra.dentist.dto.Patient;
import ru.terra.dentist.gui.dialogs.NewPatientDialog;
import ru.terraobjects.entity.dao.TOObjectsHelper;

/**
 *
 * @author terranz
 */
public class PatientsWindow extends javax.swing.JFrame implements Reloadable
{

    public void reload()
    {
        loadPatients();
    }

    private class NewPatientOkActionListener implements ActionListener
    {

        private NewPatientDialog npd;
        private Connection conn;
        private Reloadable r;

        public NewPatientOkActionListener(NewPatientDialog npd, Connection conn, Reloadable r)
        {
            this.npd = npd;
            this.conn = conn;
            this.r = r;
        }

        public void actionPerformed(ActionEvent e)
        {
            TOObjectsHelper helper = new TOObjectsHelper(conn);
            try
            {
                helper.storeObject(npd.getResult(), true);
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            } finally
            {
                npd.setVisible(false);
                npd.dispose();
                r.reload();
            }
        }
    }
    private Connection conn;

    /** Creates new form PatientsWindow */
    public PatientsWindow()
    {
        initComponents();
    }

    public PatientsWindow(Connection conn)
    {
        this.conn = conn;
        initComponents();
        loadPatients();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mrEdit = new javax.swing.JMenu();
        miAddNewPatient = new javax.swing.JMenuItem();
        miEditPatient = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Пациенты");
        setLocationByPlatform(true);

        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPatients.setName("tblPatients"); // NOI18N
        jScrollPane1.setViewportView(tblPatients);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        mrEdit.setText("Редактирование");
        mrEdit.setName("mrEdit"); // NOI18N

        miAddNewPatient.setText("Добавить пациента");
        miAddNewPatient.setName("miAddNewPatient"); // NOI18N
        miAddNewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddNewPatientActionPerformed(evt);
            }
        });
        mrEdit.add(miAddNewPatient);

        miEditPatient.setText("Редактировать пациента");
        miEditPatient.setName("miEditPatient"); // NOI18N
        miEditPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditPatientActionPerformed(evt);
            }
        });
        mrEdit.add(miEditPatient);

        jMenuBar1.add(mrEdit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddNewPatientActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miAddNewPatientActionPerformed
    {//GEN-HEADEREND:event_miAddNewPatientActionPerformed
        NewPatientDialog npd = new NewPatientDialog(this, true);
        npd.getOkButton().addActionListener(new NewPatientOkActionListener(npd, conn, this));
        npd.setVisible(true);
    }//GEN-LAST:event_miAddNewPatientActionPerformed

    private void miEditPatientActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miEditPatientActionPerformed
    {//GEN-HEADEREND:event_miEditPatientActionPerformed
        NewPatientDialog npd = new NewPatientDialog(this, true);
        npd.getOkButton().addActionListener(new NewPatientOkActionListener(npd, conn, this));        
        Patient dto = new Patient();
        Integer row = tblPatients.getSelectedRow();
        dto.setPatId((Integer) tblPatients.getModel().getValueAt(row, 0));
        dto.setPatName((String) tblPatients.getModel().getValueAt(row, 1));
        dto.setPatMName((String) tblPatients.getModel().getValueAt(row, 2));
        dto.setPatSName((String) tblPatients.getModel().getValueAt(row, 3));
        dto.setPatNum((Integer) tblPatients.getModel().getValueAt(row, 4));
        npd.setPatient(dto);
        npd.setVisible(true);
    }//GEN-LAST:event_miEditPatientActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {

            public void run()
            {
                new PatientsWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miAddNewPatient;
    private javax.swing.JMenuItem miEditPatient;
    private javax.swing.JMenu mrEdit;
    private javax.swing.JTable tblPatients;
    // End of variables declaration//GEN-END:variables

    private void loadPatients()
    {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Callable<DefaultTableModel> loader = new Callable<DefaultTableModel>()
        {

            TOObjectsHelper helper = new TOObjectsHelper(conn);

            public DefaultTableModel call() throws Exception
            {
                Vector<String> tableHeaders = new Vector<String>();
                Vector tableData = new Vector();
                tableHeaders.add("Идент");
                tableHeaders.add("Имя");
                tableHeaders.add("Отчество");
                tableHeaders.add("Фамилия");
                tableHeaders.add("Номер");

                for (Object o : helper.loadObjects(Patient.class))
                {
                    Patient patient = (Patient) o;
                    Vector<Object> oneRow = new Vector<Object>();
                    oneRow.add(patient.getPatId());
                    oneRow.add(patient.getPatName());
                    oneRow.add(patient.getPatMName());
                    oneRow.add(patient.getPatSName());
                    oneRow.add(patient.getPatNum());
                    tableData.add(oneRow);
                }
                return new DefaultTableModel(tableData, tableHeaders);
            }
        };
        Future<DefaultTableModel> future = pool.submit(loader);
        try
        {
            tblPatients.setModel(future.get());
        } catch (InterruptedException ex)
        {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex)
        {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
    }
}
