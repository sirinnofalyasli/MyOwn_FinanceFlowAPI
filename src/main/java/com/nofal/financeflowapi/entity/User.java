package com.nofal.financeflowapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private LocalDate createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Budget> budgets;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<SavingGoal> savingGoals;

    
}
