package com.mes.enseignementsuperieur;

import com.mes.enseignementsuperieur.Entities.Etablissement;
import com.mes.enseignementsuperieur.Entities.Utilisateur;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@SpringBootApplication
//@RestController //cette anotation permet de faire une affichage json sur l'ecran
public class EnseignementSuperieurApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnseignementSuperieurApplication.class, args);
    }

    @GetMapping("/utilisateurs")
    public List<Utilisateur> listeUtilisateur()
    {
        return List.of(new Utilisateur(
                1L,
                "Morin",
                "Joel",
                "Admin",
                "Morin.joel@gmail.com",
                "abcd1234"
        ));
    }

}
