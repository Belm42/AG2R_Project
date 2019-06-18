package fr.ag2r.bqm.projetA.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.ag2r.bqm.projetA.entites.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    public Page<Participant> findByNomContainsIgnoreCase(String motCle, Pageable peageable);

}
