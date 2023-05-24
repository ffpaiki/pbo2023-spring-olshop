package com.pbob.lazada.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ProductController
 */
@Controller
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/")
    public String getAll(Model model) {
        List<Product> products = this.productService.getAll();

        model.addAttribute("dataProduct", products);

        return "product/index";
    }

    @GetMapping("/tambah")
    public String form_tambah(Model model) {
        Product product = new Product();

        model.addAttribute("product", product);

        return "product/tambah";
    }

    @PostMapping("/")
    public String simpan(@ModelAttribute Product product) {
        this.productService.save(product);

        return "redirect:/product/";
    }

    @GetMapping("/edit/{id}")
    public String form_edit(@PathVariable Long id, Model model) {

        Product product = this.productService.getById(id);

        model.addAttribute("product", product);

        return "product/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Product product) {

        this.productService.update( id, product);
        return "redirect:/product/";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {

        this.productService.delete(id);
        return "redirect:/product/";
    }
}