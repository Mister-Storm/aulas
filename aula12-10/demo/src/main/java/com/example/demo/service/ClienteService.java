package com.example.demo.service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.mapper.ClienteMapper;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
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

    public ClienteDTO buscaUmCliente(Long id) {
        return ClienteMapper.toclienteDTO(clienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado",
                        Cliente.class.getName())));
    }

    public List<ClienteDTO> buscaTodosOsClientes(){ //Exemplo de utilização de DTO
        return ClienteMapper.toListClienteDTO(clienteRepository.findAll());
    }

    public void salvaCliente(ClienteDTO clienteDTO) {
        clienteRepository.save(ClienteMapper.toCliente(clienteDTO));
    }
    public void atualizarCliente(Long id, Cliente cliente) {
        Cliente clienteRetornoDoBanco = ClienteMapper.toCliente(buscaUmCliente(id));
        // pode ser feito com o cliente retorno do banco ou com o cliente somente
        cliente.setId(id);
        clienteRepository.save(cliente);
        //no exemplo do professor não tem esse método. olhar isso...
    }
    public void deletarCliente(Long id) {
        Cliente cliente = ClienteMapper.toCliente(buscaUmCliente(id));
        clienteRepository.delete(cliente);
    }

}
