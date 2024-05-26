package it.epicode.Esercizio2.controller;


import it.epicode.Esercizio2.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/autore")
public class AutoreController {

    @Autowired
    AutoreService autore;
}
