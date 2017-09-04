package com.bellisimo.monolithic.domain;

import javax.persistence.*;

/**
 * Created by siphokazi on 2017/07/17.
 */

@Entity
@Table( name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "id")
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "code") // don't know if I need to alter the constraint in db migrations or not
    private String code;

    @Column(nullable = false, name = "price")
    private Double price;

    @Column( name = "specialPrice")
    private Double specialPrice;

    @Column(nullable = false, name = "category")
    private String category;

    @JoinColumn(name = "image")
    @OneToOne
    private Image image;

    @Column(nullable = false, name = "hasSpecial")
    private Boolean hasSpecial;


    private Long special;

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

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
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

    public Long getSpecial(){
        return special;
    }
    public void setSpecial(Long special){
        this.special = special;
    }

    public Double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", special='" + special + '\'' +
                ", hasSpecial='" + hasSpecial + '\'' +
                "}";
    }


}
