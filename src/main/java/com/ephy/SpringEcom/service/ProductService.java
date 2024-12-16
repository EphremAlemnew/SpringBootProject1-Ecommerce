package com.ephy.SpringEcom.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ephy.SpringEcom.model.Products;
import com.ephy.SpringEcom.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Products> getAllProducts() {
        return productRepo.findAll();
    }

    public Products getProductById(int id) {
       return productRepo.findById(id).orElse(new Products(-1));
    }

  

    public Products addorUpdateProduct(Products product, MultipartFile image) throws IOException {

        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return productRepo.save(product);
    }

    public void deleteProduct(int id) {
       productRepo.deleteById(id);
    }

    public List<Products> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }

    

    


}
