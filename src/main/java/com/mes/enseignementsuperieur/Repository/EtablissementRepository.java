package com.mes.enseignementsuperieur.Repository;

import com.mes.enseignementsuperieur.Entities.Etablissement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *file: EtablissementRepository
 * brief, implémentation des interfaces qui seront utiliser par la couche service.
 */

//@Repository
@RepositoryRestResource
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {

    @Query("SELECT E FROM Etablissement E WHERE E.codeEtablissement = ?1")
    Optional<Etablissement>findEtablissementByCodeEtablissement(String codeEtablissement);







}
