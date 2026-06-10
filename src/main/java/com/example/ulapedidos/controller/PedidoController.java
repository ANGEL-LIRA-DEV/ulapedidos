package com.example.ulapedidos.controller;

import com.example.ulapedidos.dto.ApiResponse;
import com.example.ulapedidos.dto.PedidoRequest;
import com.example.ulapedidos.dto.PedidoResponseDTO;
import com.example.ulapedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.ulapedidos.util.UtilConstants.*;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> generarPedido(@RequestBody PedidoRequest request){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG6, service.generarPedido(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> cancelarPedido(@PathVariable Integer id){
        service.cancelarPedido(id);
        return ResponseEntity.ok(new ApiResponse<>(true, MSG7, null));
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<ApiResponse<List<PedidoResponseDTO>>> listarPorCLiente(@PathVariable Integer idCliente){
        List<PedidoResponseDTO> pedidos = service.listarPedidosPorCliente(idCliente);
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1, pedidos));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PedidoResponseDTO>>> listarTodos(){
        List<PedidoResponseDTO> lista = service.listarTodos();
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1, lista));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<ApiResponse<List<PedidoResponseDTO>>> listarPorEstado(@PathVariable Integer estado){
        List<PedidoResponseDTO> lista = service.listarPorEstado(estado);
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1, lista));
    }

}
