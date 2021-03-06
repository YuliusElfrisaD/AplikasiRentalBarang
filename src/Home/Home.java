/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import DataKategori.GuiKategori;
import DataLaporan.GuiLaporan;
import DataPelanggan.GuiPelanggan;
import DataSatuan.GuiSatuan;
import Databarang.GUIBarang;
import Transaksi.Gui_Transaksi;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Background;
import javax.swing.*;

/**
 *
 * @author core
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form BerandakartuStok
     */
    public Home() {
        initComponents();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        Tanggal_sekarang();
        jamDigital();
             
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new BackgroundImage();
        jPanel2 = new TransparanPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new TransparanPanel();
        buttinSatuan = new javax.swing.JButton();
        buttonKategori = new javax.swing.JButton();
        buttonBarang = new javax.swing.JButton();
        buttonPelanggan = new javax.swing.JButton();
        buttonTransaksi = new javax.swing.JButton();
        buttonLaporan = new javax.swing.JButton();
        jPanel4 = new TransparanPanel();
        lbl_jam = new javax.swing.JLabel();
        lbl_tanggal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Rental");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1_2.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Goudy Old Style", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Aplikasi Rental Barang");

        jLabel11.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Digunakan untuk mencatat transaksi pinjaman barang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Transaksi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Goudy Old Style", 1, 18))); // NOI18N
        jPanel3.setLayout(new java.awt.GridBagLayout());

        buttinSatuan.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        buttinSatuan.setText("Satuan");
        buttinSatuan.setPreferredSize(new java.awt.Dimension(200, 200));
        buttinSatuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttinSatuanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttinSatuanMouseExited(evt);
            }
        });
        buttinSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttinSatuanActionPerformed(evt);
            }
        });
        jPanel3.add(buttinSatuan, new java.awt.GridBagConstraints());

        buttonKategori.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        buttonKategori.setText("Kategori");
        buttonKategori.setPreferredSize(new java.awt.Dimension(200, 200));
        buttonKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonKategoriMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonKategoriMouseExited(evt);
            }
        });
        buttonKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKategoriActionPerformed(evt);
            }
        });
        jPanel3.add(buttonKategori, new java.awt.GridBagConstraints());

        buttonBarang.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        buttonBarang.setText("Barang");
        buttonBarang.setPreferredSize(new java.awt.Dimension(200, 200));
        buttonBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonBarangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonBarangMouseExited(evt);
            }
        });
        buttonBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarangActionPerformed(evt);
            }
        });
        jPanel3.add(buttonBarang, new java.awt.GridBagConstraints());

        buttonPelanggan.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        buttonPelanggan.setText("Pelanggan");
        buttonPelanggan.setPreferredSize(new java.awt.Dimension(200, 200));
        buttonPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonPelangganMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonPelangganMouseExited(evt);
            }
        });
        buttonPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPelangganActionPerformed(evt);
            }
        });
        jPanel3.add(buttonPelanggan, new java.awt.GridBagConstraints());

        buttonTransaksi.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        buttonTransaksi.setText("Transaksi");
        buttonTransaksi.setPreferredSize(new java.awt.Dimension(200, 200));
        buttonTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonTransaksiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonTransaksiMouseExited(evt);
            }
        });
        buttonTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTransaksiActionPerformed(evt);
            }
        });
        jPanel3.add(buttonTransaksi, new java.awt.GridBagConstraints());

        buttonLaporan.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        buttonLaporan.setText("Laporan");
        buttonLaporan.setPreferredSize(new java.awt.Dimension(200, 200));
        buttonLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonLaporanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonLaporanMouseExited(evt);
            }
        });
        buttonLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLaporanActionPerformed(evt);
            }
        });
        jPanel3.add(buttonLaporan, new java.awt.GridBagConstraints());

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_jam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_jam.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_jam.setText("// JAM");

        lbl_tanggal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_tanggal.setText("TANGGAL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_tanggal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_jam))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Satuan Barang");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Kategori Barang");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Data Barang");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Data Pelanggan");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Transaksi");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem4.setText("Keluar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Laporan");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Laporan Transaksi");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, 0));
        jMenuItem6.setText("Petunjuk");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void Tanggal_sekarang(){
        java.util.Date sekarang = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat ("dd-MM-yyyy") ;
        lbl_tanggal.setText("Tanggal "+kal.format(sekarang));
    }
    
    public void jamDigital() {
    // ActionListener untuk Keperluan Timer
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        String nol_jam = "";
        String nol_menit = "";
        String nol_detik = "";
        // Membuat Date
        Date dt = new Date();
        // Mengambil nilaj JAM, MENIT, dan DETIK Sekarang
        int nilai_jam = dt.getHours();
        int nilai_menit = dt.getMinutes();
        int nilai_detik = dt.getSeconds();
        // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
        if (nilai_jam <= 9) {
          // Tambahkan "0" didepannya
          nol_jam = "0";
        }
        // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
        if (nilai_menit <= 9) {
          // Tambahkan "0" didepannya
          nol_menit = "0";
        }
        // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
        if (nilai_detik <= 9) {
          // Tambahkan "0" didepannya
          nol_detik = "0";
        }
        // Membuat String JAM, MENIT, DETIK
        String jam = nol_jam + Integer.toString(nilai_jam);
        String menit = nol_menit + Integer.toString(nilai_menit);
        String detik = nol_detik + Integer.toString(nilai_detik);
        // Menampilkan pada Layar
        lbl_jam.setText("Jam "+jam + ":" + menit + ":" + detik);
      }
    };
    // Timer
    new Timer(1000, taskPerformer).start();
  }
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        new GuiKategori().setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//         TODO add your handling code here:
        new GUIBarang().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new Gui_Transaksi().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        new GuiLaporan().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new GuiKategori().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:

        // optional open a document
        String path = System.getProperty("user.dir") + File.separator + "Images" + File.separator + "../petunjuk.pdf";
        File pdf = new File(path);
        if (pdf.exists()) {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(pdf);
                } catch (IOException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "File tidak bisa dibuka, Apa anda sudah menginstal Adobe Reader untuk membuka file PDF.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "File Tidak ditemukan");
        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        new GuiSatuan().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
         new GuiPelanggan().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void buttonKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKategoriActionPerformed
        // TODO add your handling code here:
        new GuiKategori().setVisible(true);
    }//GEN-LAST:event_buttonKategoriActionPerformed

    private void buttonTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTransaksiActionPerformed
        new Gui_Transaksi().setVisible(true);
    }//GEN-LAST:event_buttonTransaksiActionPerformed

    private void buttinSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttinSatuanActionPerformed
         new GuiSatuan().setVisible(true);
         
         
    }//GEN-LAST:event_buttinSatuanActionPerformed

    private void buttonBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarangActionPerformed
        new GUIBarang().setVisible(true);
        
    }//GEN-LAST:event_buttonBarangActionPerformed

    private void buttonPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPelangganActionPerformed
        new GuiPelanggan().setVisible(true);
    }//GEN-LAST:event_buttonPelangganActionPerformed

    private void buttonLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLaporanActionPerformed
        new GuiLaporan().setVisible(true);
    }//GEN-LAST:event_buttonLaporanActionPerformed

    private void buttinSatuanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttinSatuanMouseEntered
        buttinSatuan.setBackground(Color.gray);
    }//GEN-LAST:event_buttinSatuanMouseEntered

    private void buttinSatuanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttinSatuanMouseExited
        buttinSatuan.setBackground(Color.white);
    }//GEN-LAST:event_buttinSatuanMouseExited

    private void buttonKategoriMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonKategoriMouseExited
       buttonKategori.setBackground(Color.white);
    }//GEN-LAST:event_buttonKategoriMouseExited

    private void buttonKategoriMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonKategoriMouseEntered
       buttonKategori.setBackground(Color.gray);
    }//GEN-LAST:event_buttonKategoriMouseEntered

    private void buttonBarangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBarangMouseEntered
         buttonBarang.setBackground(Color.gray);
    }//GEN-LAST:event_buttonBarangMouseEntered

    private void buttonBarangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBarangMouseExited
         buttonBarang.setBackground(Color.white);
    }//GEN-LAST:event_buttonBarangMouseExited

    private void buttonPelangganMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPelangganMouseEntered
        buttonPelanggan.setBackground(Color.gray);
    }//GEN-LAST:event_buttonPelangganMouseEntered

    private void buttonPelangganMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPelangganMouseExited
        buttonPelanggan.setBackground(Color.white);
    }//GEN-LAST:event_buttonPelangganMouseExited

    private void buttonTransaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTransaksiMouseEntered
        buttonTransaksi.setBackground(Color.gray);
    }//GEN-LAST:event_buttonTransaksiMouseEntered

    private void buttonTransaksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTransaksiMouseExited
        buttonTransaksi.setBackground(Color.white);
    }//GEN-LAST:event_buttonTransaksiMouseExited

    private void buttonLaporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLaporanMouseEntered
        buttonLaporan.setBackground(Color.gray);
    }//GEN-LAST:event_buttonLaporanMouseEntered

    private void buttonLaporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLaporanMouseExited
        buttonLaporan.setBackground(Color.white);
    }//GEN-LAST:event_buttonLaporanMouseExited

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttinSatuan;
    private javax.swing.JButton buttonBarang;
    private javax.swing.JButton buttonKategori;
    private javax.swing.JButton buttonLaporan;
    private javax.swing.JButton buttonPelanggan;
    private javax.swing.JButton buttonTransaksi;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lbl_jam;
    private javax.swing.JLabel lbl_tanggal;
    // End of variables declaration//GEN-END:variables
}
