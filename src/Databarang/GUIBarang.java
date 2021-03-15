/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Databarang;

import DataKategori.Kategori;
import DataKategori.Kontrol_Kategori;
import DataSatuan.Kontrol_Satuan;
import DataSatuan.Satuan;
import Koneksi.koneksiOracle;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import sun.swing.ImageIconUIResource;

/**
 *
 * @author basisc16
 */
public class GUIBarang extends javax.swing.JFrame {

    private String folder;

    public GUIBarang() {
        initComponents();
        folder = System.getProperty("user.dir") + File.separator + "Images";
        new File(folder).mkdir();
        tampilIsiKategori();
        tampilIsiSatuan();
        DialogBarang.setVisible(false);
        DialogBarang.setLocationRelativeTo(null);
        DialogBarang.setSize(1000, 400);
        DialogBarang.setTitle("DAFTAR SELURUH BARANG");
    }

    public void Refresh() {
//        fieldkode.setText("");
        fieldNama.setText("");
        fieldhargaBarang.setText("0");
        fieldHargaSewa.setText("0");
        comboKategori.setSelectedIndex(0);
        comboKategori.setEnabled(true);
        labelGambar.setBackground(Color.BLUE);
        comboSatuan.setSelectedIndex(0);
        buttonHapus.setEnabled(false);
        buttonSimpan.setText("SIMPAN");
        tampilBarang();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogBarang = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablebarang = new javax.swing.JTable();
        PRINT = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldkode = new javax.swing.JTextField();
        fieldNama = new javax.swing.JTextField();
        comboKategori = new javax.swing.JComboBox();
        comboSatuan = new javax.swing.JComboBox();
        fieldhargaBarang = new javax.swing.JTextField();
        fieldHargaSewa = new javax.swing.JTextField();
        labelGambar = new javax.swing.JLabel();
        buttonBrowseGambar = new javax.swing.JButton();
        labelPathAlamat = new javax.swing.JLabel();
        buttonSimpan = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonList = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();
        buttonKeluar = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("LIST BARANG"));

        tablebarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tablebarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablebarang);

        PRINT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1442483829_Print.png"))); // NOI18N
        PRINT.setText("PRINT");
        PRINT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRINTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PRINT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PRINT)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout DialogBarangLayout = new javax.swing.GroupLayout(DialogBarang.getContentPane());
        DialogBarang.getContentPane().setLayout(DialogBarangLayout);
        DialogBarangLayout.setHorizontalGroup(
            DialogBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DialogBarangLayout.setVerticalGroup(
            DialogBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel2.setText("DATA BARANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel3.setText("Kode");

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Kategori Barang");

        jLabel6.setText("Satuan");

        jLabel7.setText("Harga Barang");

        jLabel8.setText("Harga Sewa/Jam");

        fieldkode.setEditable(false);
        fieldkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldkodeActionPerformed(evt);
            }
        });

        comboKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKategoriActionPerformed(evt);
            }
        });

        comboSatuan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kg", "Liter", "Buah", "Gram" }));

        fieldhargaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldhargaBarangKeyTyped(evt);
            }
        });

        fieldHargaSewa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldHargaSewaKeyTyped(evt);
            }
        });

        labelGambar.setText("Gambar");
        labelGambar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonBrowseGambar.setText("Browse");
        buttonBrowseGambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowseGambarActionPerformed(evt);
            }
        });

        labelPathAlamat.setText("Alamat gambar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboSatuan, 0, 146, Short.MAX_VALUE)
                            .addComponent(comboKategori, 0, 146, Short.MAX_VALUE)
                            .addComponent(fieldhargaBarang)
                            .addComponent(fieldHargaSewa)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldkode, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 215, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBrowseGambar)
                    .addComponent(labelPathAlamat))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fieldkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4))
                    .addComponent(labelGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBrowseGambar))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelPathAlamat))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(comboSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(fieldhargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(fieldHargaSewa))))
                .addContainerGap())
        );

        buttonSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1442483718_Save.png"))); // NOI18N
        buttonSimpan.setText("SIMPAN");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1442483766_Delete.png"))); // NOI18N
        buttonHapus.setText("HAPUS");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        buttonList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1442483845_Copy.png"))); // NOI18N
        buttonList.setText("LIST");
        buttonList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListActionPerformed(evt);
            }
        });

        buttonBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1442483766_Delete.png"))); // NOI18N
        buttonBatal.setText("BATAL");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });

        buttonKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1442484041_exit.png"))); // NOI18N
        buttonKeluar.setText("KELUAR");
        buttonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(buttonSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonList)
                .addGap(18, 18, 18)
                .addComponent(buttonBatal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonKeluar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonHapus)
                    .addComponent(buttonList)
                    .addComponent(buttonBatal)
                    .addComponent(buttonKeluar))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldkodeActionPerformed

    private void buttonBrowseGambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBrowseGambarActionPerformed
        // TODO add your handling code here:
        javax.swing.JFileChooser jfc = new JFileChooser();
        FileFilter JPG, GIF, BOTH;
        JPG = new FileNameExtensionFilter("Gambar JPEG", "jpg");
        GIF = new FileNameExtensionFilter("Gambar GIF", "gif");
        BOTH = new FileNameExtensionFilter("Gambar JPEG dan GIF", "jpg", "gif");
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.addChoosableFileFilter(JPG);
        jfc.addChoosableFileFilter(GIF);
        jfc.addChoosableFileFilter(BOTH);
        if (jfc.showOpenDialog(this) == jfc.APPROVE_OPTION) {
            String file = jfc.getSelectedFile().toString();
            labelPathAlamat.setText(file);
            Toolkit tool = Toolkit.getDefaultToolkit();
            Image ig = tool.getImage(file);
            Image image = ig.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon img = new ImageIcon(image);
            labelGambar.setIcon(img);

        }
    }//GEN-LAST:event_buttonBrowseGambarActionPerformed

    private void comboKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKategoriActionPerformed
        try {
            String Combo = comboKategori.getSelectedItem().toString();
            String split[] = Combo.split(" ");
            String kodeKat = split[0];
            String bantu;
            int kode = KontrolBarang.getKoneksi().kodeOtomatis(kodeKat) + 1;
            if (kode == 1) {
                bantu = "001";
                fieldkode.setText(kodeKat + "-B" + bantu);
            } else if (kode < 10) {
                bantu = "00";
                fieldkode.setText(kodeKat + "-B" + bantu + Integer.toString(kode));
            } else if (10 <= kode && kode < 100) {
                bantu = "0";
                fieldkode.setText(kodeKat + "-B" + bantu + Integer.toString(kode));
            } else {
                fieldkode.setText(kodeKat + "-B" + Integer.toString(kode));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

    }//GEN-LAST:event_comboKategoriActionPerformed

    private void fieldhargaBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldhargaBarangKeyTyped
        // TODO add your handling code here:
        char kar = evt.getKeyChar();
        if (!(Character.isDigit(kar) || kar == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldhargaBarangKeyTyped

    private void fieldHargaSewaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldHargaSewaKeyTyped
        // TODO add your handling code here:
        char kar = evt.getKeyChar();
        if (!(Character.isDigit(kar) || kar == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldHargaSewaKeyTyped

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:
        if (fieldNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi nama barang");
        } else {
            String kodeBarang = fieldkode.getText();
            String namaBarang = fieldNama.getText();
            String satuan = comboSatuan.getSelectedItem().toString();
            String gambar = labelGambar.getText();
            String[] split = comboKategori.getSelectedItem().toString().split(" ");
            Kategori kat = new Kategori();
            kat.setKode(split[0]);//0 kode kategori, 1 nama kategori
            double hargaBarang = 0, hargaSewa = 0;
            if (fieldhargaBarang.getText().equals("")) {
                hargaBarang = 0;
            } else {
                hargaBarang = Double.parseDouble(fieldhargaBarang.getText());
            }
            if (fieldHargaSewa.getText().equals("")) {
                hargaSewa = 0;
            } else {
                hargaSewa = Double.parseDouble(fieldHargaSewa.getText());
            }
            if (!labelPathAlamat.getText().equals("")) {
                try {
                    new CopyImage(labelPathAlamat.getText(), gambar(fieldkode.getText()));
                } catch (IOException ex) {
                    ex.getMessage();
                }

            }
            Barang brg = new Barang();
            brg.setKodeBarang(kodeBarang);//1
            brg.setNamaBarang(namaBarang);//2
            brg.setKategori(kat);//3
            brg.setSatuan(satuan);//4
            brg.setHargaBarang(hargaBarang);//5
            brg.setHargasewa(hargaSewa);//6
            brg.setImage(gambar);//11
            KontrolBarang bk = KontrolBarang.getKoneksi();
            if (buttonSimpan.getText().equals("UPDATE")) {
                bk.UpdateBarang(brg);
                JOptionPane.showMessageDialog(null, "Terupdate");
            } else {
                bk.InsertBarang(brg);
                JOptionPane.showMessageDialog(null, "Tersimpan");
            }
            Refresh();
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListActionPerformed
        // TODO add your handling code here:
        tampilBarang();
        DialogBarang.setLocationRelativeTo(null);
        DialogBarang.setVisible(true);
    }//GEN-LAST:event_buttonListActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
        if (fieldkode.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(rootPane, "Masukkan kode");
        } else {
            KontrolBarang kon = KontrolBarang.getKoneksi();
            kon.DeleteBarang(fieldkode.getText());
            JOptionPane.showMessageDialog(rootPane, "Data sudah berhasil dihapus");
            Refresh();
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void tablebarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebarangMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int row = tablebarang.getSelectedRow();
            String kodeBarang = tablebarang.getValueAt(row, 1).toString();
            String namaBarang = tablebarang.getValueAt(row, 2).toString();
            String kodeKategori = tablebarang.getValueAt(row, 3).toString();
            String Satuan = tablebarang.getValueAt(row, 4).toString();
            String hargaBarang = tablebarang.getValueAt(row, 5).toString();
            String hargaSewa = tablebarang.getValueAt(row, 6).toString();

            fieldNama.setText(namaBarang);
            comboSatuan.setSelectedItem(Satuan);
            fieldHargaSewa.setText(hargaSewa);
            fieldhargaBarang.setText(hargaBarang);
            Toolkit tool = Toolkit.getDefaultToolkit();
            Image ig = tool.getImage(gambar(kodeBarang));
            Image imagerez = ig.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon igm = new ImageIcon(imagerez);
            labelGambar.setIcon(igm);

            Kategori k = Kontrol_Kategori.getKoneksi().cariKategori(kodeKategori);
            comboKategori.setSelectedItem(kodeKategori + " " + k.getNama());
            comboKategori.setEnabled(false);

//         

            fieldkode.setText(kodeBarang);
            buttonHapus.setEnabled(true);
            buttonSimpan.setText("UPDATE");
            DialogBarang.setVisible(false);
        } catch (SQLException ex) {
            ex.getMessage();
        }

    }//GEN-LAST:event_tablebarangMouseClicked

    private void buttonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonKeluarActionPerformed

    private void PRINTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRINTActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            DialogBarang.dispose();
            String alamatReport = System.getProperty("user.dir") + File.separator + "src" + File.separator
                    + "Laporan" + File.separator + "barang.jasper";
            String alamatImage = System.getProperty("user.dir") + File.separator + "Images" + File.separator;

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("image", alamatImage);

            JasperPrint jasperPrint = JasperFillManager.fillReport(alamatReport, params, new koneksiOracle().getKoneksiOracleDB());
//          JasperViewer.viewReport(jasperPrint, false);
            JRViewer aViewer = new JRViewer(jasperPrint);
            JDialog viewer = new JDialog();
            viewer.setTitle("Laporan Data Barang");
            viewer.setAlwaysOnTop(true);
            viewer.getContentPane().add(aViewer);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            viewer.setBounds(0, 0, screenSize.width, screenSize.height);
            viewer.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            viewer.setVisible(true);

        } catch (JRException ex) {

        }
    }//GEN-LAST:event_PRINTActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_buttonBatalActionPerformed

    public void tampilIsiKategori() {
        List<Kategori> kt = Kontrol_Kategori.getKoneksi().tampilKategori();
        for (int i = 0; i < kt.size(); i++) {
            comboKategori.addItem(kt.get(i).getKode() + " " + kt.get(i).getNama());
        }
    }

    public void tampilIsiSatuan() {
        List<Satuan> kt = Kontrol_Satuan.getKoneksi().tampilSatuan();
        comboSatuan.removeAllItems();
        for (int i = 0; i < kt.size(); i++) {
            comboSatuan.addItem(kt.get(i).getNama());
        }
    }

    private String gambar(String id) {
        return folder + File.separator + id.trim() + ".jpg";
    }

    private void cetak(String str) {
        System.out.println(str);
    }

    public void tampilBarang() {
        List<Barang> brg = KontrolBarang.getKoneksi().tampilDataBarang();
        TabelModel_Barang model = new TabelModel_Barang(brg);
        tablebarang.setModel(model);
    }

    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUIBarang().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogBarang;
    private javax.swing.JButton PRINT;
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonBrowseGambar;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonKeluar;
    private javax.swing.JButton buttonList;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox comboKategori;
    private javax.swing.JComboBox comboSatuan;
    private javax.swing.JTextField fieldHargaSewa;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField fieldhargaBarang;
    private javax.swing.JTextField fieldkode;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelGambar;
    private javax.swing.JLabel labelPathAlamat;
    private javax.swing.JTable tablebarang;
    // End of variables declaration//GEN-END:variables

    public class CopyImage {

        public CopyImage(String asal, String tujuan) throws IOException {
            FileInputStream inFile = new FileInputStream(asal);
            FileInputStream outFile = new FileInputStream(tujuan);
            FileChannel inChannel = inFile.getChannel();
            FileChannel outChannel = outFile.getChannel();
            for (ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
                    inChannel.read(buffer) != -1;
                    buffer.clear()) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    outChannel.write(buffer);
                }
            }
            inChannel.close();
            outChannel.close();
        }
    }
}
