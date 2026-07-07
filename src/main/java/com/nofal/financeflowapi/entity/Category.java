package com.nofal.financeflowapi.entity;

import com.nofal.financeflowapi.enums.CategoryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="categories")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private CategoryType type;

    @OneToMany(mappedBy = "category")
    private List<Transaction> transactions;





}
