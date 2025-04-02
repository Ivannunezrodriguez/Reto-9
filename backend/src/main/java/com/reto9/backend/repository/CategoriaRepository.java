// CategoriaRepository.java
package com.reto9.repository;

import com.reto9.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
