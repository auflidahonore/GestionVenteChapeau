/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author njara lucien
 */
public class Facture extends javax.swing.JFrame {

    /**
     * Creates new form Facture
     */
     Connecter connect = new Connecter();
    ResultSet Rs=null;
   Statement ps=null;
   DefaultTableModel model=new DefaultTableModel();
   
    public Facture() {
        initComponents();
         model.addColumn("numachat");
        model.addColumn("idCli");
        model.addColumn("idChap");
        model.addColumn("qttachat");
        model.addColumn("prixtotal");
        model.addColumn("dateachat");
         try{
            ps=connect.obtenirConnection().createStatement();
            ResultSet Rs=ps.executeQuery("Select * from achat");
            while(Rs.next()){
            model.addRow(new Object[]{
            Rs.getString("numachat"),Rs.getString("idCli"),Rs.getString("idChap"),
                Rs.getString("qttachat"),Rs.getString("prixtotal"),Rs.getString("dateachat")});
            
            }
        }catch(Exception e){
            System.err.println(e);
        }
        tableAchat.setModel(model);
    }
   
    @SuppressWarnings("unchecked")
     public void afficher(){
        
         try{
             model.setRowCount(0);
            ps=connect.obtenirConnection().createStatement();
            ResultSet Rs=ps.executeQuery("Select * from achat");
            while(Rs.next()){
            model.addRow(new Object[]{
                 Rs.getString("numachat"),Rs.getString("idCli"),Rs.getString("idChap"),
                Rs.getString("qttachat"),Rs.getString("prixtotal"),Rs.getString("dateachat")
            });
            
            }
        }catch(Exception e){
            System.err.println(e);
        }
        tableAchat.setModel(model);
        
    }
     
      
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtprenom = new javax.swing.JTextField();
        txtadresse = new javax.swing.JTextField();
        txtnum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        txtrecherchecli = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAchat = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtGT = new javax.swing.JTextField();
        jComboBoxrecherche = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        txtrecherche = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 13, 14, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("NOM");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(340, 10, 28, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("PRENOM");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(320, 50, 52, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("ADRESSE");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 50, 57, 15);

        txtid.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(txtid);
        txtid.setBounds(90, 11, 146, 20);

        txtnom.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(txtnom);
        txtnom.setBounds(400, 10, 146, 20);

        txtprenom.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(txtprenom);
        txtprenom.setBounds(400, 50, 146, 20);

        txtadresse.setBackground(new java.awt.Color(204, 255, 204));
        txtadresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadresseActionPerformed(evt);
            }
        });
        jPanel2.add(txtadresse);
        txtadresse.setBounds(90, 50, 146, 20);

        txtnum.setBackground(new java.awt.Color(153, 255, 153));
        txtnum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnum.setForeground(new java.awt.Color(0, 0, 204));
        txtnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Date:");

        jButton6.setFont(new java.awt.Font("Agency FB", 2, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(153, 153, 0));
        jButton6.setText("IMPRIMER");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon("E:\\visual studio\\java\\GestionVenteChapeau\\icon\\Exit.png")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(204, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 204));
        jLabel13.setText("FACTURE N°");

        jButton8.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 255));
        jButton8.setText("Recherche id cli");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        txtrecherchecli.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtrecherchecli.setForeground(new java.awt.Color(255, 51, 51));

        tableAchat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° Achat", "ID cli", "ID chap", "QUANTITE", "Prix Total", "DATE"
            }
        ));
        tableAchat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAchatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAchat);

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 102, 0));
        jLabel12.setText("TOTAL DE vos ACHATS ");

        txtGT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGTActionPerformed(evt);
            }
        });

        jComboBoxrecherche.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jComboBoxrecherche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "numachat", "idCli", "idChap", "qttachat", "prixtotal", "datechat" }));
        jComboBoxrecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxrechercheActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 255));
        jButton5.setText("Recherche");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtrecherche.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtrecherche.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addComponent(txtrecherchecli, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txtGT, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxrecherche, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtrecherche)
                        .addGap(167, 167, 167)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addGap(11, 11, 11)
                        .addComponent(txtrecherchecli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton6))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jComboBoxrecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtrecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGTActionPerformed

    private void tableAchatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAchatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableAchatMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        try {
            ps=connect.obtenirConnection().createStatement();
            Rs=ps.executeQuery("Select idCli,nomCli,preCli,adrCli from client WHERE idCli='"+txtrecherchecli.getText()+"' ");
            while(Rs.next()){
                txtid.setText(Rs.getString("idCli"));
                txtnom.setText(Rs.getString("nomCli"));
                txtprenom.setText(Rs.getString("preCli"));
                txtadresse.setText(Rs.getString("adrCli"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        /*Achat x = new Achat();
        x.setVisible(true);*/
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");

        try {
            tableAchat.print(JTable.PrintMode.NORMAL,header,footer);

        } catch (PrinterException ex) {
            Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
            System.err.format("erreur d'impression", ex.getMessage());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumActionPerformed

    private void txtadresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadresseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadresseActionPerformed

    private void jComboBoxrechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxrechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxrechercheActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try{
            model.setRowCount(0);
            {
                if( jComboBoxrecherche.getSelectedIndex() ==0){
                    Rs=ps.executeQuery("Select * from achat WHERE numachat='"+txtrecherche.getText()+"'");
                }
                else if( jComboBoxrecherche.getSelectedIndex() ==1){
                    Rs=ps.executeQuery("Select * from achat WHERE idcli='"+txtrecherche.getText()+"'");
                }
                else if( jComboBoxrecherche.getSelectedIndex() ==2){
                    Rs=ps.executeQuery("Select * from achat WHERE idChap='"+txtrecherche.getText()+"'");
                }
                else if( jComboBoxrecherche.getSelectedIndex() ==3){
                    Rs=ps.executeQuery("Select * from achat WHERE qttachat='"+txtrecherche.getText()+"'");
                }
                else if( jComboBoxrecherche.getSelectedIndex() ==4){
                    Rs=ps.executeQuery("Select * from achat WHERE prixtotal='"+txtrecherche.getText()+"'");
                }
                else if( jComboBoxrecherche.getSelectedIndex() ==4){
                    Rs=ps.executeQuery("Select * from achat WHERE dateachat='"+txtrecherche.getText()+"'");
                }

            }while(Rs.next()){
                Object[]chapeau={ Rs.getString("numachat"),Rs.getString("idCli"),Rs.getString("idChap"),
                    Rs.getString("qttachat"),Rs.getString("prixtotal"),Rs.getString("dateachat")};
                model.addRow(chapeau);
            }if(model.getRowCount()==0){JOptionPane.showMessageDialog(null, " il y a aucun chapeau"); }
            else{
                int i=0;
                
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
         GT();
    }//GEN-LAST:event_jButton5ActionPerformed
     public void GT(){
         try {
             Rs= ps.executeQuery("select SUM(prixtotal) as prixtotal from achat where numachat= '"+txtrecherche.getText()+"' ");
             Rs.next();
             txtGT.setText(Rs.getString("prixtotal"));
         } catch (SQLException ex) {
             Logger.getLogger(Achat.class.getName()).log(Level.SEVERE, null, ex);
         }
   
   }
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
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Facture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBoxrecherche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAchat;
    private javax.swing.JTextField txtGT;
    private javax.swing.JTextField txtadresse;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txtrecherche;
    private javax.swing.JTextField txtrecherchecli;
    // End of variables declaration//GEN-END:variables
}
