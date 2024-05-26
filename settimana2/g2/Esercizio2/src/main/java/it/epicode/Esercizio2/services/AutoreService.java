package it.epicode.Esercizio2.services;

import it.epicode.Esercizio2.entities.Autore;
import it.epicode.Esercizio2.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AutoreService {
    @Autowired



    private final List<Autore> autore = new ArrayList<>();

    public Autore save(Autore autore) {

        autore.setId(autore.getId());
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        this.autore.add(autore);
        return autore;
    }

}
