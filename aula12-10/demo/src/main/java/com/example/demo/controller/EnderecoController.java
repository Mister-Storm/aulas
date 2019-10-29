package com.example.demo.controller;

import com.example.demo.model.Endereco;
import com.example.demo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EnderecoController {
    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    public void salvarEndereco(Endereco endereco) {
        enderecoService.salvarEndereco(endereco);
    }
}
