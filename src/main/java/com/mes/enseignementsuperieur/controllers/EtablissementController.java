package com.mes.enseignementsuperieur.controllers;

import com.mes.enseignementsuperieur.Entities.Etablissement;
import com.mes.enseignementsuperieur.Services.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * file:EtablissementController.java
 * brief: implémentation de la logique qui interagi avec la logique service.
 * @author djodji
 */

@RestController
@RequestMapping(path = "etablissements")
public class EtablissementController {
    /**
     * brief: instanciation du service etablissement et implémentation
     * d'un constructeur controller qui permet d'utiliser le service de l'établissement.
     *
     */
    private EtablissementService etablissementService;

    @Autowired
    public EtablissementController(EtablissementService etablissementService) {
        this.etablissementService = etablissementService;
    }

    /**
     * la liste des établissements
     * @return
     */
    @GetMapping
    public List<Etablissement> getEtablissment()
    {
       return etablissementService.getEtablissment();
    }

    /**
     * brief: methode permettant d'enrégistrer un nouvel établissement,
     * cette methode faait appele a la methode addNewEtablissement définit dans la classe
     * etablissement Service.
     * @param etablissement un objet etablissement
     */

    @RequestMapping(value = "etablissemntPost",
            produces = "application/json",
            method =RequestMethod.POST )
    public void registerNewEtablissement( @RequestBody Etablissement etablissement) throws IllegalAccessException
    {
        etablissementService.addNewEtablissement(etablissement);
    }

    /**
     * brief: methode permettant de supprimer un établissement par son code.
     * @param id le code enregistrer pour l'établissement.
     */

    @DeleteMapping(path = "{idEtablissement}")
    public void deleteEtablissemenent(@PathVariable("idEtablissement") Long id) throws IllegalAccessException {
        etablissementService.deleteStudent(id);

    }

    /**
     * brief: methode permettant de faire une mise a jour
     * du nom de l'établissement et ou de son type
     * @param id de l'établissement pour lequel on realise la mise a jours.
     * @param nomEtablissment le nouveau nom de l'établissement
     * @param codeEtablissement le nouveau type d'établissement
     */
    @PutMapping(path = "{id}")
    public void updateEtablissement(@PathVariable("id") Long id,
                                    @RequestParam(required = false) String nomEtablissment,
                                    @RequestParam (required = false) String codeEtablissement) throws IllegalAccessException {
        etablissementService.updateEtablissement(id,nomEtablissment,codeEtablissement);
    }

    @PutMapping(path = "{id2}")
    public void updateTypeEtablissement(@PathVariable("id2") Long id,
                                        @RequestParam(required = false) String typeEtablissement) throws IllegalAccessException
    {
        etablissementService.updateTypetablissement(id, typeEtablissement);
    }


}
