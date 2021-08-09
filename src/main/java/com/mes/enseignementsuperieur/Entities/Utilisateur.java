package com.mes.enseignementsuperieur.Entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;

/**
 * file:Utilisateur.java
 * brief: classe permettant l'implémentation d'un utilisateur.
 */
@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
    @Id
    @SequenceGenerator(name = "sequence_utilisateur",sequenceName = "sequence_utilisateur",allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_utilisateur")
    private Long id;
    private String nom;
    private String prenom;
    private String role;
    private String email;
    private String motDePasse;

    /**
     * constructeur sans parametre
     */
    public Utilisateur() {
    }

    /**
     * constructeur avec parametre
     */

    public Utilisateur(Long id, String nom, String prenom, String role, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Utilisateur(String nom, String prenom, String role, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}
