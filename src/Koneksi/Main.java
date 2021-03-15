/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

/**
 *
 * @author Asus a455l
 */
public class Main {
    public static void main(String[] args) {
        koneksiOracle k = new koneksiOracle();
//        Cara_CreateStatement cs = new Cara_CreateStatement(k.getKoneksiOracleDB());
//        cs.InsertdataLoginCreateStatement();
//        cs.UpdateLoginCreateStatement();
//        cs.DeleteLoginCreateStatement();
//        cs.tampilLoginCreateStatement();

        Cara_PreparedStatement cp = new Cara_PreparedStatement(k.getKoneksiOracleDB());
        cp.tampilLoginPrepareStatement();
//        cp.InsertdataLoginPrepareStatement();
//        cp.UpdateLoginPrepareStatement();
//        cp.DeleteLoginPrepareStatement();
    }
}
