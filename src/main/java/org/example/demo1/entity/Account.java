package org.example.demo1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo1.enums.AccountStatus;

import javax.persistence.*;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String acountNumber;

    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
