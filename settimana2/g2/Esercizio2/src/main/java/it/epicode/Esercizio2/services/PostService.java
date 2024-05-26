package it.epicode.Esercizio2.services;

import it.epicode.Esercizio2.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository post;
}
