package it.epicode.Progetto5.repositories;

import it.epicode.Progetto5.entities.Dipendenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendentiRepository extends JpaRepository<Dipendenti,Long> {
}
