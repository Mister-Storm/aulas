package com.example.demo.mapper;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {

    private ClienteMapper(){
        super();
    }

    public static ClienteDTO toclienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setIdade(cliente.getIdade());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setProfissao(cliente.getProfissao());
        clienteDTO.setSobrenome(cliente.getSobrenome());
        clienteDTO.setTelefone(cliente.getTelefone());

        return clienteDTO;
    }

    public static Cliente toCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setIdade(clienteDTO.getIdade());
        cliente.setNome(clienteDTO.getNome());
        cliente.setProfissao(clienteDTO.getProfissao());
        cliente.setSobrenome(clienteDTO.getSobrenome());
        cliente.setTelefone(clienteDTO.getTelefone());

        return cliente;
    }

    public static List<ClienteDTO> toListClienteDTO(List<Cliente> clientes){
        return clientes.stream().map(ClienteMapper::toclienteDTO)
                .collect(Collectors.toList());
    }

    public static List<Cliente> toListCliente(List<ClienteDTO> clienteDTOS) {
        return clienteDTOS.stream().map(ClienteMapper::toCliente)
                .collect(Collectors.toList());
    }


}


