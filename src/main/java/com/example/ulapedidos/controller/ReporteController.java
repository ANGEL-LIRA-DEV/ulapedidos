package com.example.ulapedidos.controller;

import com.example.ulapedidos.dto.ApiResponse;
import com.example.ulapedidos.repository.DetallePedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.ulapedidos.util.UtilConstants.MSG1;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final DetallePedidoRepository repository;

    @GetMapping("/top-vendidos")
    public ResponseEntity<ApiResponse<?>> topVendidos(){
        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG1,
                        repository.topVendidos()
                )
        );
    }

}
