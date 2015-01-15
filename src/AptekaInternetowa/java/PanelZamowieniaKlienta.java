/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptekaInternetowa.java;

import AptekaInternetowa.models.Lek;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import AptekaInternetowa.models.Uzytkownik;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;

/**
 *
 * @author Wojtek
 */
public class PanelZamowieniaKlienta extends javax.swing.JFrame {

    /**
     * Creates new form PanelZamowienia
     */
    ArrayList<Lek> tabLekiDoZaplaty = (new DatabaseLayer()).getLekidoZaplaty();

    public PanelZamowieniaKlienta() {
        initComponents();

                
        
        jLabel2.setText(Uzytkownik.Nazwa);
        jTable_LekiwPromocji.setModel(new TableModel_LekiWPromocji());
        jTable_NoweLeki.setModel(new TableModel_NoweLeki());
        jTable_LekiDoZaplaty.setModel(new TableModel_LekiDoZaplaty());
        jTable_NoweLeki.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                //    jTable_LekiDoZaplaty.setModel(new TableModel_LekiWPromocji());
                Lek lek = new Lek(e.getFirstRow(), "TEST", "TEST", 14, 5);

                tabLekiDoZaplaty.add(lek);

                TableModel_LekiDoZaplaty model = new TableModel_LekiDoZaplaty();
                model.tabLekiDoZaplaty = tabLekiDoZaplaty;
                jTable_LekiDoZaplaty.setModel(model);
            }
            
        });
        jTable_LekiwPromocji.getModel().addTableModelListener((TableModelEvent e) -> {
            Lek lek = new Lek(e.getFirstRow(), "TABELA_2", "TEST_2", 14, 5);
            
            tabLekiDoZaplaty.add(lek);
            
            TableModel_LekiDoZaplaty model = new TableModel_LekiDoZaplaty();
            model.tabLekiDoZaplaty = tabLekiDoZaplaty;
            jTable_LekiDoZaplaty.setModel(model);
        });
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_NoweLeki = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_LekiwPromocji = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_LekiDoZaplaty = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Jesteś zalogowany jako: ");

        jLabel5.setText("Ofiarowane lekii:");

        jTable_NoweLeki.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nazwa", "Producent", "Cena"
            }
        ));
        jScrollPane3.setViewportView(jTable_NoweLeki);

        jTabbedPane2.addTab("Nowe", jScrollPane3);

        jTable_LekiwPromocji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nazwa", "Producent", "Cena"
            }
        ));
        jScrollPane2.setViewportView(jTable_LekiwPromocji);

        jTabbedPane2.addTab("W promocji", jScrollPane2);

        jTable_LekiDoZaplaty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nazwa", "Producent", "Cena"
            }
        ));
        jScrollPane4.setViewportView(jTable_LekiDoZaplaty);

        jLabel3.setText("Do zapłaty:");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addComponent(jLabel5))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(195, 195, 195))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PanelZamowieniaKlienta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelZamowieniaKlienta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelZamowieniaKlienta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelZamowieniaKlienta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PanelZamowieniaKlienta().setVisible(true);
                
              
              
            }
        });
    }

    public JTable getJTable4() {
        return jTable_LekiDoZaplaty;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable_LekiDoZaplaty;
    private javax.swing.JTable jTable_LekiwPromocji;
    private javax.swing.JTable jTable_NoweLeki;
    // End of variables declaration//GEN-END:variables
}
