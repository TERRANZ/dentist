package ru.terra.dentist.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import ru.terra.dentist.gui.dialogs.NewAppDialog;
import ru.terra.dentist.orm.AppointmentsManager;
import ru.terra.dentist.orm.entity.Appointment;

/**
 *
 * @author terranz
 */
public class AppointmentsWindow extends javax.swing.JFrame implements Reloadable
{
    /** Creates new form ApointmentsWindow */
    public AppointmentsWindow()
    {
        initComponents();
        loadApp();
        this.setLocationRelativeTo(null);
    }
    AppointmentsManager am = new AppointmentsManager();

    private class NewAppDialogOkListener implements ActionListener
    {
        private NewAppDialog nad;
        private Reloadable r;

        public NewAppDialogOkListener(NewAppDialog nad, Reloadable r)
        {
            this.nad = nad;
            this.r = r;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                am.insert(nad.getResult());
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            } finally
            {
                nad.setVisible(false);
                nad.dispose();
                r.reload();
            }
        }
    }

    private void loadApp()
    {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Callable<DefaultTableModel> loader = new Callable<DefaultTableModel>()
        {
            @Override
            public DefaultTableModel call() throws Exception
            {
                Vector<String> tableHeaders = new Vector<String>();
                Vector tableData = new Vector();
                tableHeaders.add("Идент");
                tableHeaders.add("Пациент");
                tableHeaders.add("Диагноз");
                tableHeaders.add("Дата приёма");

                for (Object o : am.findAll(Appointment.class))
                {
                    Vector<Object> oneRow = new Vector<Object>();
                    oneRow.add(((Appointment) o).getId().getAppId());
                    oneRow.add(((Appointment) o).getPatient().getPatName());
                    oneRow.add(((Appointment) o).getDiagnosis().getDiagName());
                    oneRow.add(((Appointment) o).getAppDate());
                    tableData.add(oneRow);
                }
                return new DefaultTableModel(tableData, tableHeaders);
            }
        };
        Future<DefaultTableModel> future = pool.submit(loader);
        try
        {
            tblApps.setModel(future.get());
        } catch (InterruptedException ex)
        {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex)
        {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblApps = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mrApp = new javax.swing.JMenu();
        miNew = new javax.swing.JMenuItem();
        miEdit = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miDelete = new javax.swing.JMenuItem();
        mrReports = new javax.swing.JMenu();
        miPrintList = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Приёмы");

        tblApps.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblApps);

        mrApp.setText("Приёмы");

        miNew.setText("Новый");
        miNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewActionPerformed(evt);
            }
        });
        mrApp.add(miNew);

        miEdit.setText("Изменить");
        miEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditActionPerformed(evt);
            }
        });
        mrApp.add(miEdit);
        mrApp.add(jSeparator1);

        miDelete.setText("Удалить");
        mrApp.add(miDelete);

        jMenuBar1.add(mrApp);

        mrReports.setText("Отчёты");

        miPrintList.setText("Список");
        mrReports.add(miPrintList);

        jMenuBar1.add(mrReports);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNewActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miNewActionPerformed
    {//GEN-HEADEREND:event_miNewActionPerformed
        NewAppDialog nad = new NewAppDialog(this, true);
        nad.getOkButton().addActionListener(new NewAppDialogOkListener(nad, this));
        nad.setVisible(true);
    }//GEN-LAST:event_miNewActionPerformed

    private void miEditActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miEditActionPerformed
    {//GEN-HEADEREND:event_miEditActionPerformed
        NewAppDialog nad = new NewAppDialog(this, true);
        nad.getOkButton().addActionListener(new NewAppDialogOkListener(nad, this));
        Appointment a = new Appointment();
        Integer row = tblApps.getSelectedRow();
        if (row != -1)
        {
        }
        nad.setApp(a);
        nad.setVisible(true);
    }//GEN-LAST:event_miEditActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(AppointmentsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AppointmentsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AppointmentsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AppointmentsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new AppointmentsWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem miDelete;
    private javax.swing.JMenuItem miEdit;
    private javax.swing.JMenuItem miNew;
    private javax.swing.JMenuItem miPrintList;
    private javax.swing.JMenu mrApp;
    private javax.swing.JMenu mrReports;
    private javax.swing.JTable tblApps;
    // End of variables declaration//GEN-END:variables

    @Override
    public void reload()
    {
        loadApp();
    }
}
