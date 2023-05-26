package com.pbob.lazada.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Product
 * @Data digunakan untuk mengenerate getter dan setter secara otomatis
 * @Entity digunakan untuk menyatakan bahwa class Product adalah sebuah entitas 
 * (tabel pada database akan dihasilkan secara otomatis berdasarkan data pada class dengan anotasi @Entity)
 */
@Data
@Entity
public class Product {

    /*
     * @Id menyatakan bahwa atribut id akan digunakan ID pada entitas/class Product
     * @GeneratedValue menyatakann bahwa atribut id akan di generate secara otomatis dengan strategi yang telah ditentukan
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private String deskripsi;
    private String brand;
    private int stok;
    private int harga;

    public Product() {
    }

    public Product(String nama, String deskripsi, String brand, int stok, int harga) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.brand = brand;
        this.stok = stok;
        this.harga = harga;
    }
}