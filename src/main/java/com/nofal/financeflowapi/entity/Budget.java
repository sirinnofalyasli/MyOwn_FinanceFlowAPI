package com.nofal.financeflowapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="budgets")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal limitAmount;
    private Integer month;
    private Integer year;


    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

}
