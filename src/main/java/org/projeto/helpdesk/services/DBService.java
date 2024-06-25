package org.projeto.helpdesk.services;

import org.projeto.helpdesk.domain.Chamado;
import org.projeto.helpdesk.domain.Cliente;
import org.projeto.helpdesk.domain.Tecnico;
import org.projeto.helpdesk.domain.enums.Perfil;
import org.projeto.helpdesk.domain.enums.Prioridade;
import org.projeto.helpdesk.domain.enums.Status;
import org.projeto.helpdesk.repository.ChamadoRepository;
import org.projeto.helpdesk.repository.ClienteRepository;
import org.projeto.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB() {

        Tecnico tec1 = new Tecnico(null, "Rodrigo Camargo", "95502192083", "rodrigo@gmail.com", "123");
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "90566514044", "linus@gmail.com", "123");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }
}
