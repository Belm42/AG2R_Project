package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entités.Participants;

/* TODO by Djer : eviter le "s" dans les noms de repository/entité (un repository gère TOUJOURS plusieurs entitées)*/
public interface ParticipantsRepository extends JpaRepository<Participants, Integer> {

    /* TODO by Djer : donner un nom claire à la varialbe "mc" OU rédiger uen JavaDoc !*/
    public Page<Participants> findByNomContainsIgnoreCase(String mc, Pageable peageable);

}
