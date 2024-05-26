package it.epicode.Progetto5.services;

import it.epicode.Progetto5.controllers.Models.DipendentiRequest;
import it.epicode.Progetto5.entities.Dipendenti;
import it.epicode.Progetto5.repositories.DipendentiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class DipendentiService {
@Autowired
    DipendentiRepository dipendenti;

    public Dipendenti save (DipendentiRequest d){
        Dipendenti dipendente = new Dipendenti(
                d.username(),
                d.name(),
                d.cognome(),
                d.email()
        );
        return dipendenti.save(dipendente);
    }

    public Dipendenti findById(Long id){
       var d = dipendenti.findById(id);
        return d.orElseThrow();
    }

    public Dipendenti delete(Long id){
        var c = dipendenti.findById(id);
        dipendenti.deleteById(id);
        return c.orElseThrow();
    }

    public List<Dipendenti>getAll(){
        return dipendenti.findAll();

    }

    public Dipendenti update(Long id, DipendentiRequest dipendente){
       Dipendenti d = dipendenti.findById(id).orElseThrow(()-> new RuntimeException("dipendente non trovato"));
       d.setUsername(dipendente.username());
       d.setName(dipendente.name());
       d.setCognome(dipendente.cognome());
       d.setEmail(dipendente.email());

       return dipendenti.save(d);

    }
}
