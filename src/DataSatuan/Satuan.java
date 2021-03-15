/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSatuan;

import DataKategori.*;

/**
 *
 * @author YULIUS ELFRISA D.
 */
public class Satuan {
    private String kode ;
    private String nama ;

    public Satuan() {

    }

    public Satuan(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
}
