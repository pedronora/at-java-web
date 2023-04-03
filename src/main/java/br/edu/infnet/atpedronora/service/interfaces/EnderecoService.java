package br.edu.infnet.atpedronora.service.interfaces;

import java.util.List;

import br.edu.infnet.atpedronora.model.Endereco;

public interface EnderecoService {
    void create(Endereco endereco);

    void update(Integer id, Endereco endereco);

    void delete(Integer id);

    Endereco findById(Integer id);

    long count();

    List<Endereco> findAll();
}
