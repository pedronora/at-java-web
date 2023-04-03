package br.edu.infnet.atpedronora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.atpedronora.model.Endereco;
import br.edu.infnet.atpedronora.service.interfaces.EnderecoService;

@Order(1)
@Component
public class EnderecoLoader implements ApplicationRunner {

    @Autowired
    EnderecoService enderecoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Endereco endereco1 = new Endereco("20010-020", "Rua São José", "90", "", "Centro", "Rio de Janeiro", "RJ");
        enderecoService.create(endereco1);

        Endereco endereco2 = new Endereco("20520-200", "Rua José Higino", "115", "", "Centro", "Rio de Janeiro", "RJ");
        enderecoService.create(endereco2);

        Endereco endereco3 = new Endereco("22221-090", "Rua Paulo César de Andrade", "407", "", "Laranjeiras", "Rio de Janeiro", "RJ");
        enderecoService.create(endereco3);

        System.out.println("\t\n" + enderecoService.count() + " enderecos adicionados adicionados!");
    }
}
