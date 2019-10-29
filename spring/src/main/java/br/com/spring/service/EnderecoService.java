package br.com.spring.service;

import br.com.spring.entity.Cliente;
import br.com.spring.entity.Endereco;
import br.com.spring.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void salvarEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public List<Endereco> listarTodosEnderecosCliente(Cliente cliente) {
        return enderecoRepository.findByCliente(cliente);
    }

}
