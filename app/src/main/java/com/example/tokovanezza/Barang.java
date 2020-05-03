package com.example.tokovanezza;

public class Barang {
    private String uid;
    private String nama;
    private String harga;
    private String tempat;

    public Barang(String uid, String nama, String harga, String tempat) {
        this.uid = uid;
        this.nama = nama;
        this.harga = harga;
        this.tempat = tempat;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }
}
