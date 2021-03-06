/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GadaiController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author TAMU
 */
public class ViewGadai extends javax.swing.JInternalFrame {
    private String header[] = {"ID Gadai", "ID Customer", "ID Barang",  "Jumlah Pinjaman","Tanggal Pengajuan",  "Sisa Pinjaman", "Status" };
    private String headerTable[] = {"idGadai", "idCust", "idBarang",  "jmlPinjaman", "tglPengajuan", "sisa", "status"};
    public GadaiController gc;
    private List<String> datas;
    /**
     * Creates new form ViewGadai
     */
    public ViewGadai() {
        initComponents();
        gc = new GadaiController();
        datas= gc.bindingAll(TBLGadai, header);
        gc.loadCustomer(cmbCust);
        gc.loadBarang(cmbBrg);
//        gc.loadHistory(cmbStatus);
        reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblIDGadai = new javax.swing.JLabel();
        lblIDCust = new javax.swing.JLabel();
        lblIDBarang = new javax.swing.JLabel();
        lblJumlahPinjaman = new javax.swing.JLabel();
        lblTanggalPengajuan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIDGadai = new javax.swing.JTextField();
        txtJumlahPinjaman = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        txtTanggalPengajuan = new com.toedter.calendar.JDateChooser();
        lblSisaPinjman1 = new javax.swing.JLabel();
        txtSisaPinjaman1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbCust = new javax.swing.JComboBox<>();
        cmbBrg = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        cmbCari = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLGadai = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gadai");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        lblIDGadai.setText("ID Gadai");

        lblIDCust.setText("ID Customer");

        lblIDBarang.setText("ID Barang");

        lblJumlahPinjaman.setText("Jumlah Pinjaman");

        lblTanggalPengajuan.setText("Tanggal Pengajuan");

        jLabel1.setText(":");

        jLabel2.setText(":");

        jLabel3.setText(":");

        jLabel4.setText(":");

        jLabel5.setText(":");

        txtIDGadai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDGadaiKeyPressed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        txtTanggalPengajuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTanggalPengajuanMouseClicked(evt);
            }
        });
        txtTanggalPengajuan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTanggalPengajuanPropertyChange(evt);
            }
        });

        lblSisaPinjman1.setText("Sisa Pinjaman");

        txtSisaPinjaman1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSisaPinjaman1ActionPerformed(evt);
            }
        });
        txtSisaPinjaman1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSisaPinjaman1KeyPressed(evt);
            }
        });

        jLabel7.setText(":");

        jLabel6.setText("Status");

        jLabel8.setText(":");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Lunas", "Lunas" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIDBarang)
                    .addComponent(lblJumlahPinjaman)
                    .addComponent(lblIDGadai)
                    .addComponent(lblIDCust)
                    .addComponent(lblTanggalPengajuan)
                    .addComponent(lblSisaPinjman1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTanggalPengajuan, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(txtIDGadai)
                            .addComponent(txtJumlahPinjaman)
                            .addComponent(cmbCust, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbBrg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSisaPinjaman1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIDGadai)
                            .addComponent(jLabel1)
                            .addComponent(txtIDGadai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIDCust)
                            .addComponent(jLabel2)
                            .addComponent(cmbCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIDBarang)
                            .addComponent(jLabel3)
                            .addComponent(cmbBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJumlahPinjaman)
                            .addComponent(jLabel4)
                            .addComponent(txtJumlahPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblTanggalPengajuan))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSisaPinjman1)
                            .addComponent(jLabel7)
                            .addComponent(txtSisaPinjaman1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtTanggalPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        cmbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Gadai", "Nama Customer", "Nama Barang", "Jumlah Gadai", "Tanggal Pengajuan", "Sisa", "Status" }));

        TBLGadai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TBLGadai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLGadaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBLGadai);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        gc.bindingSearch(TBLGadai, header, 
                headerTable[cmbCari.getSelectedIndex()], 
                txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtIDGadaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDGadaiKeyPressed
        btnSimpan.setEnabled(true);
        btnHapus.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDGadaiKeyPressed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Apakah Anda Yakin Ingin dihapus?");
        if (i == 0) {
            try {
                String pesan = "Gagal hapus";
                boolean hasil = gc.delete(txtIDGadai.getText());
                if (hasil) {
                    pesan = "Hore Berhasil";
                    reset();
                }
                JOptionPane.showMessageDialog(this, pesan);
                gc.bindingAll(TBLGadai, header);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed

//        String status = "Belum Lunas";
//        if ((txtSisaPinjaman1)=0) {
//            status = "Lunas";
//            
//        }
        boolean hasil = false;
       hasil = gc.save(txtIDGadai.getText(), cmbCust.getSelectedItem().toString(),cmbBrg.getSelectedItem().toString(),
                Long.parseLong(txtJumlahPinjaman.getText()),txtTanggalPengajuan.getDate().getTime()+"", 
                Long.parseLong(txtSisaPinjaman1.getText()), cmbStatus.getSelectedItem().toString(), txtIDGadai.isEnabled());
        String pesan = "Gagal menyimpan data";
        if (hasil) {
            pesan = "Berhasil menyimpan data";
        }
        
        
        JOptionPane.showMessageDialog(this, pesan);
//        JOptionPane.showMessageDialog(rootPane, pesan);
        gc.bindingAll(TBLGadai, header);
        reset();
       
//        boolean hasil = false;
//        if(!txtIDGadai.isEnabled()){
//            hasil = gc.update(txtIDGadai.getText(),
//                cmbCust.getSelectedItem(),
//                cmbBrg.getSelectedItem(),
//                Long.parseLong(txtJumlahPinjaman.getText()),
//                txtTanggalPengajuan.getDate().getTime()+"",
//                cmbStatus.getSelectedItem(),
//                txtSisaPinjaman1.getText(),
//                
//            txtIDGadai.setEnabled(true);
//        }else{
//            hasil = gc.insert(txtIDGadai.getText(),
//                txtIDCust.getText(),
//                txtIDBarang.getText(),
//                Long.parseLong(txtJumlahPinjaman.getText()),
//                txtTanggalPengajuan.getDate().getTime()+"",
//                txtStatus.getText(),
//                Long.parseLong(txtStatus.getText()));
//        }
//        String pesan = "Gagal menambahkan data";
//        if (hasil) {
//            try {
//                pesan = "Berhasil menambahkan Data";
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        JOptionPane.showMessageDialog(this, pesan);
//        gc.bindingAll(TBLGadai, header);
        //        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtTanggalPengajuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTanggalPengajuanMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalPengajuanMouseClicked

    private void txtTanggalPengajuanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTanggalPengajuanPropertyChange

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalPengajuanPropertyChange

    private void TBLGadaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLGadaiMouseClicked
        int row = TBLGadai.getSelectedRow();
        txtIDGadai.setText("" + TBLGadai.getValueAt(TBLGadai.getSelectedRow(), 0) + "");
        cmbCust.setSelectedItem(getCombo(false).get(row));
        cmbBrg.setSelectedItem(getCombo(true).get(row));
        txtJumlahPinjaman.setText("" + TBLGadai.getValueAt(TBLGadai.getSelectedRow(), 3) + "");
        txtTanggalPengajuan.setDate((Date) TBLGadai.getValueAt(TBLGadai.getSelectedRow(), 4));
         txtSisaPinjaman1.setText("" + TBLGadai.getValueAt(TBLGadai.getSelectedRow(), 5) + "");
          cmbStatus.setSelectedItem("" + TBLGadai.getValueAt(TBLGadai.getSelectedRow(), 6) + "");
//         cmbStatus.setSelectedItem(getCombo(true).get(row));
         
      
   txtIDGadai.setEnabled(false);
   btnSimpan.setEnabled(true);
   btnHapus.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_TBLGadaiMouseClicked

    private void txtSisaPinjaman1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSisaPinjaman1KeyPressed
       
     String sisa = txtSisaPinjaman1.getText();
//        if (sisa == "0"){
//            cmbStatus.se;
//        } else {
//        }
    }//GEN-LAST:event_txtSisaPinjaman1KeyPressed

    private void txtSisaPinjaman1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSisaPinjaman1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSisaPinjaman1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        gc.bindingAll(TBLGadai, header);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void reset(){
        txtIDGadai.setText("");
        cmbCust.setSelectedIndex(0);
        cmbBrg.setSelectedIndex(0);
        txtJumlahPinjaman.setText("");
        txtTanggalPengajuan.setDate(new Date());
        txtSisaPinjaman1.setText("");
        cmbStatus.setSelectedIndex(0);
//        cmbStatus.setSelectedIndex(0);
        txtIDGadai.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBLGadai;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbBrg;
    private javax.swing.JComboBox<String> cmbCari;
    private javax.swing.JComboBox<String> cmbCust;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIDBarang;
    private javax.swing.JLabel lblIDCust;
    private javax.swing.JLabel lblIDGadai;
    private javax.swing.JLabel lblJumlahPinjaman;
    private javax.swing.JLabel lblSisaPinjman1;
    private javax.swing.JLabel lblTanggalPengajuan;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIDGadai;
    private javax.swing.JTextField txtJumlahPinjaman;
    private javax.swing.JTextField txtSisaPinjaman1;
    private com.toedter.calendar.JDateChooser txtTanggalPengajuan;
    // End of variables declaration//GEN-END:variables
    private List<String> getCombo(boolean isCustomer){
        List<String> isi = new ArrayList<>();
        String[] daftar = new String[datas.size()];
        for (String data : datas) {
            daftar = data.split(";");
            if (isCustomer) isi.add(daftar[1]);
            else isi.add(daftar[0]);
        }
        return isi;
}
}
