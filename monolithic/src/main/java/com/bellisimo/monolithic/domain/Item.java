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

    @Column(nullable = false, name = "category")
    private Category category;

    @JoinColumn(name = "image")
    @OneToOne
    private Image image;

    @Column(nullable = false, name = "hasSpecial")
    private Boolean hasSpecial;

    @JoinColumn (name = "special")
    @ManyToOne
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
        FOOD("Food"),
        CLOTHING("Clothing"),
        UNKNOWN("Unknown");

        private String name;

        Category(String name){ this.name = name; }

        public String getName() {return name;}

        public static Category fromName(String name) {
            for (Category procedureState : Category.values()) {
                if (procedureState.name.equalsIgnoreCase(name)) {
                    return procedureState;
                }
            }
            throw new IllegalArgumentException("No such category: " + name);
        }
    }
   /* public enum Code{
        CLO("CLO"),
        UND("UND"),
        SHO("SHO"),
        MEA("MEA"),
        FRU("FRU"),
        DAI("DAI");


        private String name;

        Code(String name){ this.name = name; }

        public String getName() {return name;}

        public static Category fromName(String name) {
            for (Category procedureState : Category.values()) {
                if (procedureState.name.equalsIgnoreCase(name)) {
                    return procedureState;
                }
            }
            throw new IllegalArgumentException("No such code: " + name);
        }
    }*/
}
