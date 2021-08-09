package com.mes.enseignementsuperieur.Configuration;

import com.mes.enseignementsuperieur.Entities.Etablissement;
import com.mes.enseignementsuperieur.Entities.Utilisateur;
import com.mes.enseignementsuperieur.Repository.EtablissementRepository;
import com.mes.enseignementsuperieur.Repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * file: EnseignementSupConfig.java
 * brief: implémentation de la configustaion generale des entités utilisateurs et etablissement.
 */
@Configuration
public class EnseignementSupConfig {
    /**
     * brief: définition de la configuration de l'entité etablissement
     * @param repositoryConfigEtablissement l'objet repository créé a partir de la etablissement repository
     * @return la liste des différents établissement.
     */
    @Bean
    CommandLineRunner commandLineRunnerEtablissement(EtablissementRepository repositoryConfigEtablissement)
    {
        return args -> {
            Etablissement etablissement1 = new Etablissement(
                "College Stanislas",
                2020,
                "Collège",
                "AB322");

            Etablissement etablissement2 = new Etablissement(
                    "Université Laval",
                    2021,
                    "Universitaire",
                    "AB3872");

            repositoryConfigEtablissement.saveAll(List.of(etablissement1,etablissement2));
        };


        };
    @Bean
    CommandLineRunner commandLineRunnerUtilisateur(UtilisateurRepository repositoryConfigUtilisateur)
    {
        return args -> {
            Utilisateur utilisateur1 = new Utilisateur(
                    "Morin",
                    "Joel",
                    "Admin",
                    "Morin.joel@gmail.com",
                    "abcd1234");

            Utilisateur utilisateur2 = new Utilisateur(
                    "Levesque",
                    "Rose",
                    "User",
                    "levesque.rose@gmail.com",
                    "abcd567");

            repositoryConfigUtilisateur.saveAll(List.of(utilisateur1,utilisateur2));
        };
    }

    }



