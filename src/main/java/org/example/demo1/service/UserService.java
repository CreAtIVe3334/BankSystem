package org.example.demo1.service;

import org.example.demo1.dao.impl.UserDaoImpl;
import org.example.demo1.dao.inter.UserDaoInter;
import org.example.demo1.dto.CreateUserDto;

public class UserService {

    private final UserDaoInter createUserDaoInter = new UserDaoImpl();


    public void userSave(CreateUserDto createUserDto){
        createUserDaoInter.create(createUserDto);
    }

}
