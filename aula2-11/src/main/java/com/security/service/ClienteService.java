package com.security.service;

import com.security.entity.Cliente;
import com.security.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService (ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes () {
        return clienteRepository.findAll();
    }

    public Cliente SalvarCliente (Cliente cliente) {
        return clienteRepository.save(cliente);
    }


}
