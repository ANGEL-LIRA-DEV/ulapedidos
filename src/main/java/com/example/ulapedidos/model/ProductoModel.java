package com.example.ulapedidos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Data
@Accessors(chain = true)
public class ProductoModel {

    @Id
    @SequenceGenerator(name = "seq_productos", sequenceName = "seq_productos", allocationSize = 1)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "url_imagen")
    private String urlImagen;

    @Column(name = "estado")
    private Integer estado = 1;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaModel categoria;

}
