package com.store.Booktown.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.Booktown.Model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
