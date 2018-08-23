package com.company.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAll();
}
