package com.pbob.lazada;

import lombok.Data;

/**
 * Mahasiswa
 * 
 * @Data dari Lombok menyatakan bahwa kita tidak perlu lagi mendefinisikan getter dan setter untuk class tersebut karena sudah disediakan secara otomatis oleh Lombok
 */
@Data
public class Mahasiswa {

    int id;
    String nim;
    String nama;

    public Mahasiswa(int id, String nim, String nama) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
    }

    public Mahasiswa() {
    }
}
