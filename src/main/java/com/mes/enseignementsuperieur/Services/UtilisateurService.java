package com.mes.enseignementsuperieur.Services;

import com.mes.enseignementsuperieur.Entities.Utilisateur;
import com.mes.enseignementsuperieur.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getUtilisateur()
    {
        return utilisateurRepository.findAll();
    }


    public void addNewUtilisateur(Utilisateur utilisateur) {
        System.out.println(utilisateur);
    }
}
