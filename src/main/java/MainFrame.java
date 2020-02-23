/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import DaDBConnector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Willy
 */
public class MainFrame extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    // Данные для таблиц
    private String[] rowValues = null;
    // Заголовки столбцов
    private Object[] columnsHeader = new String[]{"Наименование", "Ед.измерения", "Количество", "id"};

    private BaseControl GShopDB = new BaseControl();
    public Password logonData = new Password();
    private PasswordDialog pwdRequest = new PasswordDialog(this, true);
//    private equipmentRow currEquip = new equipmentRow();
    private ArrayList<EquipmentRow> primaryData = null;
//    private Integer maxIndex = 0;

    /**
     * Creates new form DialogForm
     */
    public MainFrame() {

        // Данный блок устанавливает настройки внешнего вида окон в соответствии с системными
        //Начало
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Ошибка", JOptionPane.DEFAULT_OPTION);
        }
        //Конец

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnsHeader);
        initComponents();
        TableColumnModel tcm = jTab.getColumnModel();
        tcm.removeColumn(tcm.getColumn(3));
        btnShow.setEnabled(false);
        btnSave.setEnabled(false);
        btnDelRow.setEnabled(false);
        btnAddRow.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConnect = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTab = new javax.swing.JTable();
        btnAddRow = new javax.swing.JButton();
        btnDelRow = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTFStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnConnect.setText("Соединение с БД");
        btnConnect.setActionCommand("OpenFile");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectPressed(evt);
            }
        });

        btnShow.setText("Показать");
        btnShow.setActionCommand("ShowText");
        btnShow.setMaximumSize(new java.awt.Dimension(105, 23));
        btnShow.setMinimumSize(new java.awt.Dimension(105, 23));
        btnShow.setPreferredSize(new java.awt.Dimension(105, 23));
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowClck(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Список товаров");

        jTab.setModel(tableModel);
        jTab.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTabComponentAdded(evt);
            }
        });
        jScrollPane2.setViewportView(jTab);

        btnAddRow.setText("Добавить строку");
        btnAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRowActionPerformed(evt);
            }
        });

        btnDelRow.setText("Удалить строку");
        btnDelRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelRowActionPerformed(evt);
            }
        });

        btnSave.setText("Сохранить изменения");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Статус соединения:");

        jTFStatus.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddRow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelRow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddRow)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelRow)
                        .addGap(20, 20, 20)
                        .addComponent(btnSave))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void setLogonData(String login, String pwd, boolean confirm) {
        logonData.login = login;
        logonData.passw = pwd;
        logonData.confirmation = confirm;
    }
    private void btnConnectPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectPressed

        pwdRequest.setSize(330, 145);
        pwdRequest.setResizable(false);
        pwdRequest.setVisible(true);
        //после этого управление передаётся в окно запроса пароля
        //следующая строка начнёт выполняться после закрывания окна пароля
        if (pwdRequest.logonData.confirmation) {
            try {
                GShopDB.createConnection(pwdRequest.logonData.login, pwdRequest.logonData.passw);
                jTFStatus.setText("Соединение установлено");
                btnShow.setEnabled(true);
            } catch (Exception ex) {
                jTFStatus.setText(ex.getMessage());
            }
        } else {
            jTFStatus.setText("Отменено пользователем");
        }
        pwdRequest = null;
    }//GEN-LAST:event_btnConnectPressed

    private void btnShowClck(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowClck
        try {
            primaryData = GShopDB.getFullData();
            jTFStatus.setText("Соединение закрыто");
            for (int i = 0; i < primaryData.size(); i++) {
                String[] newRow = new String[]{primaryData.get(i).name,
                    primaryData.get(i).unit,
                    Float.toString(primaryData.get(i).quantity),
                    Integer.toString(primaryData.get(i).id)};
                tableModel.addRow(newRow);
            }
            btnAddRow.setEnabled(true);
            btnSave.setEnabled(true);
            btnDelRow.setEnabled(true);
        } catch (Exception ex) {
            jTFStatus.setText(ex.getMessage());
        };
    }//GEN-LAST:event_btnShowClck

    private void btnAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRowActionPerformed
        // TODO add your handling code here:
        String[] newRow = new String[]{"", "", "", ""};
        tableModel.addRow(newRow);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnAddRowActionPerformed

    private void btnDelRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelRowActionPerformed
        // TODO add your handling code here:
        int[] j = jTab.getSelectedRows();
        for (int n = j.length - 1; n >= 0; n--) {
            if (j[n] >= 0) {
                tableModel.removeRow(j[n]);
            }
        }
    }//GEN-LAST:event_btnDelRowActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

        ArrayList<EquipmentRow> currentData = new ArrayList<EquipmentRow>();

        for (int i = 0; i < tableModel.getRowCount(); i++) {

            EquipmentRow currEquip = new EquipmentRow();
            String currName = tableModel.getValueAt(i, 0).toString();
            String currUnit = tableModel.getValueAt(i, 1).toString();
            String currQuan = tableModel.getValueAt(i, 2).toString();
            String currId = tableModel.getValueAt(i, 3).toString();

//Название
            currEquip.name = currName;
//Единица измерения             
            currEquip.unit = currUnit;
//ID
            if (currId.isEmpty()) {
                currEquip.id = 0;
            } else {
                try {
                    currEquip.id = Integer.parseInt(currId);
                } catch (NumberFormatException NFEex) {
                    JOptionPane.showMessageDialog(this, NFEex.getMessage(), "Сохранение прервано", HEIGHT);
                    return;
                }
            }
//Количество
            if (currQuan.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Укажите количество товара.", "Сохранение прервано", HEIGHT);
                return;
            } else {
                try {
                    currEquip.quantity = Float.parseFloat(currQuan);
                } catch (NumberFormatException NFEex) {
                    JOptionPane.showMessageDialog(this, "Невозможно преобразовать '" + currQuan + "' в число", "Сохранение прервано", HEIGHT);
                    return;
                }
            }
            currentData.add(currEquip);
        }
        try {
            DataState data = new DataState(primaryData, currentData);
            GShopDB.SaveChanges(data);
            JOptionPane.showMessageDialog(this, "Сохранение выполнено. Программа прекращает работу.", "Всё замечательно!", HEIGHT);
            this.setVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Сохранение прервано!", HEIGHT);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (GShopDB != null) {

            try {
                GShopDB.closeConnection();
            } catch (Exception ex) {
            };
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTabComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTabComponentAdded
        // TODO add your handling code here:
        System.out.println("Component added");
    }//GEN-LAST:event_jTabComponentAdded

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
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRow;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDelRow;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFStatus;
    private javax.swing.JTable jTab;
    // End of variables declaration//GEN-END:variables
}