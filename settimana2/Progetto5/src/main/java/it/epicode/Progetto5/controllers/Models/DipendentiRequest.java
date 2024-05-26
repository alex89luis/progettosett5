package it.epicode.Progetto5.controllers.Models;


import jakarta.validation.constraints.NotNull;

public record DipendentiRequest(
      @NotNull(message = "lo username è obbligatorio")
        String username,
      @NotNull(message = "il nome dipendente è obbligatorio")
      String name,
      @NotNull(message = "il cognome è obbligatorio")
      String cognome,
      @NotNull(message = "L'indirizzo email non è corretto")
      String email

) {
}
