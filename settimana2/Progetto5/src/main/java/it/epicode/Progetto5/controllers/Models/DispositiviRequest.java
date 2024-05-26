package it.epicode.Progetto5.controllers.Models;

import it.epicode.Progetto5.entities.Dipendenti;
import it.epicode.Progetto5.enums.StatoDispositivo;
import it.epicode.Progetto5.enums.TipoDispositivo;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;



public record DispositiviRequest(
        @NotNull(message = "Tipo è obblogatorio")
        TipoDispositivo tipo,
        @NotNull(message = "stato del dispositivo è obbligatorio")
        StatoDispositivo stato
        ) {




}
