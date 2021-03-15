/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import DataPelanggan.Pelanggan;
import Databarang.Barang;
import java.util.Date;

/**
 *
 * @author Asus a455l
 */
public class Transaksi {
    private String idTransaksi;
    private Date tanggal;
    private Pelanggan idPelangan;
    private int jumlahBarang;
    private long totalHarga;
    private String jaminan;

    public Transaksi() {
    }

    public Pelanggan getIdPelangan() {
        return idPelangan;
    }

    public void setIdPelangan(Pelanggan idPelangan) {
        this.idPelangan = idPelangan;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getJaminan() {
        return jaminan;
    }

    public void setJaminan(String jaminan) {
        this.jaminan = jaminan;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public long getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(long totalHarga) {
        this.totalHarga = totalHarga;
    }        
    
}
