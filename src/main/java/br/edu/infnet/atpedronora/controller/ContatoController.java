package br.edu.infnet.atpedronora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.atpedronora.model.Contato;
import br.edu.infnet.atpedronora.service.interfaces.ContatoService;

@RestController
@RequestMapping("/api/contato")
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> create(@RequestBody Contato contato) {
        contatoService.create(contato);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contato> update(@PathVariable Integer id, @RequestBody Contato contato) {
        contatoService.update(id, contato);
        return new ResponseEntity<>(contatoService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> getById(@PathVariable Integer id) {
        return new ResponseEntity<Contato>(contatoService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(contatoService.count(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contato>> findAll() {
        return new ResponseEntity<>(contatoService.findAll(), HttpStatus.OK);
    }
}
