package it.epicode.Progetto5.repositories;

import it.epicode.Progetto5.entities.Dispositivi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositiviRepository extends JpaRepository<Dispositivi,Long> {
}
