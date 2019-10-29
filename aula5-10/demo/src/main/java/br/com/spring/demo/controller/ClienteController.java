package br.com.spring.demo.controller;


import br.com.spring.demo.entity.Cliente;
import br.com.spring.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController (ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/formulario")
    public String formulario() {
        return "cliente/formulario";
    }

    @GetMapping("/lista")
    public ModelAndView listaCliente() {
        ModelAndView mv = new ModelAndView("cliente/listar");
        mv.addObject("clientes", clienteService.listarClientes());
        return mv;
        // return clienteService.listarClientes();
    }

    @PostMapping("/formulario")
    public String cadastrar(Cliente cliente) {
        clienteService.cadastrar(cliente);
        return "redirect:/cliente/lista";
    }



}
