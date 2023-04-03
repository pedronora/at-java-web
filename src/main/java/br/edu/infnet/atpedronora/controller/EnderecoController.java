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
import br.edu.infnet.atpedronora.model.Endereco;
import br.edu.infnet.atpedronora.service.interfaces.EnderecoService;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> create(@RequestBody Endereco endereco) {
        enderecoService.create(endereco);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Integer id, @RequestBody Endereco endereco) {
        enderecoService.update(id, endereco);
        return new ResponseEntity<>(enderecoService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            enderecoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro! " + e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getById(@PathVariable Integer id) {
        return new ResponseEntity<Endereco>(enderecoService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(enderecoService.count(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Endereco>> findAll() {
        return new ResponseEntity<>(enderecoService.findAll(), HttpStatus.OK);
    }
}
