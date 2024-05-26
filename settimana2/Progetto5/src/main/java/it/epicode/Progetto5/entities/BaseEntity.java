package it.epicode.Progetto5.entities;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id_generator", sequenceName = "id_generator")
    private Long id;
}
