package com.bellisimo.monolithic.domain;

import javax.persistence.*;

/**
 * Created by siphokazi on 2017/07/17.
 */

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private Image image;

    @Column(nullable = false)
    private Boolean hasSpecial;

    @Column
    @OneToMany
    private Special special;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void  setName(String name){
        this.name = name;
    }

    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }

    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category = category;
    }

    public Image getImage(){
        return image;
    }
    public void  setImage(Image image){
        this.image = image;
    }

    public Boolean getHasSpecial(){
        return hasSpecial;
    }
    public void setHasSpecial(Boolean hasSpecial){
        this.hasSpecial = hasSpecial;
    }

    public Special getSpecial(){
        return special;
    }
    public void setSpecial(Special special){
        this.special = special;
    }

    public enum Category{
        FOOD,
        CLOTHING,
        UNKNOWN
    }
}
