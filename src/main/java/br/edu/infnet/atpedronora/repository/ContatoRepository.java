package br.edu.infnet.atpedronora.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.atpedronora.model.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {
    
}
