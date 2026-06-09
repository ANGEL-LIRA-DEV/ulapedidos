package com.example.ulapedidos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "categorias")
@Data
@Accessors(chain = true)
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categorias")
    @SequenceGenerator(name = "seq_categorias", sequenceName = "seq_categorias", allocationSize = 1)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private Integer estado = 1;

}
