package com.mes.enseignementsuperieur.Services;

import com.mes.enseignementsuperieur.Entities.Etablissement;
import com.mes.enseignementsuperieur.Repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EtablissementService {
    /**
     * brief instanciation d'un objet repository;
     * et methode permettant d'obtenir la liste de tous les établissements.
     */

    private EtablissementRepository etablissementRepository;
    @Autowired
    public EtablissementService(EtablissementRepository etablissementRepository) {
        this.etablissementRepository = etablissementRepository;
    }

    public List<Etablissement> getEtablissment()
    {
       return etablissementRepository.findAll();
    }

    /**
     * brief, trouver une établissement par son code,et ajouter un nouvel établissement
     * si ce code existe déja un message est envoyé a l'utilisateur.
     * @param etablissement
     */
    public void addNewEtablissement(Etablissement etablissement) throws IllegalAccessException {
        Optional<Etablissement> etablissementParCode = etablissementRepository.
                findEtablissementByCodeEtablissement(etablissement.getCodeEtablissement());
        if(etablissementParCode.isPresent()){
            throw new IllegalAccessException("Ce code établissemnt "+ etablissement.getCodeEtablissement()+" existe déja, veuillez" +
                    " inscrire un nouveau code");
        }
        etablissementRepository.save(etablissement);

    }

    /**
     * brief: implémentation de la methode de suppression.
     * @param id l'identifiant de l'établissement. si l'établissement n'existe pas dans la base
     *           de données alors une exception est leveé.
     *
     */


    public void deleteStudent(Long id) throws IllegalAccessException {
        etablissementRepository.findById(id);
        boolean exists = etablissementRepository.existsById(id);
        if(!exists)
        {
            throw new IllegalAccessException("l'identifiant établissement " +id+ " n'existe pas.");
        }
        etablissementRepository.deleteById(id);

    }

    /**
     * brief: implémentation de la logique service.
     * @param id
     * @param nomEtablissment
     * @param codeEtablissement
     */
    @Transactional
    public void updateEtablissement(Long id, String nomEtablissment, String codeEtablissement) throws IllegalAccessException
    {
        Etablissement etablissement = etablissementRepository.findById(id).
                orElseThrow(()->new IllegalStateException("Cet Identifiant établissement " +id+ " n'existe pas"));

        if(nomEtablissment !=null &&
        nomEtablissment.length()>0 &&
                !Objects.equals(etablissement.getNomEtablissment(),nomEtablissment))
        {
            etablissement.setNomEtablissment(nomEtablissment);
        }

        if(codeEtablissement !=null &&
        codeEtablissement.length()>0 &&
        !Objects.equals(etablissement.getTypeEtablissement(),codeEtablissement))
        {
            Optional<Etablissement> etablissementParCode = etablissementRepository.
                    findEtablissementByCodeEtablissement(etablissement.getCodeEtablissement());
            if(etablissementParCode.isPresent()){
                throw new IllegalAccessException("Ce code établissemnt "+ etablissement.getCodeEtablissement()+" existe déja, veuillez" +
                        " inscrire un nouveau code");
            }
            etablissement.setCodeEtablissement(codeEtablissement);

        }
    }

    /**
     *brief methode permettant de faire la mise a jour du type d'établissement.
     * @param id
     * @param typeEtablissement
     */
    @Transactional
    public void updateTypetablissement(Long id, String typeEtablissement) throws IllegalAccessException
    {
        Etablissement etablissement2 = etablissementRepository.findById(id).
                orElseThrow(()->new IllegalStateException("Cet Identifiant établissement " +id+ " n'existe pas"));

        if(typeEtablissement !=null &&
                typeEtablissement.length()>0 &&
                !Objects.equals(etablissement2.getTypeEtablissement(),typeEtablissement))
        {
            etablissement2.setTypeEtablissement(typeEtablissement);
        }


    }
}
