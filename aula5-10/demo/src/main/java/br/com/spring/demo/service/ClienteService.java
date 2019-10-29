package br.com.spring.demo.service;


import br.com.spring.demo.entity.Cliente;
import br.com.spring.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

   /* @Autowired
    private ClienteRepository clienteRepository;
     Pode ser feito assim, ou da maneira a seguir, quando há muitos repositories
    */
    private final ClienteRepository clienteRepository; //detalhe -> usar no construtor, todas as variáveis como final

    @Autowired //diz que nesta classe há uma injeção de dependência
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public void cadastrar(Cliente cliente) {
        clienteRepository.save(cliente);
    }



}
