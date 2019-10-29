package com.example.demo.repository;


import com.example.demo.model.Cliente;
import com.example.demo.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

     List<Endereco> findAllByCliente(Cliente cliente);
}
