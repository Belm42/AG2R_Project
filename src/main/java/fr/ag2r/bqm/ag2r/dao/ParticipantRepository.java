package fr.ag2r.bqm.ag2r.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.ag2r.bqm.ag2r.entites.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    public Page<Participant> findByNomContainsIgnoreCase(String motCle, Pageable peageable);

    public List<Participant> findByEvenement(Integer id);

}
