package org.example.demo1.dao.impl;

import org.example.demo1.dao.inter.UserDaoInter;
import org.example.demo1.dto.CreateUserDto;
import org.example.demo1.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDaoImpl implements UserDaoInter {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("company");
    private static final EntityManager em = emf.createEntityManager();
    @Override
    public void create(CreateUserDto createUserDto) {
        em.getTransaction().begin();
        User user = User.builder()
                .name(createUserDto.getName())
                .surname(createUserDto.getSurname())
                .username(createUserDto.getUsername())
                .build();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public User findId(Long id) {
        return em.find(User.class, id);
    }


}
