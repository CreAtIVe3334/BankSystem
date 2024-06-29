package org.example.demo1.controller;

import org.example.demo1.dto.CreateUserDto;
import org.example.demo1.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserController {

    private final UserService userService = new UserService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CreateUserDto createUserDto){
        System.out.println("---------TEST Controller----------------------");
       userService.userSave(createUserDto);
    }

    @GET
    public void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("company");
        EntityManager em = emf.createEntityManager();
    }
}
