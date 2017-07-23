package com.bellisimo.monolithic.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siphokazi on 2017/07/17.
 */
public class ItemDTO {

    private Long id;
    private String name;
    private String code;
    private Double price;
    private String category;
    private Image image;
    private SpecialDTO special;
    private Boolean hasSpecial;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setSpecial(SpecialDTO special) {
        this.special = special;
    }

    public SpecialDTO getSpecial() {
        return special;
    }

    public void setHasSpecial(Boolean hasSpecial) {
        this.hasSpecial = hasSpecial;
    }

    public Boolean getHasSpecial() {
        return hasSpecial;
    }

}
