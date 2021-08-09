package com.mes.enseignementsuperieur.Entities;

import javax.persistence.*;

/**
 * file: Etablissement.java
 * brief: la classe permettant l'implémentation d'un établissment
 * author: djodji Komlan
 */
@Entity
@Table(name = "Etablissement")
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomEtablissment;
    private int anneDecalcul;
    private String typeEtablissement;
    private String codeEtablissement;

    public Etablissement() {
    }

    public Etablissement(Long id, String nomEtablissment, int anneDecalcul, String typeEtablissement, String codeEtablissement)
    {
        this.id = id;
        this.nomEtablissment = nomEtablissment;
        this.anneDecalcul = anneDecalcul;
        this.typeEtablissement = typeEtablissement;
        this.codeEtablissement = codeEtablissement;
    }

    public Etablissement(String nomEtablissment, int anneDecalcul, String typeEtablissement, String codeEtablissement)
    {
        this.nomEtablissment = nomEtablissment;
        this.anneDecalcul = anneDecalcul;
        this.typeEtablissement = typeEtablissement;
        this.codeEtablissement = codeEtablissement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomEtablissment() {
        return nomEtablissment;
    }

    public void setNomEtablissment(String nomEtablissment) {
        this.nomEtablissment = nomEtablissment;
    }

    public int getAnneDecalcul() {
        return anneDecalcul;
    }

    public void setAnneDecalcul(int anneDecalcul) {
        this.anneDecalcul = anneDecalcul;
    }

    public String getTypeEtablissement() {
        return typeEtablissement;
    }

    public void setTypeEtablissement(String typeEtablissement) {
        this.typeEtablissement = typeEtablissement;
    }

    public String getCodeEtablissement() {
        return codeEtablissement;
    }

    public void setCodeEtablissement(String codeEtablissement) {
        this.codeEtablissement = codeEtablissement;
    }

    @Override
    public String toString() {
        return "Etablissement{" +
                "id=" + id +
                ", nomEtablissment='" + nomEtablissment + '\'' +
                ", anneDecalcul=" + anneDecalcul +
                ", typeEtablissement='" + typeEtablissement + '\'' +
                ", codeEtablissement='" + codeEtablissement + '\'' +
                '}';
    }
}
