package com.example.ulapedidos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
@Accessors(chain = true)
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedidos")
    @SequenceGenerator(name = "seq_pedidos", sequenceName = "seq_pedidos", allocationSize = 1)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteModel cliente;

    @Column(name = "fecha_pedido")
    private LocalDateTime fechaPedido =
            LocalDateTime.now();

    private BigDecimal total;

    @Column(name = "estado_pedido")
    private String estadoPedido;

    @Column(name = "estado")
    private Integer estado = 1;

    @Column(name = "fecha_cancelacion")
    private LocalDateTime fechaCancelacion;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<DetallePedidoModel> detalles;

}
