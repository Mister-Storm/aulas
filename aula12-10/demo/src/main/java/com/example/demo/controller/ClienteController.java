package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.model.Endereco;
import com.example.demo.service.ClienteService;
import com.example.demo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    public final ClienteService clienteService;
    public final EnderecoService enderecoService;

    @Autowired
    public ClienteController(ClienteService clienteService, EnderecoService enderecoService) {
        this.clienteService = clienteService;
        this.enderecoService = enderecoService;
    }

    @GetMapping("/formulario")
    public String formulario() {
        return "clientes/formulario";
    }

    @GetMapping("/lista")
    public ModelAndView listarUmCliente(Cliente cliente) {
        ModelAndView mv = new ModelAndView("clientes/listar");
        mv.addObject("cliente: ", clienteService.buscaUmCliente(cliente.getId()));
        return mv;
    }

    @GetMapping("/listatodos")
    public ModelAndView listarClientes() {
        ModelAndView mv = new ModelAndView("clientes/listar");
        mv.addObject("clientes", clienteService.buscaTodosOsClientes());
        return mv;
    }

    @PostMapping("/formulario")
    public String salvar(Cliente cliente) {
        clienteService.salvaCliente(cliente);

        return "redirect:/cliente/listatodos";
    }

    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhesCliente(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.buscaUmCliente(id);
        ModelAndView mv = new ModelAndView("clientes/detalhes");
        List<Endereco> enderecos = enderecoService.buscaEnderecoPorCliente(id);
        mv.addObject("enderecos", enderecos);
        mv.addObject("detalhes", cliente);
        return mv;
    }

    @GetMapping("deletar/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return "redirect:/cliente/listatodos";
    }

    @PostMapping("/detalhes/{id}")
    public String salvarEndereco(@PathVariable("id") Long id, Endereco endereco) {
        Cliente cliente = clienteService.buscaUmCliente(id);
        endereco.setCliente(cliente);
        return "redirect:/cliente/listatodos";
    }





}
/* métodos do professor:

    @GetMapping("detalhes/{id}")
    public ModelAndView detalhesCliente(@PathVariable("id") Long id, Endereco endereco) {
        Cliente cliente = clienteSErvice.buscaUmCliente(id);
        ModelAndView mv = new ModelAndView("clientes/listar");
        List<Endereco> enderecos = endereco.Service.buscaEnderecoPorCliente(cliente);
        mv.addObject("enderecos", enderecos);
    }

 */