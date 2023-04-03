package br.edu.infnet.atpedronora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atpedronora.model.Endereco;
import br.edu.infnet.atpedronora.repository.EnderecoRepository;
import br.edu.infnet.atpedronora.service.interfaces.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    
    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public void create(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    @Override
    public void update(Integer id, Endereco endereco) {
        endereco.setId(id);
        enderecoRepository.save(endereco);
    }

    @Override
    public void delete(Integer id) {
        Endereco usuarioDeleted = findById(id);
        enderecoRepository.delete(usuarioDeleted);
    }

    @Override
    public Endereco findById(Integer id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    @Override
    public long count() {
        return enderecoRepository.count();
    }

    @Override
    public List<Endereco> findAll() {
        return (List<Endereco>) enderecoRepository.findAll();
    }
}
