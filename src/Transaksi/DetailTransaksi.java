/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import Databarang.Barang;

/**
 *
 * @author Awenk
 */
public class DetailTransaksi {

    private String id;
    private Transaksi idTransaksi;
    private Barang kodebarang;
    private int jumlahBarang;
    private int lamaPinjam;
    private long totalHarga;

    public DetailTransaksi() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Transaksi getIdTranksai() {
        return idTransaksi;
    }

    public void setIdTranksai(Transaksi idTranksai) {
        this.idTransaksi = idTranksai;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public Barang getKodebarang() {
        return kodebarang;
    }

    public void setKodebarang(Barang kodebarang) {
        this.kodebarang = kodebarang;
    }

    public int getLamaPinjam() {
        return lamaPinjam;
    }

    public void setLamaPinjam(int lamaPinjam) {
        this.lamaPinjam = lamaPinjam;
    }

    public long getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(long totalHarga) {
        this.totalHarga = totalHarga;
    }
    
}
