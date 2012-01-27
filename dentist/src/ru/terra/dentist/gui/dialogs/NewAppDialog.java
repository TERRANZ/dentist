package ru.terra.dentist.gui.dialogs;

import javax.swing.JButton;
import ru.terra.dentist.gui.Reloadable;
import ru.terra.dentist.orm.AppointmentsManager;
import ru.terra.dentist.orm.PatientManager;
import ru.terra.dentist.orm.entity.Appointment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import ru.terra.dentist.orm.DiagnosisManager;
import ru.terra.dentist.orm.entity.AppointmentId;
import ru.terra.dentist.orm.entity.Comment;
import ru.terra.dentist.orm.entity.Diagnosis;
import ru.terra.dentist.orm.entity.Patient;

/**
 *
 * @author terranz
 */
public class NewAppDialog extends javax.swing.JDialog implements Reloadable
{
    private static DiagnosisManager dm = new DiagnosisManager();
    private static AppointmentsManager am = new AppointmentsManager();
    private static PatientManager pm = new PatientManager();

    /** Creates new form NewAppDialog */
    public NewAppDialog(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        loadDialog();
    }

    public void setApp(Appointment a)
    {
    }

    private void loadDialog()
    {
        List<Object> patients = pm.findAll(Patient.class);
        List<Object> diagnosises = dm.findAll(Diagnosis.class);
        cbPatient.removeAllItems();
        cbDiagnosis.removeAllItems();
        for (Object p : patients)
        {
            cbPatient.addItem((String) String.valueOf(((Patient) p).getPatId()) + " " + ((Patient) p).getPatSurname() + ((Patient) p).getPatName());
        }
        for (Object d : diagnosises)
        {
            cbDiagnosis.addItem(((Diagnosis) d).getDiagCode() + " " + ((Diagnosis) d).getDiagName());
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

    private class NewPatientOkActionListener implements ActionListener
    {
        private NewPatientDialog npd;
        private Reloadable r;

        public NewPatientOkActionListener(NewPatientDialog npd, Reloadable r)
        {
            this.npd = npd;
            this.r = r;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                pm.update(npd.getResult());
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbPatient = new javax.swing.JComboBox();
        cbDiagnosis = new javax.swing.JComboBox();
        brnNewPatient = new javax.swing.JButton();
        btnNewDiag = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taCommentText = new javax.swing.JTextArea();
        btnOK2 = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        dpDate = new com.michaelbaranov.microba.calendar.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Пациент");

        jLabel2.setText("Предполагаемый диагноз");

        jLabel3.setText("Дата назначения");

        cbPatient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbDiagnosis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        brnNewPatient.setText("Новый пациент");
        brnNewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnNewPatientActionPerformed(evt);
            }
        });

        btnNewDiag.setText("Новый диагноз");
        btnNewDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewDiagActionPerformed(evt);
            }
        });

        jLabel4.setText("Заметка");

        taCommentText.setColumns(20);
        taCommentText.setRows(5);
        jScrollPane1.setViewportView(taCommentText);

        btnOK2.setText("OK");

        btnCancel.setText("Отмена");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnPrint.setText("Распечатать");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbDiagnosis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dpDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnNewDiag)
                                            .addComponent(brnNewPatient))
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnOK2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancel))))
                            .addComponent(btnPrint))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(brnNewPatient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNewDiag)
                        .addGap(72, 72, 72)
                        .addComponent(btnPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnOK2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(dpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brnNewPatientActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_brnNewPatientActionPerformed
    {//GEN-HEADEREND:event_brnNewPatientActionPerformed
        NewPatientDialog npd = new NewPatientDialog(null, true);
        npd.getOkButton().addActionListener(new NewPatientOkActionListener(npd, this));
        npd.setVisible(true);
    }//GEN-LAST:event_brnNewPatientActionPerformed

    private void btnNewDiagActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnNewDiagActionPerformed
    {//GEN-HEADEREND:event_btnNewDiagActionPerformed
        NewDiagDialog ndd = new NewDiagDialog(null, true);
        ndd.getOkButton().addActionListener(new NewDiagOkActionListener(ndd, this));
        ndd.setVisible(true);
    }//GEN-LAST:event_btnNewDiagActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelActionPerformed
    {//GEN-HEADEREND:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(NewAppDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(NewAppDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(NewAppDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(NewAppDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                NewAppDialog dialog = new NewAppDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public Appointment getResult()
    {
        Appointment res = new Appointment();
        res.setAppDate(dpDate.getDate());
        Comment c = new Comment();
        c.setCommentDate(new Date());
        c.setCommentText(taCommentText.getText());
        am.update(c);
        res.setComment(c);
        String pn = (String) cbPatient.getSelectedItem();
        Patient p = (Patient) pm.findById(Integer.valueOf(pn.split(" ")[0]));
        if (p != null)
        {
            res.setPatient(p);
        } else
        {
            System.out.println("Patient " + pn + " not found");
        }
        pn = (String) cbDiagnosis.getSelectedItem();
        Diagnosis d = (Diagnosis) dm.findById(Integer.valueOf(pn.split(" ")[0]));
        if (d != null)
        {
            res.setDiagnosis(d);
        } else
        {
            System.out.println("Diagnosis " + pn + " not found");
        }

        AppointmentId aid = new AppointmentId(0, p.getPatId(), d.getDiagId(), c.getCommentId());
        res.setId(aid);
        return res;
    }

    public JButton getOkButton()
    {
        return btnOK2;
    }

    public JButton getCancelButton()
    {
        return btnCancel;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnNewPatient;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNewDiag;
    private javax.swing.JButton btnOK2;
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox cbDiagnosis;
    private javax.swing.JComboBox cbPatient;
    private com.michaelbaranov.microba.calendar.DatePicker dpDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taCommentText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void reload()
    {
        loadDialog();
    }
}
