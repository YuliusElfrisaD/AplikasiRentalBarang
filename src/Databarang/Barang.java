/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Databarang;

import DataKategori.Kategori;

/**
 *
 * @author basisc16
 */
public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private Kategori kategori;
    private String satuan;
    private double hargaBarang;
    private double hargasewa;
    private String image;
    

    public Barang() {
    }

    public Barang(String kodeBarang, String namaBarang, Kategori kategori, String satuan, double hargaBarang, double hargaSewa, String image) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.kategori = kategori;
        this.satuan = satuan;   
        this.hargaBarang = hargaBarang;
        this.hargasewa = hargaSewa;  
        this.image = image;
    }

    public double getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public double getHargasewa() {
        return hargasewa;
    }

    public void setHargasewa(double hargasewa) {
        this.hargasewa = hargasewa;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
    
    
}
