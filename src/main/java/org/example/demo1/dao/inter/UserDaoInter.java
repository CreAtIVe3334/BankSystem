package org.example.demo1.dao.inter;

import org.example.demo1.dto.CreateUserDto;
import org.example.demo1.entity.User;

public interface UserDaoInter {
    void create(CreateUserDto createUserDto);

    User findId(Long id);
}
