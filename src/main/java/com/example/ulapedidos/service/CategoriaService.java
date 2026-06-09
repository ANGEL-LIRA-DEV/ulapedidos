package com.example.ulapedidos.service;

import com.example.ulapedidos.model.CategoriaModel;
import com.example.ulapedidos.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.ulapedidos.util.UtilConstants.*;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaModel guardar(CategoriaModel categoria){
        return repository.save(categoria);
    }

    public List<CategoriaModel> listar(){
        return repository.findByEstado(CODEPOS);
    }

    public CategoriaModel buscarPorId(Integer id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException(MSG14));
    }

    public CategoriaModel actualizar(Integer id, CategoriaModel request){
        CategoriaModel categoria = buscarPorId(id);
        categoria
                .setNombre(request.getNombre())
                .setDescripcion(request.getDescripcion());
        return repository.save(categoria);
    }

    public void eliminar(Integer id){
        CategoriaModel categoria = buscarPorId(id);
        categoria.setEstado(CODENEG);
        repository.save(categoria);
    }

}
