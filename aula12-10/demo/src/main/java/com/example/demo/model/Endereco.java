package com.example.demo.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logradouro;
    private String cidade;
    private String cep;


    @ManyToOne
    @JoinColumn(name="id_cliente") // salva na tabela só o id do cliente
    private Cliente cliente;
    /*
    @OneToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

     */
       /*
    @ManyToMany
    @JoinTable(name="config_cliente_endereco",
            joinColumns = @JoinColumn(name="id_cliente"),
            inverseJoinColumns = @JoinColumn(name="id_endereco")
    )
     private List<Cliente> clientes =new ArrayList<>();

     */

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



}
