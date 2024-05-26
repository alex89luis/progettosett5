package it.epicode.Progetto5.controllers;

import it.epicode.Progetto5.controllers.Models.DipendentiRequest;
import it.epicode.Progetto5.entities.Dipendenti;
import it.epicode.Progetto5.services.DipendentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiControllers {

    @Autowired
    private DipendentiService dipendenti;


    @PostMapping
    public ResponseEntity<Dipendenti>saveDipendenti(@Validated @RequestBody DipendentiRequest request){
        Dipendenti salva = dipendenti.save(request);
        return ResponseEntity.ok(salva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dipendenti>updateDipendenti(@PathVariable Long id,@RequestParam@Validated @RequestBody DipendentiRequest request){
        Dipendenti update = dipendenti.update(id,request);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendenti> getDipendentiBiId(@PathVariable Long id) {
        Dipendenti dipendente = dipendenti.findById(id);
        if (dipendente != null) {
            return ResponseEntity.ok(dipendente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Dipendenti>>getAllDipendenti(){
        List<Dipendenti> dipendentis = dipendenti.getAll();
        return ResponseEntity.ok(dipendentis);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteDipendenteById(@PathVariable Long id){
        dipendenti.delete(id);
        return ResponseEntity.noContent().build();
    }
}
