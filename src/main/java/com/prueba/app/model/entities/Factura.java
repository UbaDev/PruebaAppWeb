package com.prueba.app.model.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    private String fecha;
    private Double monto;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona")
    @JsonBackReference
    private Persona persona;
}
