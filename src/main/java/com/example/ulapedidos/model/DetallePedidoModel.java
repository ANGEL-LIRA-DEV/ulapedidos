package com.example.ulapedidos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
@Data
@Accessors(chain = true)
public class DetallePedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle")
    @SequenceGenerator(name = "seq_detalle", sequenceName = "seq_detalle_pedido", allocationSize = 1)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoModel producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    @Column(name = "estado")
    private Integer estado = 1;

}
