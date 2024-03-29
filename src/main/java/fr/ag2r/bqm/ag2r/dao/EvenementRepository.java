package fr.ag2r.bqm.ag2r.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.ag2r.bqm.ag2r.entites.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

    public Page<Evenement> findByNomEvenementContainsIgnoreCase(String motCle, Pageable peageable);

}
