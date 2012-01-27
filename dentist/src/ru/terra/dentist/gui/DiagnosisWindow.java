/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DiagnosisWindow.java
 *
 * Created on 27.01.2012, 9:21:24
 */
package ru.terra.dentist.gui;

import java.awt.Dialog;
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
import ru.terra.dentist.gui.dialogs.NewDiagDialog;
import ru.terra.dentist.gui.dialogs.NewPatientDialog;
import ru.terra.dentist.orm.DiagnosisManager;
import ru.terra.dentist.orm.dto.DiagnosisDTO;
import ru.terra.dentist.orm.entity.Diagnosis;

/**
 *
 * @author terranz
 */
public class DiagnosisWindow extends javax.swing.JFrame implements Reloadable
{
    private static DiagnosisManager dm = new DiagnosisManager();

    /** Creates new form DiagnosisWindow */
    public DiagnosisWindow()
    {
        initComponents();
        loadDiagnosis();
    }

    private void loadDiagnosis()
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
                tableHeaders.add("Наименование");
                tableHeaders.add("Код");
                tableHeaders.add("Цена");

                for (Object o : dm.findAll(Diagnosis.class))
                {
                    Vector<Object> oneRow = new Vector<Object>();
                    oneRow.add(((Diagnosis) o).getDiagId());
                    oneRow.add(((Diagnosis) o).getDiagName());
                    oneRow.add(((Diagnosis) o).getDiagCode());
                    oneRow.add(((Diagnosis) o).getDiagPrice());
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
    
    private class NewDiagOkActionListener implements ActionListener
    {
        private NewDiagDialog ndd;
        private Reloadable r;

        public NewDiagOkActionListener(NewDiagDialog ndd, Reloadable r)
        {
            this.ndd = ndd;
            this.r = r;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                dm.update(ndd.getResult());
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            } finally
            {
                ndd.setVisible(false);
                ndd.dispose();
                r.reload();
            }
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
        tblPatients = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mrPatients = new javax.swing.JMenu();
        miAdd = new javax.swing.JMenuItem();
        miEdit = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miDelete = new javax.swing.JMenuItem();
        mrReports = new javax.swing.JMenu();
        miPrintAll = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane1.setViewportView(tblPatients);

        mrPatients.setText("Диагноз");

        miAdd.setText("Добавить");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        mrPatients.add(miAdd);

        miEdit.setText("Редактировать");
        miEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditActionPerformed(evt);
            }
        });
        mrPatients.add(miEdit);
        mrPatients.add(jSeparator1);

        miDelete.setText("Удалить");
        miDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteActionPerformed(evt);
            }
        });
        mrPatients.add(miDelete);

        jMenuBar1.add(mrPatients);

        mrReports.setText("Отчёты");

        miPrintAll.setText("Распечатать список");
        mrReports.add(miPrintAll);

        jMenuBar1.add(mrReports);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miAddActionPerformed
    {//GEN-HEADEREND:event_miAddActionPerformed

        NewDiagDialog ndd = new NewDiagDialog(this, true);
        ndd.getOkButton().addActionListener(new NewDiagOkActionListener(ndd, this));
        ndd.setVisible(true);
    }//GEN-LAST:event_miAddActionPerformed

    private void miEditActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miEditActionPerformed
    {//GEN-HEADEREND:event_miEditActionPerformed

        NewDiagDialog ndd = new NewDiagDialog(this, true);
        ndd.getOkButton().addActionListener(new NewDiagOkActionListener(ndd, this));
        Diagnosis d = new Diagnosis();
        Integer row = tblPatients.getSelectedRow();
        d.setDiagId((Integer) tblPatients.getModel().getValueAt(row, 0));
        d.setDiagName((String) tblPatients.getModel().getValueAt(row, 1));
        d.setDiagCode((String) tblPatients.getModel().getValueAt(row, 2));
        d.setDiagPrice((Integer) tblPatients.getModel().getValueAt(row, 3));        
        ndd.setDiagnosis(d);
        ndd.setVisible(true);
    }//GEN-LAST:event_miEditActionPerformed

    private void miDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_miDeleteActionPerformed
    {//GEN-HEADEREND:event_miDeleteActionPerformed

        Integer row = tblPatients.getSelectedRow();
        Diagnosis d = (Diagnosis) dm.findById((Integer) tblPatients.getModel().getValueAt(row, 0));
        if (d != null)
        {
            dm.delete(d);
        }
        loadDiagnosis();
    }//GEN-LAST:event_miDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(DiagnosisWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(DiagnosisWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(DiagnosisWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(DiagnosisWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new DiagnosisWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miDelete;
    private javax.swing.JMenuItem miEdit;
    private javax.swing.JMenuItem miPrintAll;
    private javax.swing.JMenu mrPatients;
    private javax.swing.JMenu mrReports;
    private javax.swing.JTable tblPatients;
    // End of variables declaration//GEN-END:variables

    @Override
    public void reload()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
