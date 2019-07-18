package fr.ag2r.bqm.projetA.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.ag2r.bqm.projetA.entites.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

    public Page<Evenement> findBynomEvenementContainsIgnoreCase(String motCle, Pageable peageable);

}
