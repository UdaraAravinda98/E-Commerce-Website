package com.store.Booktown.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.Booktown.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

}
