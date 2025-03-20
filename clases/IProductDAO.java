package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Product;
@Repository
public interface IProductDAO extends CrudRepository<Product, Long> {

}
