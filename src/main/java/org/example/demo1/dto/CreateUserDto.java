package org.example.demo1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    private String name;

    private String surname;

    @Column(unique = true)
    private String username;
}
