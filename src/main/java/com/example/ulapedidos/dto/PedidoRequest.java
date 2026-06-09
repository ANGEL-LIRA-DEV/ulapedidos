package com.example.ulapedidos.dto;

import lombok.Data;
import java.util.List;

@Data
public class PedidoRequest {
    private Integer idCliente;
    private List<ProductoPedidoDTO> productos;
}
