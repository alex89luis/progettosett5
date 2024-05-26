package it.epicode.Progetto5.services;


import it.epicode.Progetto5.controllers.Models.DispositiviRequest;
import it.epicode.Progetto5.entities.Dipendenti;
import it.epicode.Progetto5.entities.Dispositivi;

import it.epicode.Progetto5.enums.StatoDispositivo;
import it.epicode.Progetto5.repositories.DispositiviRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DispositiviService {

    @Autowired
    DispositiviRepository dispositivi;

    @Autowired
    DipendentiService dipendente;

    public Dispositivi save(DispositiviRequest d) {
        Dispositivi dispositivo = new Dispositivi(
                d.tipo(),
                d.stato()

        );
        return dispositivi.save(dispositivo);

    }

    public Dispositivi findById(Long id) {
        var d = dispositivi.findById(id);
        return d.orElseThrow();
    }

    public Dispositivi delete(Long id) {
        var c = dispositivi.findById(id);
        dispositivi.deleteById(id);
        return c.orElseThrow();
    }

    public List<Dispositivi> getAll() {
        return dispositivi.findAll();
    }

    public Dispositivi update(Long id, DispositiviRequest d) {
        Dispositivi disp = dispositivi.findById(id).orElseThrow(() -> new RuntimeException("Dispositivo non trovato"));

        disp.setTipoDispositivo(d.tipo());
        disp.setStatoDispositivo(d.stato());

        return dispositivi.save(disp);
    }

    public Dispositivi assegnaDispositivo(Long dipendenteId, Long dispositivoId) {
        Dipendenti dipendenti = dipendente.findById(dipendenteId);
        Dispositivi dispositivo = dispositivi.findById(dispositivoId).orElseThrow();
        if (dispositivo.getStatoDispositivo().equals(StatoDispositivo.DISPONIBILE)) {
            dispositivo.setDipendenti(dipendenti);
            dispositivi.save(dispositivo);
        } else {
            throw new RuntimeException("Non si può assegnare perchè " + dispositivo.getStatoDispositivo());
        }
        return dispositivo;

    }
}




