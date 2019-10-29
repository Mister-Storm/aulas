package br.com.spring.repository;

import br.com.spring.entity.Cliente;
import br.com.spring.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByCliente(Cliente cliente);

}
