package com.win.shop.dto;
import com.win.shop.model.Article;
import com.win.shop.model.Category;
import lombok.Builder;
import lombok.Data;
import java.util.List;
@Builder
@Data
public class CategoryDto {
    private Integer id;
    private String code;
    private String designation;
    private List<Article> articles;

    public CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }


    public Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        return category;
    }
}