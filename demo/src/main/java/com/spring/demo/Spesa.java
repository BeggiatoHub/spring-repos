package com.spring.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Spesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descrizione;
    private BigDecimal importo;
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public BigDecimal getImporto() { return importo; }
    public void setImporto(BigDecimal importo) { this.importo = importo; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Categoria getCategoria() { return categoria; } 
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

}
