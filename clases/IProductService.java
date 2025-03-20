package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Product;

public interface IProductService {
	public List<Product> getProducts();
	public Product getProduct(Long id);
	public void deleteProduct(Long id);
	public Product saveProduct(Product producto);

}
