package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductDAO;
import com.example.demo.modelo.Product;
@Service
public class ProductService implements IProductService {
	@Autowired
	IProductDAO productoDAO;

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return (List<Product>)productoDAO.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		return productoDAO.findById(id).orElse(null);
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productoDAO.deleteById(id);
	}

	@Override
	public Product saveProduct(Product producto) {
		// TODO Auto-generated method stub
		return productoDAO.save(producto);
	}

}
