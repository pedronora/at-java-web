package br.edu.infnet.atpedronora;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atpedronora.model.Contato;
import br.edu.infnet.atpedronora.model.Endereco;
import br.edu.infnet.atpedronora.service.interfaces.ContatoService;

@Component
public class ContatoLoader implements ApplicationRunner {

    @Autowired
    ContatoService contatoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Contato contato1 = new Contato("Contato1", "(21) 999999999", "exemplo1@exemplo.com.br",
                LocalDate.parse("01/01/2001", format), "https://at-java-web-s3.s3.amazonaws.com/1.jpg");
        Endereco endereco1 = new Endereco();
        endereco1.setId(1);
        contato1.setEndereco(endereco1);
        contatoService.create(contato1);

        Contato contato2 = new Contato("Contato2", "(21) 999999999", "exemplo2@exemplo.com.br",
                LocalDate.parse("01/01/2002", format), "https://at-java-web-s3.s3.amazonaws.com/2.jpg");
        Endereco endereco2 = new Endereco();
        endereco2.setId(2);
        contato2.setEndereco(endereco2);
        contatoService.create(contato2);

        Contato contato3 = new Contato("Contato3", "(21) 999999999", "exemplo3@exemplo.com.br",
                LocalDate.parse("01/01/2003", format), "https://at-java-web-s3.s3.amazonaws.com/3.jpg");
        Endereco endereco3 = new Endereco();
        endereco3.setId(3);
        contato3.setEndereco(endereco3);
        contatoService.create(contato3);

        System.out.println("\t\n" + contatoService.count() + " contatos adicionados adicionados!");
    }
}
