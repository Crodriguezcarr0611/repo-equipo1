package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Product;
import com.example.demo.service.IProductService;

@RestController
@RequestMapping("/api/productos")
public class ProductController {
	
	@Autowired
	IProductService productoService;
	
	@GetMapping
	public List<Product> listarProductos(){
		return this.productoService.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product buscarProducto(@PathVariable Long id) {
		return this.productoService.getProduct(id);
	}
	
	
	@PostMapping
	public Product guardarProducto(@RequestBody Product producto) {
		return this.productoService.saveProduct(producto);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarProducto(@PathVariable Long id) {
		this.productoService.deleteProduct(id);
	}
	
	@PutMapping("/{id}")
	public Product actualizarProductos(@PathVariable Long id, @RequestBody Product producto) {
		Product productoActualizado = this.productoService.getProduct(id);
		productoActualizado.setNombre(producto.getNombre());
		productoActualizado.setDescripcion(producto.getDescripcion());
		productoActualizado.setPrecio(producto.getPrecio());
		
		this.productoService.saveProduct(productoActualizado);
		return productoActualizado;
	}
}
