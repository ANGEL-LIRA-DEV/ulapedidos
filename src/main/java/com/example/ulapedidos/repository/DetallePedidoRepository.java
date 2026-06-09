package com.example.ulapedidos.repository;

import com.example.ulapedidos.dto.TopProductoDTO;
import com.example.ulapedidos.model.DetallePedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedidoModel, Integer> {

    List<DetallePedidoModel> findByPedidoIdPedido(
            Integer idPedido);

    @Query("""
            SELECT new com.example.ulapedidos.dto.TopProductoDTO(
            d.producto.nombre,
            SUM(d.cantidad)
            )
            FROM DetallePedidoModel d
            WHERE d.estado = 1
            GROUP BY d.producto.nombre
            ORDER BY SUM(d.cantidad) DESC
            """)

    List<TopProductoDTO> topVendidos();

}
