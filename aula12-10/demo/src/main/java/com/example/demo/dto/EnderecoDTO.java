package com.example.demo.dto;

import com.example.demo.model.Cliente;

import java.io.Serializable;

public class EnderecoDTO implements Serializable {

    private static final long serialVersionID = 17L;
    private Long id;
    private String logradouro;
    private String cidade;
    private String cep;
    private Cliente Cliente;

    public EnderecoDTO () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public com.example.demo.model.Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(com.example.demo.model.Cliente cliente) {
        Cliente = cliente;
    }
}
