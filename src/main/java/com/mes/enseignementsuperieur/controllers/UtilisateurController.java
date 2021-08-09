package com.mes.enseignementsuperieur.controllers;

import com.mes.enseignementsuperieur.Entities.Utilisateur;
import com.mes.enseignementsuperieur.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "utilisateurs")
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<Utilisateur> getUtilisateur()
    {
       return  utilisateurService.getUtilisateur();
    }


    @RequestMapping(value = "utilisateurPost",
            produces = "application/json",
            method =RequestMethod.POST )
    public void registerNewUtilisateur( @RequestBody Utilisateur utilisateur){
        utilisateurService.addNewUtilisateur(utilisateur);
    }
}
