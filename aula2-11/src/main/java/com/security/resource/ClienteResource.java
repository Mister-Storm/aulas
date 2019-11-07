package com.security.resource;

import com.security.entity.Cliente;
import com.security.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/cliente")
public class ClienteResource {
    private final ClienteService clienteService;

    @Autowired
    public ClienteResource (ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(clienteService.listarClientes(), HttpStatus.OK);
    }

    @PostMapping
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<?> salvar (@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.SalvarCliente(cliente), HttpStatus.OK);
    }






}
