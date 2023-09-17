package com.store.Booktown.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.Booktown.Model.Cart;


@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {

}
