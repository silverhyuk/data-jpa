package com.silverhyuk.datajpa.repository;

import com.silverhyuk.datajpa.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberJpaRepository {

    @PersistenceContext
    private EntityManager em;

    public Member save(Member member) {

        em.persist(member);
        return member;
    }

    public void delete(Member member) {
        em.remove(member);
    }

    public List<Member> findAll() {
        List<Member> resultList = em.createQuery("select m from  Member m", Member.class)
                .getResultList();
        return resultList;
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    public long count() {
        Long singleResult = em.createQuery("select count(m) from Member m", Long.class)
                .getSingleResult();
        return singleResult;
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
