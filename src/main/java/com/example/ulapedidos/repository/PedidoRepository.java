package com.example.ulapedidos.repository;

import com.example.ulapedidos.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {

    List<PedidoModel> findByClienteIdClienteAndEstado(Integer idCLiente, Integer estado);
    List<PedidoModel> findByEstado(Integer estado);

}
