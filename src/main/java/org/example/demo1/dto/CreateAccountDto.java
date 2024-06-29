package org.example.demo1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo1.enums.AccountStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDto {
    private String acountNumber;

    private Long userId;
}
