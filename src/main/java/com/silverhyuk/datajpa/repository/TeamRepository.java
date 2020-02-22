package com.silverhyuk.datajpa.repository;

import com.silverhyuk.datajpa.entity.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class TeamRepository {

    @PersistenceContext
    private EntityManager em;

    public Team save(Team team) {
        em.persist(team);
        return team;
    }

    public void delete(Team team) {
        em.remove(team);
    }

    public List<Team> findAll() {
        List<Team> resultList = em.createQuery("select t from  Team t", Team.class)
                .getResultList();
        return resultList;
    }

    public Optional<Team> findById(Long id) {
        Team Team = em.find(Team.class, id);
        return Optional.ofNullable(Team);
    }

    public long count() {
        Long singleResult = em.createQuery("select count(t) from Team t", Long.class)
                .getSingleResult();
        return singleResult;
    }
}
