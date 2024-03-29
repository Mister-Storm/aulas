package br.com.spring.controller;

import br.com.spring.entity.Cliente;
import br.com.spring.entity.Endereco;
import br.com.spring.service.ClienteService;
import br.com.spring.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final EnderecoService enderecoService;

    @Autowired
    public ClienteController(ClienteService clienteService, EnderecoService enderecoService) {
        this.clienteService = clienteService;
        this.enderecoService = enderecoService;
    }

    @GetMapping("")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("cliente/listar");
        List<Cliente> clientes = clienteService.listarTodosClientes();
        mv.addObject("clientes", clientes);
        return mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView adicionarCliente(Cliente cliente) {
        ModelAndView mv = new ModelAndView("cliente/adicionar");
        mv.addObject("cliente", cliente);
        return mv;
    }

    @PostMapping("/adicionar")
    public ModelAndView adicionar(@Valid Cliente cliente, BindingResult result) {
        if(result.hasErrors()) {
            return adicionarCliente(cliente);
        }
        clienteService.cadastrar(cliente);
        return listar();
    }


    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhes(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.listarUmCliente(id);
        ModelAndView mv = new ModelAndView("cliente/detalhes");
        mv.addObject("detalhes", cliente);
        List<Endereco> enderecos = enderecoService.listarTodosEnderecosCliente(cliente);
        mv.addObject("enderecos", enderecos);
        return mv;
    }



    @GetMapping("/deletar/{id}")
    public ModelAndView deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return listar();
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarCliente (@PathVariable("id") Long id) {
        Cliente cliente = clienteService.listarUmCliente(id);
        return adicionarCliente(cliente);
    }

}
