package com.pbob.lazada.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductService
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product getById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public Product update(Long id, Product product){
        Product product_lama = productRepository.findById(id).orElse(null);

        product_lama.setNama(product.getNama());
        product_lama.setDeskripsi(product.getDeskripsi());
        product_lama.setBrand(product.getBrand());
        product_lama.setStok(product.getStok());
        product_lama.setHarga(product.getHarga());

        return productRepository.save(product_lama);
    }
    
}