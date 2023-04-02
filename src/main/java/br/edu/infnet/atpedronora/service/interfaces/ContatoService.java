package br.edu.infnet.atpedronora.service.interfaces;

import java.util.List;

import br.edu.infnet.atpedronora.model.Contato;

public interface ContatoService {
    void create(Contato contato);

    void update(Integer id, Contato contato);

    void delete(Integer id);

    Contato findById(Integer id);

    long count();

    List<Contato> findAll();
}
