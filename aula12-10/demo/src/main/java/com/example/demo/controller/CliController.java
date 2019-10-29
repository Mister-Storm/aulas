package com.example.demo.controller;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cli") // boa prática, nomear tudo, todos os getMapping's
                        // nomear o máximo de endpoints possível
public class CliController {
    private final ClienteService clienteService;

    @Autowired
    public CliController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<?> listaTodosClientes(){ // fica mais "genérica" a informação
        return new ResponseEntity<>(clienteService.buscaTodosOsClientes(),
                HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listaUmCliente(@PathVariable Long id) {
        return new ResponseEntity<>(clienteService.buscaUmCliente(id),
        HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody ClienteDTO clienteDTO){
        clienteService.salvaCliente(clienteDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO){
        clienteDTO.setId(id);
        clienteService.salvaCliente(clienteDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
