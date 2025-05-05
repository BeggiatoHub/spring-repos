package com.spring.demo;

//import com.spring.demo.Spesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpesaRepository extends JpaRepository<Spesa, Long> {
    List<Spesa> findByCategoria(Categoria categoria);
}
