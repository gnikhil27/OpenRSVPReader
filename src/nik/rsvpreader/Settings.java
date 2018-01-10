/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nik.rsvpreader;

import java.awt.Font;

/**
 *
 * @author u1
 */
public class Settings extends javax.swing.JFrame {
    private Font fnt;
    private core myCore;
    /**
     * Creates new form Settings
     * @param mycr Select and Send core to the main Program
     */
    public Settings(core mycr) {
        initComponents();
        myCore=mycr;
        txtchunk.setValue(mycr.getChunkSize());
        txtwpm.setValue(mycr.getWordsPerMinute());
        fnt=mycr.getFont();
         lblsample.setFont(fnt);
    }
    public Settings() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnok = new javax.swing.JButton();
        lblWPM = new javax.swing.JLabel();
        txtwpm = new javax.swing.JSpinner();
        lblchunk = new javax.swing.JLabel();
        txtchunk = new javax.swing.JSpinner();
        lblFontChooser = new javax.swing.JLabel();
        btnchoose = new javax.swing.JButton();
        lblsample = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnok.setMnemonic('o');
        btnok.setText("O.K.");
        btnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnok, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnok, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        lblWPM.setText("Word Per Minute");

        txtwpm.setName("wpm"); // NOI18N

        lblchunk.setText("Chunk Size");

        lblFontChooser.setText("Select Font");

        btnchoose.setText("Choose");
        btnchoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchooseActionPerformed(evt);
            }
        });

        lblsample.setText("Sample of Font");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWPM)
                            .addComponent(lblchunk))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtwpm, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addComponent(txtchunk)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFontChooser)
                        .addGap(27, 27, 27)
                        .addComponent(btnchoose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblsample)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWPM)
                    .addComponent(txtwpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblchunk)
                    .addComponent(txtchunk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFontChooser)
                    .addComponent(btnchoose)
                    .addComponent(lblsample))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnchooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchooseActionPerformed
        // TODO add your handling code here:
        JFontChooser fc=new JFontChooser();
        fc.setSelectedFont(fnt);
        fc.showDialog(lblsample);
        fnt=fc.getSelectedFont();
        lblsample.setFont(fnt);
        
    }//GEN-LAST:event_btnchooseActionPerformed

    private void btnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokActionPerformed
        // TODO add your handling code here:
        myCore.setChunkSize(getChunkSize());
        myCore.setWordsPerMinute(getWordPerMinute());
        myCore.setFont(fnt);
        this.dispose();
    }//GEN-LAST:event_btnokActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Settings().setVisible(true);
        });
    }

    int getWordPerMinute(){return Integer.parseInt(txtwpm.getValue().toString());}
    int getChunkSize(){return Integer.parseInt(txtchunk.getValue().toString());}
    Font getSelectedFont(){return fnt;}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchoose;
    private javax.swing.JButton btnok;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFontChooser;
    private javax.swing.JLabel lblWPM;
    private javax.swing.JLabel lblchunk;
    private javax.swing.JLabel lblsample;
    private javax.swing.JSpinner txtchunk;
    private javax.swing.JSpinner txtwpm;
    // End of variables declaration//GEN-END:variables
}