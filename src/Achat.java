import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author njara lucien
 */
public class Achat extends javax.swing.JFrame {

    /**
     * Creates new form Achat
     */
     Connecter connect = new Connecter();
    ResultSet Rs=null;
   Statement ps=null;
   public DefaultTableModel model=new DefaultTableModel();
  
    public Achat() {
        
     
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
     
      public void deplace(int i){
          
        try{
            txtnum.setText(model.getValueAt(i,0).toString());
            txtidcli.setText(model.getValueAt(i,1).toString());
            txtidchap.setText(model.getValueAt(i,2).toString());
            txtQTT.setText(model.getValueAt(i,3).toString());
            txtPT.setText(model.getValueAt(i,4).toString());
            txtdate.setText(model.getValueAt(i,5).toString());
        }catch(Exception e){System.err.println(e);
        JOptionPane.showMessageDialog(null,"erreur de deplacement"+e.getLocalizedMessage());}
    }
    
   public void prixtotal(){
       double c=0;
        double b=0;
        String cc = null ;
          double a = Double.parseDouble(txtQTT.getText());
         try {
             ps = connect.obtenirConnection().createStatement();
              Rs =  ps.executeQuery("select prixChap from chapeau where idChap='"+txtidchap.getText()+"'");
              while(Rs.next()){
               cc = Rs.getString("prixChap").toString();
              }
              
              b = Double.parseDouble(cc);
              c = a*b;
         } catch (SQLException ex) {
             Logger.getLogger(Achat.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       
       txtPT.setText(String.valueOf(c));
   
   }
   
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtidchap = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtidcli = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBoxrecherche = new javax.swing.JComboBox();
        txtrecherche = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAchat = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtGT = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtQTT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtnum = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID CHAPEAU");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 50, 80, 15);

        txtidchap.setBackground(new java.awt.Color(153, 153, 153));
        txtidchap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidchapActionPerformed(evt);
            }
        });
        jPanel3.add(txtidchap);
        txtidchap.setBounds(130, 50, 50, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("ID CLIENT");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(10, 13, 80, 15);

        txtidcli.setBackground(new java.awt.Color(153, 153, 153));
        txtidcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidcliActionPerformed(evt);
            }
        });
        jPanel3.add(txtidcli);
        txtidcli.setBounds(130, 10, 50, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jButton1.setText("Ajoutter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jButton2.setText("Supprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jButton3.setText("Modifier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jButton4.setText("Actualiser");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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

        jComboBoxrecherche.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jComboBoxrecherche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "numachat", "idCli", "idChap", "qttachat", "prixtotal", "datechat" }));
        jComboBoxrecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxrechercheActionPerformed(evt);
            }
        });

        txtrecherche.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtrecherche.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxrecherche, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(64, 64, 64)
                        .addComponent(jButton4))
                    .addComponent(txtrecherche))
                .addGap(45, 45, 45))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jComboBoxrecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
        jLabel12.setText("TOTAL DE TOUT LES ACHATS ");

        txtGT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGTActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 0));
        jLabel9.setText("QUANTITE");

        txtQTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQTTActionPerformed(evt);
            }
        });
        txtQTT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQTTKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 0));
        jLabel10.setText("Prix Total");

        txtPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPTActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setText("Date d'achat");

        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 255));
        jLabel14.setText("N° Achat");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtQTT, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(txtPT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txtPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("LISTE DES ACHATS EFFECTUEES");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jButton7.setIcon(new javax.swing.ImageIcon("E:\\visual studio\\java\\GestionVenteChapeau\\icon\\Knob Snapback.png")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon("E:\\visual studio\\java\\GestionVenteChapeau\\icon\\List.png")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtGT, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton7)
                                        .addGap(41, 41, 41)
                                        .addComponent(jButton6)
                                        .addGap(70, 70, 70))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidchapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidchapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidchapActionPerformed

    private void jComboBoxrechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxrechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxrechercheActionPerformed

    private void txtPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPTActionPerformed

    private void txtidcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidcliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidcliActionPerformed

    private void txtGTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGTActionPerformed

    private void txtQTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQTTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String numachat=txtnum.getText();
        String idCli=txtidcli.getText();
        String idChap=txtidchap.getText();
        String qttachat=txtQTT.getText();
        String prixtotal=txtPT.getText();
        String dateachat=txtdate.getText();
        String requete="INSERT INTO achat (numachat,idCli,idChap,qttachat,prixtotal,dateachat) values('"+numachat+"','"+idCli+"','"+idChap+"','"+qttachat+"','"+prixtotal+"','"+dateachat+"')";
        
            try{
                ps.executeUpdate(requete);
                JOptionPane.showMessageDialog(null, "achat effectuée");
            txtnum.setText("");
            txtidcli.setText("");
            txtidchap.setText("");
            txtQTT.setText("");
            txtPT.setText("");
            txtdate.setText("");
            afficher();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try{
            if (JOptionPane.showConfirmDialog (null, "voulez vous vraiment supprimer?"
            ,"supprimer achat",JOptionPane.YES_NO_OPTION  )==JOptionPane.OK_OPTION)
                if(txtnum.getText().length()!=0 ){
                    ps.executeUpdate("Delete from achat where numachat="+txtnum.getText());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Veuillez remplir le champ num achat!");
                }
        
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(null, "erreur de supprimer \n"+e.getMessage());
        }
           txtnum.setText("");
            txtidcli.setText("");
            txtidchap.setText("");
            txtQTT.setText("");
            txtPT.setText("");
            txtdate.setText("");  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         try{
            if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null,"confirmer la modification","modification",
                    JOptionPane.YES_NO_OPTION) )
            {
                ps.executeUpdate("UPDATE achat SET idCli='"+txtidcli.getText()+"',idChap='"+txtidchap.getText()+"',qttachat='"+txtQTT.getText()+"',prixtotal='"+txtPT.getText()+"',dateachat='"+txtdate.getText()+"' WHERE numachat="+txtnum.getText()  );
                afficher();
            } 
              
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "erreur modifier!!!");
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
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
        afficher();
    }//GEN-LAST:event_jButton4ActionPerformed

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
                deplace (i);
            }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        GT();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tableAchatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAchatMouseClicked
        // TODO add your handling code here:
         try{
           int i=tableAchat.getSelectedRow();deplace(i);
        }catch(Exception e){JOptionPane.showMessageDialog(null,"erreur de deplacement"+e.getLocalizedMessage());}
    }//GEN-LAST:event_tableAchatMouseClicked

    private void txtQTTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQTTKeyReleased
       prixtotal();
    }//GEN-LAST:event_txtQTTKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Facture fac = new Facture();
        fac.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Achat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBoxrecherche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAchat;
    private javax.swing.JTextField txtGT;
    private javax.swing.JTextField txtPT;
    private javax.swing.JTextField txtQTT;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtidchap;
    private javax.swing.JTextField txtidcli;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtrecherche;
    // End of variables declaration//GEN-END:variables
}
