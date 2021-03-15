/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPelanggan;

/**
 *
 * @author basisc13
 */
public class Pelanggan {
    private String kode;
    private String nama;
    private String email;
    private String telp;
    private String alamat;

    public Pelanggan() {
    
    }

    public Pelanggan(String kode, String nama, String email, String telp, String alamat) {
        this.kode = kode;
        this.nama = nama;
        this.email = email;
        this.telp = telp;
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }
    
    
}
