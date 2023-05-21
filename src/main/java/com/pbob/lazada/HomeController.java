package com.pbob.lazada;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * HomeController
 * 
 * @Controller menandakan bahwa class ini adalah controller
 */
 */
@Controller
public class HomeController {
    
    /*
     * @GetMapping("/") menandakan bahwa method home() akan dipanggil ketika user mengakses URL http://localhost:8080/
     */
    @GetMapping("/")
    public String home() {
        // Mengembalikan nama view (halaman web) yang akan ditampilkan, yaitu home.html
        return "home";
    }
    
    /*
     * @GetMapping("/mahasiswa") menandakan bahwa method getMahasiswa() akan dipanggil ketika user mengakses URL http://localhost:8080/mahasiswa
     * 
     * Atribut model digunakan untuk mengirimkan data ke view (halaman web)
     */
    @GetMapping("/mahasiswa")
    public String getMahasiswa(Model model){
        Mahasiswa rahmat = new Mahasiswa(1, "202065002", "Rahmat");

        // Mengirimkan data object 'rahmat' ke view (halaman web). Data tersebut dapat diakses pada view menggunakan nama 'mhs'
        model.addAttribute("mhs", rahmat);

        // Mengembalikan nama view (halaman web) yang akan ditampilkan, yaitu mahasiswa.html
        return "mahasiswa";
    }
}
