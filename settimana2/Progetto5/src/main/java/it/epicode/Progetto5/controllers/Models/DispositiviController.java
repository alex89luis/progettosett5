package it.epicode.Progetto5.controllers.Models;

import it.epicode.Progetto5.entities.Dipendenti;
import it.epicode.Progetto5.entities.Dispositivi;
import it.epicode.Progetto5.services.DispositiviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivi")
public class DispositiviController {

    @Autowired
    private DispositiviService dispositivi;

    @PostMapping
    public ResponseEntity<Dispositivi> saveDispositivi(@Validated @RequestBody DispositiviRequest request){
        Dispositivi salva = dispositivi.save(request);
        return ResponseEntity.ok(salva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivi>updateDispositivi(@PathVariable Long id,@RequestParam@Validated @RequestBody DispositiviRequest request){
        Dispositivi update = dispositivi.update(id,request);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivi> getDispositiviBiId(@PathVariable Long id) {
        Dispositivi dispositivis = dispositivi.findById(id);
        if (dispositivi != null) {
            return ResponseEntity.ok(dispositivis);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Dispositivi>>getAllDipendenti(){
    List<Dispositivi> dispositivis = dispositivi.getAll();
        return ResponseEntity.ok(dispositivis);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteDispositiviById(@PathVariable Long id){
        dispositivi.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{idDipendente}/{idDispositivo}")
    public ResponseEntity<Dispositivi>aggiungiDipendente(@PathVariable Long idDipendente, @PathVariable Long idDispositivo) {
        try {
            Dispositivi dispositivo = dispositivi.assegnaDispositivo(idDipendente, idDispositivo);
            return ResponseEntity.ok(dispositivo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
