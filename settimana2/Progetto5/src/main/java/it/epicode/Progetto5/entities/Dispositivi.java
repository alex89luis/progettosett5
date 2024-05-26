package it.epicode.Progetto5.entities;

import it.epicode.Progetto5.enums.StatoDispositivo;
import it.epicode.Progetto5.enums.TipoDispositivo;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "dispositivi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Dispositivi extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendenti dipendenti;
    private TipoDispositivo tipoDispositivo;
    private StatoDispositivo statoDispositivo;

    public Dispositivi(TipoDispositivo tipoDispositivo, StatoDispositivo statoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
        this.statoDispositivo = statoDispositivo;
    }
}
