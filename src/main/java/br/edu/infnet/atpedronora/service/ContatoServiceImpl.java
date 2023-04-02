package br.edu.infnet.atpedronora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atpedronora.model.Contato;
import br.edu.infnet.atpedronora.repository.ContatoRepository;
import br.edu.infnet.atpedronora.service.interfaces.ContatoService;

@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    @Override
    public void create(Contato contato) {
        contatoRepository.save(contato);
    }

    @Override
    public void update(Integer id, Contato contato) {
        contato.setId(id);
        contatoRepository.save(contato);
    }

    @Override
    public void delete(Integer id) {
        Contato usuarioDeleted = findById(id);
        contatoRepository.delete(usuarioDeleted);
    }

    @Override
    public Contato findById(Integer id) {
        return contatoRepository.findById(id).orElse(null);
    }

    @Override
    public long count() {
        return contatoRepository.count();
    }

    @Override
    public List<Contato> findAll() {
        return (List<Contato>) contatoRepository.findAll();
    }
}
