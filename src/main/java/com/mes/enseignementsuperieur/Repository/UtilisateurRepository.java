package com.mes.enseignementsuperieur.Repository;

import com.mes.enseignementsuperieur.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
}
