package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Endereco;
import com.example.demo.repository.EnderecoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final ClienteService clienteService;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository, ClienteService clienteService) {
        this.enderecoRepository = enderecoRepository;
        this.clienteService = clienteService;
    }

    public Endereco buscaUmEndereco(Long id) {
        return enderecoRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Endereco não encontrado", Endereco.class.getName()));
    }
    public List <Endereco> buscaEnderecoPorCliente(Long id) {
        return enderecoRepository.findAllByCliente(clienteService.buscaUmCliente(id));
    }

    public void salvarEndereco (Endereco endereco) {
        enderecoRepository.save(endereco);
    }
}
