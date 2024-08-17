package com.win.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Category extends AbstractEntity{

    private String code;
    private String designation;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
