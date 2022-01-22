package com.example.demo.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("SELECT s FROM Menu s WHERE s.menuId = ?1")
    Optional<Menu> findById(Long id);


}