package it.epicode.Esercizio2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Blog")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private Double tempoDiLettura;


}
