package org.example.demo1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceChange {
    private String fromNumber;
    private Double money;
    private String toNumber;
}
