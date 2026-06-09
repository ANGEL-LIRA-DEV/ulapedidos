package com.example.ulapedidos.service;

import com.example.ulapedidos.model.ClienteModel;
import com.example.ulapedidos.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.ulapedidos.util.UtilConstants.*;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteModel guardar(ClienteModel cliente){
        return repository.save(cliente);
    }

    public List<ClienteModel> listar(){
        return repository.findByEstado(CODEPOS);
    }

    public ClienteModel buscarPorId(Integer id){

        return repository.findById(id).orElseThrow(() -> new RuntimeException(MSG14));

    }

    public ClienteModel actualizar(Integer id, ClienteModel request){

        ClienteModel cliente = buscarPorId(id);
        cliente
                .setNombre(request.getNombre())
                .setApellido(request.getApellido())
                .setTelefono(request.getTelefono())
                .setCorreo(request.getCorreo());

        return repository.save(cliente);

    }

    public void eliminar(Integer id){

        ClienteModel cliente = buscarPorId(id);
        cliente.setEstado(CODENEG);
        repository.save(cliente);

    }

}
