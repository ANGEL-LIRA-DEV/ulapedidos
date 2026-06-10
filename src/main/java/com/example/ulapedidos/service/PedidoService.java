package com.example.ulapedidos.service;

import com.example.ulapedidos.dto.DetallePedidoResponseDTO;
import com.example.ulapedidos.dto.PedidoRequest;
import com.example.ulapedidos.dto.PedidoResponseDTO;
import com.example.ulapedidos.dto.ProductoPedidoDTO;
import com.example.ulapedidos.model.ClienteModel;
import com.example.ulapedidos.model.DetallePedidoModel;
import com.example.ulapedidos.model.PedidoModel;
import com.example.ulapedidos.model.ProductoModel;
import com.example.ulapedidos.repository.ClienteRepository;
import com.example.ulapedidos.repository.DetallePedidoRepository;
import com.example.ulapedidos.repository.PedidoRepository;
import com.example.ulapedidos.repository.ProductoRepository;
import com.example.ulapedidos.util.UtilConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static com.example.ulapedidos.util.UtilConstants.*;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;
    private final DetallePedidoRepository detalleRepository;

    @Transactional
    public PedidoModel generarPedido(PedidoRequest request){

        ClienteModel cliente =
                clienteRepository.findById(request.getIdCliente()).orElseThrow(() -> new RuntimeException(MSG15));

        PedidoModel pedido = new PedidoModel();

        pedido.setCliente(cliente);
        pedido.setEstadoPedido(CODE2);
        BigDecimal total = BigDecimal.ZERO;
        pedido = pedidoRepository.save(pedido);

        for(ProductoPedidoDTO item : request.getProductos()){

            ProductoModel producto =
                    productoRepository.findById(item.getIdProducto()).orElseThrow(() -> new RuntimeException(MSG16));

            if(producto.getStock() < item.getCantidad()){
                throw new RuntimeException(MSG17 + producto.getNombre());
            }

            BigDecimal subtotal = producto.getPrecio().multiply(BigDecimal.valueOf(item.getCantidad()));
            total = total.add(subtotal);

            DetallePedidoModel detalle = new DetallePedidoModel();

            detalle.setPedido(pedido);
            detalle.setProducto(producto);
            detalle.setCantidad(item.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setSubtotal(subtotal);

            detalleRepository.save(detalle);

            producto.setStock(producto.getStock() - item.getCantidad());

            productoRepository.save(producto);

        }

        pedido.setTotal(total);

        return pedidoRepository.save(pedido);

    }

    @Transactional
    public void cancelarPedido(Integer idPedido){

        PedidoModel pedido = pedidoRepository.findById(idPedido).orElseThrow(() -> new RuntimeException(MSG18));

        pedido.setEstado(CODENEG);
        pedido.setEstadoPedido(CODE3);

        var detalles = detalleRepository.findByPedidoIdPedido(idPedido);

        for(DetallePedidoModel detalle : detalles){

            ProductoModel producto = detalle.getProducto();
            producto.setStock(producto.getStock() + detalle.getCantidad());

            productoRepository.save(producto);

        }

        pedidoRepository.save(pedido);

    }

    public List<PedidoResponseDTO> listarPedidosPorCliente(Integer idCliente){

        List<PedidoModel> pedidos = pedidoRepository.findByClienteIdClienteAndEstado(idCliente, CODEPOS);

        return pedidos.stream().map(pedidoModel -> {
            PedidoResponseDTO dto = new PedidoResponseDTO();

            dto.setIdPedido(pedidoModel.getIdPedido());
            dto.setFechaPedido(pedidoModel.getFechaPedido());
            dto.setTotal(pedidoModel.getTotal());
            dto.setEstadoPedido(pedidoModel.getEstadoPedido());

            List<DetallePedidoResponseDTO> detallesDTO = pedidoModel.getDetalles().stream()
                    .filter(d -> d.getEstado().equals(CODEPOS))
                    .map(detallePedidoModel -> {

                        DetallePedidoResponseDTO dDTO = new DetallePedidoResponseDTO();

                        dDTO.setIdDetalle(detallePedidoModel.getIdDetalle());
                        dDTO.setIdProducto(detallePedidoModel.getProducto().getIdProducto());
                        dDTO.setNombreProducto(detallePedidoModel.getProducto().getNombre());
                        dDTO.setCantidad(detallePedidoModel.getCantidad());
                        dDTO.setPrecioUnitario(detallePedidoModel.getPrecioUnitario());
                        dDTO.setSubtotal(detallePedidoModel.getSubtotal());

                        return dDTO;

                    }).toList();

            dto.setDetalles(detallesDTO);
            return dto;

        }).toList();

    }

    public List<PedidoResponseDTO> listarTodos(){
        List<PedidoModel> pedidos = pedidoRepository.findAll();
        return mapearAListaDTO(pedidos);
    }

    public List<PedidoResponseDTO> listarPorEstado(Integer estado){
        List<PedidoModel> pedidos = pedidoRepository.findByEstado(estado);
        return mapearAListaDTO(pedidos);
    }

    private List<PedidoResponseDTO> mapearAListaDTO(List<PedidoModel> pedidos){
        return pedidos.stream().map(pedidoModel -> {

            PedidoResponseDTO dto = new PedidoResponseDTO();

            dto.setIdPedido(pedidoModel.getIdPedido());
            dto.setFechaPedido(pedidoModel.getFechaPedido());
            dto.setTotal(pedidoModel.getTotal());
            dto.setEstadoPedido(pedidoModel.getEstadoPedido());
            dto.setIdCliente(pedidoModel.getCliente().getIdCliente());
            dto.setEstado(pedidoModel.getEstado());

            List<DetallePedidoResponseDTO> detallesDTO = pedidoModel.getDetalles().stream()
                    .filter(d -> d.getEstado().equals(CODEPOS))
                    .map(detallePedidoModel -> {

                        DetallePedidoResponseDTO dDto = new DetallePedidoResponseDTO();

                        dDto.setIdDetalle(detallePedidoModel.getIdDetalle());
                        dDto.setIdProducto(detallePedidoModel.getProducto().getIdProducto());
                        dDto.setNombreProducto(detallePedidoModel.getProducto().getNombre());
                        dDto.setCantidad(detallePedidoModel.getCantidad());
                        dDto.setPrecioUnitario(detallePedidoModel.getPrecioUnitario());
                        dDto.setSubtotal(detallePedidoModel.getSubtotal());

                        return dDto;

                    }).toList();

            dto.setDetalles(detallesDTO);
            return dto;

        }).toList();
    }

}
