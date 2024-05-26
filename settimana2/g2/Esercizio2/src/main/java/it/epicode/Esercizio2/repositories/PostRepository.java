package it.epicode.Esercizio2.repositories;

import it.epicode.Esercizio2.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
